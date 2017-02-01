package com.coviam.internalapp.hrms.document.controller;

/**
 * Created by shailaja on 25/01/17.
 */
import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.coviam.internalapp.hrms.document.adapter.DocumentDataRetrieval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coviam.internalapp.hrms.document.entity.Document;
import com.coviam.internalapp.hrms.document.service.DocumentService;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class DocumentController {

    @Autowired
    DocumentService docService;

//    @RequestMapping("/")
//    public String index(){
//        return "Hello";
//    }

    @RequestMapping("/document/{customerId}")
    public List<Document> getAllDocument(@PathVariable String customerId){
        return docService.getAllDocument(customerId);
    }

    @RequestMapping("/document/{customerId}/{docId}")
    public Document getDocumentById(@PathVariable String customerId, @PathVariable String docId){

        return docService.getDocumentById(customerId, docId);
    }

    @RequestMapping(value="/document/add/{customerId}",method=RequestMethod.POST)
    public Document createDocument(@PathVariable String customerId, @RequestBody Document docObject){
        return docService.createDocument(docObject);
    }

    @RequestMapping(value="/document/update",method=RequestMethod.PUT)
    public Document  updateDocument(@RequestBody Document docObject){
        return docService.updateDocument(docObject);
    }

    @RequestMapping(value="/document/delete",method=RequestMethod.PUT)
    public Document  deleteDocument(@RequestBody Document docObject){


        return docService.deleteDocument(docObject);
    }

    @RequestMapping("/document/generatepdf/{customerId}/{docId}/{employeeId}")
    public void createPDF(@PathVariable String customerId, @PathVariable String docId, @PathVariable String employeeId, HttpServletRequest request, HttpServletResponse response) throws DocumentException, IOException {


        Document d = docService.getDocumentById(customerId, docId);

        DocumentDataRetrieval docdata = new DocumentDataRetrieval();
        String filename = docdata.DataRetrieval(customerId, docId, employeeId);

       /* try
        {
            TimeUnit.SECONDS.sleep(10);
        }catch(InterruptedException ie)
        {
            //Log message if required.
        }*/


        final ServletContext servletContext = request.getSession().getServletContext();
        final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        final String temperotyFilePath = tempDirectory.getAbsolutePath();

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + filename);

        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(temperotyFilePath + "/index.html")))) {
            writer.write(d.getdocBody());
        }

        try {

            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(temperotyFilePath + "/" + filename + ".pdf"));
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(temperotyFilePath + "/index.html"));
            document.close();


            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos = convertPDFToByteArrayOutputStream(temperotyFilePath + "/" + filename + ".pdf");
            ServletOutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

        private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

            InputStream inputStream = null;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {

                inputStream = new FileInputStream(fileName);
                byte[] buffer = new byte[1024];
                baos = new ByteArrayOutputStream();

                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return baos;
        }

    }


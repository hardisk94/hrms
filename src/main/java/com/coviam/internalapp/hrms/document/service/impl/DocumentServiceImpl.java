package com.coviam.internalapp.hrms.document.service.impl;

/**
 * Created by shailaja on 25/01/17.
 */
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coviam.internalapp.hrms.document.entity.Document;
import com.coviam.internalapp.hrms.document.service.DocumentService;
import com.coviam.internalapp.hrms.document.dao.DocumentRepository;



@Component
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    DocumentRepository docRepository;

    @Override
    public Document createDocument(Document docObject){
        return docRepository.save(docObject);
    }

    @Override
    public Document updateDocument(Document docObject){
        return docRepository.save(docObject);
    }

    @Override
    public Document deleteDocument(Document docObject){
        return docRepository.save(docObject);
    }

    @Override
    public Document getDocumentById(String customerId, String docId){
        Document doc = docRepository.findOneByCustomerIdAndDocId(customerId,docId);
        return doc;
    }

    @Override
    public List<Document> getAllDocument(String customerId){
        return Lists.newArrayList(docRepository.findAll());
    }

    @Override
    public Document createPDF(String customerId, String docId) {
        Document doc = docRepository.findOneByCustomerIdAndDocId(customerId,docId);
        return doc;
    }


}

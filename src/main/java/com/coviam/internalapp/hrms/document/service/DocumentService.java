package com.coviam.internalapp.hrms.document.service;

/**
 * Created by shailaja on 25/01/17.
 */
import java.util.List;
import com.coviam.internalapp.hrms.document.entity.Document;
import org.springframework.stereotype.Service;

@Service
public interface DocumentService {

    Document createDocument(Document docObject);

    Document updateDocument(Document docObject);

    Document deleteDocument(Document docObject);

    Document getDocumentById(String customerId, String docId);

    List<Document> getAllDocument(String customerId);

    Document createPDF(String customerId, String docId);

}


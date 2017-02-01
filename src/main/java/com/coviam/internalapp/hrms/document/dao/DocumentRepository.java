package com.coviam.internalapp.hrms.document.dao;

/**
 * Created by shailaja on 25/01/17.
 */
import com.coviam.internalapp.hrms.document.entity.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends CrudRepository<Document, String> {
    public Document findOneByCustomerIdAndDocId(String customerId, String docId);
}

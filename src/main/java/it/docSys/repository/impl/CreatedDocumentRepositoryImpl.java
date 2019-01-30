package it.docSys.repository.impl;

import it.docSys.model.CreatedDocument;
import it.docSys.repository.CreatedDocumentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CreatedDocumentRepositoryImpl implements CreatedDocumentRepository {

//    @Autowired(required = true)
    private SessionFactory sessionFactory;


    @Override
    public long create(CreatedDocument createdDocument) {
        sessionFactory.getCurrentSession().save(createdDocument);
        return createdDocument.getId();
            }

    @Override
    public void update(long id, CreatedDocument createdDocument) {
        Session session = sessionFactory.getCurrentSession();
        CreatedDocument createdDocument1 = session.byId(CreatedDocument.class).load(id);
        createdDocument1.setAddressee(createdDocument.getAddressee());
//        document1.setApprovingDate(createdDocument.getApprovingDate());
        createdDocument1.setAttachments(createdDocument.getAttachments());
        createdDocument1.setAuthor(createdDocument.getAuthor());
        createdDocument1.setDescription(createdDocument.getDescription());
        createdDocument1.setId(createdDocument.getId());
        createdDocument1.setName(createdDocument.getName());
//        createdDocument1.setRejectionDate(document.getRejectionDate());
//        createdDocument1.setRejectionReason(document.getRejectionReason());
//        createdDocument1.setSubmissionDate(document.getSubmissionDate());
        createdDocument1.setType(createdDocument.getType());
        session.flush();

    }


    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        CreatedDocument createdDocument = session.byId(CreatedDocument.class).load(id);
        session.delete(createdDocument);
    }
}
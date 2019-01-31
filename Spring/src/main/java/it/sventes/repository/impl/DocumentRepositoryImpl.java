package it.sventes.repository.impl;

import it.sventes.model.document.Document;
import it.sventes.repository.DocumentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long create(Document document) {
        sessionFactory.getCurrentSession().save(document);
        return document.getId();
    }

    @Override
    public Document get(long id) {
        return sessionFactory.getCurrentSession().get(Document.class, id);
    }

    @Override
    public List<Document> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Document> cq = cb.createQuery(Document.class);
        Root<Document> root = cq.from(Document.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(long id, Document document) {
    Session session = sessionFactory.getCurrentSession();
    Document document1 = session.byId(Document.class).load(id);
    document1.setAddressee(document.getAddressee());
    document1.setApprovingDate(document.getApprovingDate());
    document1.setAttachments(document.getAttachments());
    document1.setAuthor(document.getAuthor());
    document1.setDescription(document.getDescription());
    document1.setId(document.getId());
    document1.setName(document.getName());
    document1.setRejectionDate(document.getRejectionDate());
    document1.setRejectionReason(document.getRejectionReason());
<<<<<<< HEAD
    document1.setSubmissionDate(document.getSubmissionDate());
=======
    document1.setSendingDate(document.getSendingDate());
>>>>>>> origin
    document1.setType(document.getType());
    session.flush();

    }

    @Override
    public void delete(long id) {
    Session session = sessionFactory.getCurrentSession();
    Document document = session.byId(Document.class).load(id);
    session.delete(document);
    }
}

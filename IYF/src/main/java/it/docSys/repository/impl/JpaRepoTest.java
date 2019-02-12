//package it.docSys.repository.impl;
//
//import it.docSys.model.Document;
//import it.docSys.repository.DocumentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Repository;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class JpaRepoTest implements DocumentRepository {
//
//    @Autowired
//    private ArrayList<Document> documentArrayList;
//    private Document document;
//
//    @Override
//    public long create(Document document) {
//        return document.getId();
//    }
//
//    @Override
//    public Document get(long id) {
//        for (Document doc:documentArrayList)  {
//            if(doc.getId().equals(id)) {
//                document = doc;
//            }
//        }
//        return document;
//    }
//
//    @Override
//    public List<Document> list() {
//        return documentArrayList;
//    }
//
//    @Override
//    public void update(long id, Document document) {
//        document.setAddressee(document.getAddressee());
//        document.setApprovingDate(document.getApprovingDate());
//        document.setAttachments(document.getAttachments());
//        document.setAuthor(document.getAuthor());
//        document.setDescription(document.getDescription());
//        document.setId(document.getId());
//        document.setName(document.getName());
//        document.setRejectionDate(document.getRejectionDate());
//        document.setRejectionReason(document.getRejectionReason());
//        document.setSubmissionDate(document.getSubmissionDate());
//        document.setType(document.getType());
//    }
//
//    @Override
//    public void delete(long id) {
//        for (Document doc:documentArrayList)  {
//            if(doc.getId().equals(id)) {
//                documentArrayList.remove(doc);
//            }
//        }
//
//    }
//
//    @Override
//    public List<Document> findAll() {
//        return documentArrayList;
//    }
//
//    @Override
//    public List<Document> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<Document> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public List<Document> findAllById(Iterable<Long> iterable) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(Document entity) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Document> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public <S extends Document> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Document> List<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public Optional<Document> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public void flush() {
//
//    }
//
//    @Override
//    public <S extends Document> S saveAndFlush(S s) {
//        return null;
//    }
//
//    @Override
//    public void deleteInBatch(Iterable<Document> iterable) {
//
//    }
//
//    @Override
//    public void deleteAllInBatch() {
//
//    }
//
//    @Override
//    public Document getOne(Long aLong) {
//        return null;
//    }
//
//    @Override
//    public <S extends Document> Optional<S> findOne(Example<S> example) {
//        return Optional.empty();
//    }
//
//    @Override
//    public <S extends Document> List<S> findAll(Example<S> example) {
//        return null;
//    }
//
//    @Override
//    public <S extends Document> List<S> findAll(Example<S> example, Sort sort) {
//        return null;
//    }
//
//    @Override
//    public <S extends Document> Page<S> findAll(Example<S> example, Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends Document> long count(Example<S> example) {
//        return 0;
//    }
//
//    @Override
//    public <S extends Document> boolean exists(Example<S> example) {
//        return false;
//    }
//}

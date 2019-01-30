package it.docSys.services.impl;


import it.docSys.model.Document;
import it.docSys.repository.DocumentRepository;
import it.docSys.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

//    private ArrayList<Document> createdDocs = new ArrayList<>();
//    private ArrayList<Document> sentDocs = new ArrayList<>();
//    private ArrayList<Document> approvedDocs = new ArrayList<>();
//    private ArrayList<Document> rejectedDocs = new ArrayList<>();


//    @Autowired
//    public DocumentServiceImpl(DocumentRepository documentRepository) {
//        this.documentRepository = documentRepository;


//    @Override
//    public Page<Document> findAllDocumentsPageable(Pageable pageable) {
//        return documentRepository.findAll(pageable);
//    }
//
//    @Override
//    public void createNewDocument(Document document) {
//        createdDocs.add(document);
//    }
//
//    @Override
//    public void deleteDocument(Document document) {
//        createdDocs.remove(document);
//    }
//
//    @Override
//    public void sendDocument(Document document) {
//        sentDocs.add(document);
//    }
//
//    @Override
//    public void approvedDocument(Document document) {
//        approvedDocs.add(document);
//    }
//
//    @Override
//    public void rejectDocument(Document document) {
//        rejectedDocs.add(document);
//    }
//
//    @Override
//    public Optional<Document> findById(Long id) {
//        return documentRepository.findById(id);
//    }
    @Transactional
    @Override
    public long create(Document document) {
        return documentRepository.create(document);
    }

    @Override
    public Document get(long id) {
        return documentRepository.get(id);
    }

    @Override
    public List<Document> list() {
        return documentRepository.list();
    }

    @Transactional
    @Override
    public void update(long id, Document document) {
    documentRepository.update(id, document);
    }

    @Transactional
    @Override
    public void delete(long id) {
    documentRepository.delete(id);
    }

}


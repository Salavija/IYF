//package it.docSys.services.impl;
//
//import it.docSys.model.CreatedDocument;
//import it.docSys.repository.CreatedDocumentRepository;
//import it.docSys.services.CreatedDocumentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional(readOnly = true)
//public class CreatedDocumentServiceImpl implements CreatedDocumentService {
//
//    @Autowired
//    private CreatedDocumentRepository createdDocumentRepository;
//
//    @Transactional
//    @Override
//    public long create(CreatedDocument createdDocument) {
//        return createdDocumentRepository.create(createdDocument);
//    }
//
//    @Transactional
//    @Override
//    public void update(long id, CreatedDocument createdDocument) {
//    createdDocumentRepository.update(id, createdDocument);
//    }
//
//    @Transactional
//    @Override
//    public void delete(long id) {
//    createdDocumentRepository.delete(id);
//    }
//}

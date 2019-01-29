package it.sventes.services.impl;

import it.sventes.model.document.CreatedDocument;
import it.sventes.repository.CreatedDocumentRepository;
import it.sventes.services.CreatedDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CreatedDocumentServiceImpl implements CreatedDocumentService {

    @Autowired
    private CreatedDocumentRepository createdDocumentRepository;

    @Transactional
    @Override
    public long create(CreatedDocument createdDocument) {
        return createdDocumentRepository.create(createdDocument);
    }

    @Transactional
    @Override
    public void update(long id, CreatedDocument createdDocument) {
    createdDocumentRepository.update(id, createdDocument);
    }

    @Transactional
    @Override
    public void delete(long id) {
    createdDocumentRepository.delete(id);
    }
}

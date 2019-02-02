package it.docSys.services;

import it.docSys.DTO.DocumentDTO;
import it.docSys.model.Document;

import java.util.List;

public interface DocumentService {

    DocumentDTO create(DocumentDTO documentDTO);
    DocumentDTO get(Long id);
    List<DocumentDTO> listAll();
    void update(long id, DocumentDTO documentDTO);
    void delete(long id);
}
package com.document.document.service;

import com.document.document.entity.Document;
import com.document.document.repo.DocumentRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepository repository;

    public DocumentService(DocumentRepository repository) {
        this.repository = repository;
    }

    /**
     * Uploads a document and saves it to the database
     */
    public Document uploadDocument(MultipartFile file, String uploadedBy) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty!");
        }

        String filePath = "uploads/" + file.getOriginalFilename();  // ✅ Set file path here

        Document document = Document.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath)                 // ✅ Save the file path
                .uploadedAt(LocalDateTime.now())
                .uploadedBy(uploadedBy)
                .version(1)
                .fileData(file.getBytes())
                .build();

        return repository.save(document);
    }

    /**
     * Retrieves all documents
     */
    @Cacheable("documents")
    public List<Document> getAllDocuments() {
        return repository.findAll();
    }

    /**
     * Retrieves a document by ID
     */
    @Cacheable(value = "documents", key = "#id")
    public Optional<Document> getDocumentById(Long id) {
        return repository.findById(id);
    }

    /**
     * Deletes a document by ID
     */
    @CacheEvict(value = "documents", key = "#id")
    public void deleteDocument(Long id) {
        repository.deleteById(id);
    }

    /**
     * Downloads a document's content as byte[]
     */
    public byte[] downloadDocument(Long id) {
        Document document = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Document not found"));
        return document.getFileData();
    }
}

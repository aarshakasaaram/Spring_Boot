package com.document.document.controller;

import com.document.document.entity.Document;
import com.document.document.service.DocumentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService service;

    public DocumentController(DocumentService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<Document> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam("uploadedBy") String uploadedBy) throws IOException {
        Document document = service.uploadDocument(file, uploadedBy);
        return ResponseEntity.ok(document);
    }


    /**
     * Retrieves all documents
     */
    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        return ResponseEntity.ok(service.getAllDocuments());
    }

    /**
     * Retrieves a document by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Optional<Document> document = service.getDocumentById(id);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Downloads a document by ID
     */
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long id) {
        Document document = service.getDocumentById(id).orElseThrow(() -> new IllegalArgumentException("Document not found"));
        byte[] fileData = service.downloadDocument(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(document.getType()));
        headers.setContentDispositionFormData("attachment", document.getName());

        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }

    /**
     * Deletes a document by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) {
        service.deleteDocument(id);
        return ResponseEntity.ok("Document deleted successfully!");
    }
}

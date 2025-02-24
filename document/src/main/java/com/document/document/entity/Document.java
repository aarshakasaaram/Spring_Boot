package com.document.document.entity;

import java.time.LocalDateTime;
import lombok.Builder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier

    private String name; // File name
    private String type; // File type (e.g., PDF, JPEG)
    private String filePath; // Path where the file is stored
    private LocalDateTime uploadedAt; // Upload timestamp
    private String uploadedBy; // User who uploaded the file
    private int version; // Document version number
    
    
    @Lob // To store large objects (Binary Large Object - BLOB)
    private byte[] fileData; // Binary file data
}

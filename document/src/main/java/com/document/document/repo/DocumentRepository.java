package com.document.document.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.document.document.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}

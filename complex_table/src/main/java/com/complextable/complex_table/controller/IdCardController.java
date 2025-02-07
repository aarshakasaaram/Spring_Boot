package com.complextable.complex_table.controller;
import com.complextable.complex_table.entities.IdCard;
import com.complextable.complex_table.service.IdCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/idcards")
public class IdCardController {

    @Autowired
    private IdCardService idCardService;

    // Get all IdCards
    @GetMapping("/displayidcard")
    public List<IdCard> getAllIdCards() {
        return idCardService.getAllIdCards();
    }

    // Get an IdCard by ID
    @GetMapping("/displayidcard/{id}")
    public ResponseEntity<IdCard> getIdCardById(@PathVariable Long id) {
        IdCard idCard = idCardService.getIdCardById(id);
        return new ResponseEntity<>(idCard, HttpStatus.OK);
    }

    // Get IdCard by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<IdCard> getIdCardByStudentId(@PathVariable Long studentId) {
        IdCard idCard = idCardService.getIdCardByStudentId(studentId);
        return new ResponseEntity<>(idCard, HttpStatus.OK);
    }

    // Save a new IdCard
    @PostMapping("/addidcard")
    public ResponseEntity<IdCard> saveIdCard(@RequestBody IdCard idCard) {
        IdCard savedIdCard = idCardService.saveIdCard(idCard);
        return new ResponseEntity<>(savedIdCard, HttpStatus.CREATED);
    }

    // Update an existing IdCard
    @PutMapping("/updateidcard/{id}")
    public ResponseEntity<IdCard> updateIdCard(@PathVariable Long id, @RequestBody IdCard idCardDetails) {
        IdCard updatedIdCard = idCardService.updateIdCard(id, idCardDetails);
        return new ResponseEntity<>(updatedIdCard, HttpStatus.OK);
    }

    // Delete an IdCard by ID
    @DeleteMapping("/deleteidcard/{id}")
    public ResponseEntity<Void> deleteIdCard(@PathVariable Long id) {
        idCardService.deleteIdCard(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 No Content response
    }
}

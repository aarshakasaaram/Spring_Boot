package com.complextable.complex_table.service;

import com.complextable.complex_table.entities.IdCard;
import com.complextable.complex_table.repo.IdCardRepo;
import com.complextable.complex_table.entities.Student;
import com.complextable.complex_table.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IdCardService {

    @Autowired
    private IdCardRepo idCardRepo;

    @Autowired
    private StudentRepo studentRepo;

    // Get an IdCard by ID
    public IdCard getIdCardById(Long id) {
        Optional<IdCard> idCard = idCardRepo.findById(id);
        return idCard.orElseThrow(() -> new RuntimeException("IdCard not found with ID: " + id));
    }

    // Get all IdCards
    public List<IdCard> getAllIdCards() {
        return idCardRepo.findAll();  // This method fetches all the IdCards
    }

    // Get the IdCard for a specific student by student ID
    public IdCard getIdCardByStudentId(Long studentId) {
        return idCardRepo.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("No IdCard found for student with ID: " + studentId));
    }

    // Save a new IdCard
    public IdCard saveIdCard(IdCard idCard) {
        Student student = idCard.getStudent();
        if (student != null) {
            student.setIdCard(idCard);
            studentRepo.save(student); // Save the student with the new IdCard
        }
        return idCardRepo.save(idCard);
    }

    // Update an existing IdCard
    public IdCard updateIdCard(Long id, IdCard idCardDetails) {
        IdCard existingIdCard = getIdCardById(id);
        existingIdCard.setCardNumber(idCardDetails.getCardNumber());
        
        // Update the associated Student if needed
        if (idCardDetails.getStudent() != null) {
            Student student = idCardDetails.getStudent();
            existingIdCard.setStudent(student);
            studentRepo.save(student); // Save the updated student
        }

        return idCardRepo.save(existingIdCard);
    }

    // Delete an IdCard by ID
    public void deleteIdCard(Long id) {
        IdCard idCard = getIdCardById(id);

        // If the IdCard has an associated student, remove the link from the student
        if (idCard.getStudent() != null) {
            Student student = idCard.getStudent();
            student.setIdCard(null); // Disassociate the IdCard from the student
            studentRepo.save(student); // Save the student with the updated IdCard link
        }

        // Finally, delete the IdCard
        idCardRepo.deleteById(id);
    }
}

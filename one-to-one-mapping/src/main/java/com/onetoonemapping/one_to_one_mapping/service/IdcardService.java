package com.onetoonemapping.one_to_one_mapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onetoonemapping.one_to_one_mapping.entities.Idcard;
import com.onetoonemapping.one_to_one_mapping.entities.Student;
import com.onetoonemapping.one_to_one_mapping.repo.IdcardRepo;
import com.onetoonemapping.one_to_one_mapping.repo.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class IdcardService {
	


	    @Autowired
	    private IdcardRepo idRepo;

	    @Autowired
	    private StudentRepo stuRepo;

	    public Idcard createIdcard(Idcard idcard) {
	        return idRepo.save(idcard);
	    }

	    public List<Idcard> getAllIdcards() {
	        return idRepo.findAll();
	    }

	    public Idcard getIdcardById(Long id) {
	        return idRepo.findById(id).orElse(null);
	    }

	    public Idcard updateIdcard(Long id, Idcard updatedIdcard) {
	        Optional<Idcard> existingIdcardOpt = idRepo.findById(id);

	        if (existingIdcardOpt.isPresent()) {
	            Idcard existingIdcard = existingIdcardOpt.get();
	            existingIdcard.setBranch(updatedIdcard.getBranch());
	            existingIdcard.setSection(updatedIdcard.getSection());

	            return idRepo.save(existingIdcard);
	        } else {
	            throw new RuntimeException("Idcard not found with ID: " + id);
	        }
	    }

	    @Transactional
	    public void deleteIdcard(Long id) {
	        Optional<Idcard> idcarddetails = idRepo.findById(id);

	        if (idcarddetails.isPresent()) {
	            Idcard idcard = idcarddetails.get();

	            Optional<Student> studetails = stuRepo.findById(idcard.getCardid());
	            if (studetails.isPresent()) {
	                Student stu = studetails.get();
	                stu.setIdCard(null);
	                stuRepo.save(stu);
	            }

	            idRepo.deleteById(id);
	        } else {
	            throw new RuntimeException("Idcard not found with ID: " + id);
	        }
	    }
	}




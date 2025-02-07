	package com.complextable.complex_table.entities;
	
	

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
	import lombok.Getter;
	import lombok.Setter;
	
	@Entity
	@Getter
	@Setter
	public class IdCard {
	    @Id
	    private Long id;
	
	    private String cardNumber;
	
	    // OneToOne relationship with Student, but no @JoinColumn here, since the relationship is owned by Student
	    @OneToOne(mappedBy = "idCard")
	    @JsonIgnore
	    private Student student;
	}
 
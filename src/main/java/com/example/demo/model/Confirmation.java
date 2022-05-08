package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Confirmation {

    @Id
    @GeneratedValue
    @NotNull
    private int id;
    
    @NotBlank
    @Size(max = 20)
    private String name;
    
    @NotBlank
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private long checkDate;
	
}

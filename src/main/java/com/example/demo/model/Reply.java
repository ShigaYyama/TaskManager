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
public class Reply {
	
	@Id
	@GeneratedValue
	private int takeOverId;
	
	@Size(max = 5)
	private int replyId;
	
	@NotBlank
	private String replyMemo;
	
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)	
	private String createDate;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE)	
	private String latestUpdateDate; 
    
	@Size(max = 5)
	private int issuerId;
}

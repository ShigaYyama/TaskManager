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
public class Knowledge {
	
    @Id
    @GeneratedValue
    @NotNull
    private int knowledgeId;
    
    @NotBlank
    @Size(max = 10)
    private String tag;
    
    @Size(max = 5)
    private Long relatedTicketId;
    
    @NotBlank
    private String takeOverMemo;
    
    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private long createDate;
    
    @NotBlank
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private long latestDate;
 
    @Size(max = 1)   
    private String importance;    
    
    @Size(max = 5)
    private Long assignerId;
    
    @Size(max = 5)
    private Long issuerId;
    
    @Size(max = 5)
    private Long assigneeId;
	
}

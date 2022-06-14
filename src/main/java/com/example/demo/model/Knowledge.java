package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Knowledge {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int knowledgeId;
    
    @NotBlank
    @Size(max = 10)
    private String tag;
    
    private Integer relatedTicketId;
    
    @NotBlank
    private String takeOverMemo;
    
    @NotBlank
    @Size(max = 50)
    private String title;

    private Date createDate;
    
    private Date latestUpdateDate;
 
    @Size(max = 1)   
    private String importance;    
    
    private Integer assignerId;
    
    private Integer issuerId;
    
    private Integer assigneeId;
	
}

package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TakeOverTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int takeOverId;
    
    @NotBlank
    @Size(max = 10)
    private String tag;
    
    private Integer relatedTicketId;
    
    @NotBlank
    private String takeOverMemo;
    
    @NotBlank
    @Size(max = 50)
    private String title;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    
    @Size(max = 1)   
    private String importance;
    
    private Date createDate;
    
    private Date latestUpdateDate;
    
    private Integer assignerId;
    
    private Integer issuerId;
    
    private Integer assigneeId;
    
    @Size(max = 1) 
    private String confirmation;
    
    
}

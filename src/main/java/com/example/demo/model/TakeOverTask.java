package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
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
public class TakeOverTask {

    @Id
    @GeneratedValue
    private int takeOverId;
    
    @NotBlank
    @Size(max = 10)
    private String tag;
    
    @Max(10)
    private Integer relatedTicketId;
    
    @NotBlank
    private String takeOverMemo;
    
    @NotBlank
    @Size(max = 50)
    private String title;
    
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private Date startDate;
    
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private Date endDate;
    
    @Size(max = 1)   
    private String importance;
    
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private Date createDate;
    
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private Date latestUpdateDate;
    
    @Max(5)
    private Integer assignerId;
    
    @Max(5)
    private Integer issuerId;
    
    @Max(5)
    private Integer assigneeId;
    
    @Size(max = 1) 
    private String confirmation;
    
    
}

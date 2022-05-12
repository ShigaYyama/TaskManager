package com.example.demo.model;

import java.util.Date;

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
public class TakeOverTask {

    @Id
    @GeneratedValue
    private int takeOverId;
    
    @NotBlank
    @Size(max = 10)
    private String tag;
    
    @Size(max = 10)
    private Long relatedTicketId;
    
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
    
    @NotBlank
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private Date createDate;
    
    @NotBlank
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private Date latestUpdateDate;
    
    @Size(max = 5)
    private Long assignerId;
    
    @Size(max = 5)
    private Long issuerId;
    
    @Size(max = 5)
    private Long assigneeId;
    
    @Size(max = 1)
    private Long confirmation;
    
    
}

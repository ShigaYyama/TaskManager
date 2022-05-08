package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Knowledge;

public interface KnowledgeRepository extends JpaRepository<Knowledge , Integer>  {

}

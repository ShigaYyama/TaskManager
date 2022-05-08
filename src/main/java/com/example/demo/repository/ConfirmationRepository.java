package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Confirmation;

public interface ConfirmationRepository extends JpaRepository<Confirmation , Integer>  {

}

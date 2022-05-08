package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TakeOverTask;

public interface TaskRepository extends JpaRepository<TakeOverTask , Integer> {

}

package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.TakeOverTask;

public interface TaskRepository extends JpaRepository<TakeOverTask , Integer> {
	
	@Query(value = "SELECT * FROM take_over_task WHERE take_over_memo=:takeOverMemo OR related_ticket_id=:relatedTicketId OR issuer_id=:issuerId OR create_date BETWEEN :parseStartDate AND :parseEndDate", nativeQuery = true)
	Collection < TakeOverTask > searchByNameVariable(String takeOverMemo, Integer relatedTicketId,Integer issuerId, Timestamp parseStartDate, Timestamp parseEndDate);
}

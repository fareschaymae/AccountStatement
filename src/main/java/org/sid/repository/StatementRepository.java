package org.sid.repository;

import org.sid.entites.Statement;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StatementRepository extends JpaRepository<Statement, Long>{
	@Transactional
	@Modifying
	@Query("update Account c set c.balance = :balance where c.id = :id")
	public void deposit(@Param("id") Long id,@Param("balance") double balance);
	
	@Transactional
	@Modifying
	@Query("update Account c set c.balance = :balance where c.id = :id")
	public void withdrawal(@Param("id") Long id,@Param("balance") double balance);
}

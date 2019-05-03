package org.sid.repository;

import org.sid.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface AccountRepository extends  JpaRepository<Account, Long>{
	@Transactional
	@Modifying
	@Query("update Account c set c.balance = :balance where c.id = :id")
	public void deposit(@Param("id") Long id,@Param("balance") double balance);
	
	@Transactional
	@Modifying
	@Query("update Account c set c.balance = :balance where c.id = :id")
	public void withdrawal(@Param("id") Long id,@Param("balance") double balance);
}

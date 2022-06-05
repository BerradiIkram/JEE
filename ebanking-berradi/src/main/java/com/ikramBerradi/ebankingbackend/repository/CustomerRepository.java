package com.ikramBerradi.ebankingbackend.repository;

import java.util.List;

import com.ikramBerradi.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("select c from Customer c where c.name like :kw")
	List<Customer> findByNameContains(@Param("kw") String keywords);
}

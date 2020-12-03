package com.udacity.jdnd.course3.critter.repository;


import com.udacity.jdnd.course3.critter.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select distinct c " +
            "from Customer c " +
            "join c.petId p " +
            "where p.petId = :petId")
    public Customer findCustomerByPetId(long petId);
}

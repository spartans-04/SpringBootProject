package com.event.event.repository;

import java.lang.Integer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.event.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register, String>{
    
}
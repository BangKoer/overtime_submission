package com.overtime.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.overtime.demo.model.HolidayDate;

@Repository 
public interface HolidayDateRepository extends JpaRepository<HolidayDate, Integer> {
    
}

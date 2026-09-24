package com.overtime.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "tb_m_holiday_date")
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Data 
public class HolidayDate {
    public HolidayDate(LocalDate holidayDate, String description) {
        this.holidayDate = holidayDate;
        this.description = description;
    }
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate holidayDate;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    
}

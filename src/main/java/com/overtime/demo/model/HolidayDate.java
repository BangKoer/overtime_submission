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
    public HolidayDate(LocalDate holiday_date, String description) {
        this.holiday_date = holiday_date;
        this.description = description;
    }
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate holiday_date;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    
}

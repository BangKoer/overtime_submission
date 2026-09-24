package com.overtime.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "tb_m_user")
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Data 
public class User {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String email;
    private String password;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    
    @OneToOne 
    @JoinColumn(name = "id", referencedColumnName = "id")
    @MapsId 
    private Employee employee;

}

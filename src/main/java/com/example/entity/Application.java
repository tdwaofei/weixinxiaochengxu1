package com.example.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String userId;
    private String applyType;
    private String applyContent;
    private String status = "pending";
    
    @CreationTimestamp
    private LocalDateTime createTime;
    
    @UpdateTimestamp
    private LocalDateTime updateTime;
} 
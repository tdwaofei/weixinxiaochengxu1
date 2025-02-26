package com.example.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "approvals")
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long applicationId;
    private String approverId;
    private String approvalResult;
    private String approvalComments;
    
    @CreationTimestamp
    private LocalDateTime createTime;
} 
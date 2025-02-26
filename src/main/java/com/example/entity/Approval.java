package com.example.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Approval {
    private Long id;
    private Long applicationId;
    private String approverId;
    private String approvalResult;
    private String approvalComments;
    private LocalDateTime createTime;
} 
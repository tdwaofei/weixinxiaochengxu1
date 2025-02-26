package com.example.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Application {
    private Long id;
    private String userId;
    private String applyType;
    private String applyContent;
    private String status = "pending";
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
} 
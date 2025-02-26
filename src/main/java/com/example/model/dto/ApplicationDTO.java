package com.example.model.dto;

import lombok.Data;

@Data
public class ApplicationDTO {
    private Long id;
    private String userId;
    private String applyType;
    private String applyContent;
    private String status;
} 
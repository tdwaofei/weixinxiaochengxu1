package com.example.model.dto;

import lombok.Data;
import java.util.List;

@Data
public class ApplicationDTO {
    private Long id;
    private String orgName;
    private String region;
    private String contactName;
    private String contactPhone;
    private List<String> files;
    private String status;
} 
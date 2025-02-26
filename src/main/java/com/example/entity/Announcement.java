package com.example.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Announcement {
    private Long id;
    private String title;
    private String content;
    private String status = "active";
    private LocalDateTime publishDate;
    private LocalDateTime expireDate;
} 
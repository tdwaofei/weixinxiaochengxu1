package com.example.entity;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Application {
    private Long id;
    private String orgName;        // 机构名称
    private String region;         // 地区
    private String contactName;    // 联系人
    private String contactPhone;   // 联系电话
    private List<String> files;    // 文件URL列表
    private String status = "pending";
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
} 
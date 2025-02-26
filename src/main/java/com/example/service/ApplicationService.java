package com.example.service;

import com.example.model.dto.ApplicationDTO;
import org.springframework.data.domain.Page;

public interface ApplicationService {
    /**
     * 创建新申请
     */
    Long createApplication(ApplicationDTO applicationDTO);
    
    /**
     * 查询用户的申请列表
     */
    Page<ApplicationDTO> getUserApplications(String userId, int page);
} 
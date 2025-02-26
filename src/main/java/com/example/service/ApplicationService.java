package com.example.service;

import com.example.model.dto.ApplicationDTO;
import java.util.List;

public interface ApplicationService {
    /**
     * 创建新申请
     */
    Long createApplication(ApplicationDTO applicationDTO);
    
    /**
     * 查询用户的申请列表
     */
    List<ApplicationDTO> getUserApplications(String userId, int page);
} 
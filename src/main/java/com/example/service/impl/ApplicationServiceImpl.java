package com.example.service.impl;

import com.example.entity.Application;
import com.example.mapper.ApplicationMapper;
import com.example.model.dto.ApplicationDTO;
import com.example.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationMapper applicationMapper;
    private static final Logger log = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Override
    public Long createApplication(ApplicationDTO applicationDTO) {
        try {
            Application application = new Application();
            BeanUtils.copyProperties(applicationDTO, application);
            
            // 设置创建时间和更新时间
            LocalDateTime now = LocalDateTime.now();
            application.setCreateTime(now);
            //application.setUpdateTime(now);
            
            // 设置状态：如果orgName为af则设置为1，否则为0
            application.setStatus(applicationDTO.getOrgName().equals("af") ? 1 : 0);
            
            applicationMapper.insert(application);
            return application.getId();
        } catch (Exception e) {
            // 记录异常信息
            log.error("Error while creating application: ", e);
            throw e; // 重新抛出异常以便Controller捕获
        }
    }

    @Override
    public List<ApplicationDTO> getUserApplications(String orgName, int page) {
        int offset = (page - 1) * 10;
        List<Application> applications = applicationMapper.findByOrgName(orgName, offset, 10);
        return applications.stream().map(app -> {
            ApplicationDTO dto = new ApplicationDTO();
            BeanUtils.copyProperties(app, dto);
            return dto;
        }).collect(Collectors.toList());
    }
}
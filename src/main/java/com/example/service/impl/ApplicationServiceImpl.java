package com.example.service.impl;

import com.example.entity.Application;
import com.example.mapper.ApplicationMapper;
import com.example.model.dto.ApplicationDTO;
import com.example.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationMapper applicationMapper;

    @Override
    public Long createApplication(ApplicationDTO applicationDTO) {
        Application application = new Application();
        BeanUtils.copyProperties(applicationDTO, application);
        applicationMapper.insert(application);
        return application.getId();
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
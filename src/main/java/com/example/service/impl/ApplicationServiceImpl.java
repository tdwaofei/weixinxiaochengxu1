package com.example.service.impl;

import com.example.entity.Application;
import com.example.model.dto.ApplicationDTO;
import com.example.repository.ApplicationRepository;
import com.example.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Override
    public Long createApplication(ApplicationDTO applicationDTO) {
        Application application = new Application();
        BeanUtils.copyProperties(applicationDTO, application);
        application = applicationRepository.save(application);
        return application.getId();
    }

    @Override
    public Page<ApplicationDTO> getUserApplications(String userId, int page) {
        Page<Application> applications = applicationRepository.findByUserIdOrderByCreateTimeDesc(
                userId, PageRequest.of(page - 1, 10));
        return applications.map(app -> {
            ApplicationDTO dto = new ApplicationDTO();
            BeanUtils.copyProperties(app, dto);
            return dto;
        });
    }
} 
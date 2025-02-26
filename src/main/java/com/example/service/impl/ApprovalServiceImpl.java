package com.example.service.impl;

import com.example.entity.Application;
import com.example.entity.Approval;
import com.example.repository.ApplicationRepository;
import com.example.repository.ApprovalRepository;
import com.example.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalRepository approvalRepository;
    private final ApplicationRepository applicationRepository;

    @Override
    @Transactional
    public boolean processApproval(Approval approval) {
        Application application = applicationRepository.findById(approval.getApplicationId())
                .orElseThrow(() -> new RuntimeException("Application not found"));
        
        application.setStatus(approval.getApprovalResult());
        applicationRepository.save(application);
        approvalRepository.save(approval);
        
        return true;
    }
} 
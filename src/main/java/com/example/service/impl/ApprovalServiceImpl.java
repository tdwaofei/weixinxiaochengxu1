package com.example.service.impl;

import com.example.entity.Application;
import com.example.entity.Approval;
import com.example.mapper.ApplicationMapper;
import com.example.mapper.ApprovalMapper;
import com.example.service.ApprovalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
    private final ApprovalMapper approvalMapper;
    private final ApplicationMapper applicationMapper;

    @Override
    @Transactional
    public boolean processApproval(Approval approval) {
        Application application = applicationMapper.findById(approval.getApplicationId());
        if (application == null) {
            throw new RuntimeException("Application not found");
        }
        
        applicationMapper.updateStatus(application.getId(), approval.getApprovalResult());
        approvalMapper.insert(approval);
        
        return true;
    }
} 
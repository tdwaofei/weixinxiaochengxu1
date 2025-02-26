package com.example.service;

import com.example.entity.Approval;

public interface ApprovalService {
    /**
     * 处理审批
     * @param approval 审批信息
     * @return 是否审批成功
     */
    boolean processApproval(Approval approval);
} 
package com.example.controller;

import com.example.entity.*;
import com.example.model.dto.ApplicationDTO;
import com.example.service.ApplicationService;
import com.example.service.ApprovalService;
import com.example.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OA系统控制器
 * 处理申请、审批、公告相关的请求
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")  // 添加跨域支持
@RequiredArgsConstructor
public class OAController {
    private final ApplicationService applicationService;
    private final ApprovalService approvalService;
    private final AnnouncementService announcementService;

    /**
     * 处理新申请的提交
     * @param applicationDTO 申请信息
     * @return 包含申请ID的响应
     */
    @PostMapping("/apply")
    public Map<String, Object> apply(@RequestBody ApplicationDTO applicationDTO) {
        Long id = applicationService.createApplication(applicationDTO);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", id);
        return result;
    }

    /**
     * 处理审批操作
     * @param approval 审批信息
     * @return 审批结果
     */
    @PostMapping("/approve")
    public Map<String, Object> approve(@RequestBody Approval approval) {
        boolean success = approvalService.processApproval(approval);
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        return result;
    }

    /**
     * 分页查询用户的申请列表
     * @param userId 用户ID
     * @param page 页码（从1开始）
     * @return 申请列表数据
     */
    @GetMapping("/applications")
    public Map<String, Object> getApplications(
            @RequestParam String userId,
            @RequestParam(defaultValue = "1") int page) {
        List<ApplicationDTO> applications = applicationService.getUserApplications(userId, page);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("data", applications);
        return result;
    }

    /**
     * 分页查询有效的通知公告
     * @param page 页码（从1开始）
     * @return 公告列表数据
     */
    @GetMapping("/announcements")
    public Map<String, Object> getAnnouncements(@RequestParam(defaultValue = "1") int page) {
        List<Announcement> announcements = announcementService.getActiveAnnouncements(page);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("data", announcements);
        return result;
    }
} 
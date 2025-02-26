package com.example.service;

import com.example.entity.Announcement;
import org.springframework.data.domain.Page;

public interface AnnouncementService {
    /**
     * 获取有效的公告列表
     * @param page 页码
     * @return 分页的公告列表
     */
    Page<Announcement> getActiveAnnouncements(int page);
} 
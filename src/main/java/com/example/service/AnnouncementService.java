package com.example.service;

import com.example.entity.Announcement;
import java.util.List;

public interface AnnouncementService {
    /**
     * 获取有效的公告列表
     * @param page 页码
     * @return 分页的公告列表
     */
    List<Announcement> getActiveAnnouncements(int page);
} 
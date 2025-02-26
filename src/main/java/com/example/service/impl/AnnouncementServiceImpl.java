package com.example.service.impl;

import com.example.entity.Announcement;
import com.example.mapper.AnnouncementMapper;
import com.example.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementMapper announcementMapper;

    @Override
    public List<Announcement> getActiveAnnouncements(int page) {
        int offset = (page - 1) * 10;
        return announcementMapper.findActiveAnnouncements(offset, 10);
    }
} 
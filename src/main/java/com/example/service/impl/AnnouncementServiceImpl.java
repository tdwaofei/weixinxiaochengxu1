package com.example.service.impl;

import com.example.entity.Announcement;
import com.example.repository.AnnouncementRepository;
import com.example.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    @Override
    public Page<Announcement> getActiveAnnouncements(int page) {
        return announcementRepository.findActiveAnnouncements(
                PageRequest.of(page - 1, 10));
    }
} 
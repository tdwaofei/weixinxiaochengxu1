package com.example.repository;

import com.example.entity.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 通知公告数据访问接口
 */
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    /**
     * 查询当前有效的公告
     * 条件：状态为active且未过期（过期时间为空或大于当前时间）
     */
    @Query("SELECT a FROM Announcement a WHERE a.status = 'active' AND (a.expireDate IS NULL OR a.expireDate > CURRENT_TIMESTAMP)")
    Page<Announcement> findActiveAnnouncements(Pageable pageable);
} 
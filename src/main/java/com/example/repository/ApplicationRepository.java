package com.example.repository;

import com.example.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 申请信息数据访问接口
 */
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    /**
     * 根据用户ID查询申请列表
     * 按创建时间倒序排列
     */
    Page<Application> findByUserIdOrderByCreateTimeDesc(String userId, Pageable pageable);
} 
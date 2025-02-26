package com.example.mapper;

import com.example.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnnouncementMapper {
    @Select("SELECT * FROM announcements WHERE status = 'active' " +
            "AND (expire_date IS NULL OR expire_date > NOW()) " +
            "ORDER BY publish_date DESC LIMIT #{offset}, #{limit}")
    List<Announcement> findActiveAnnouncements(@Param("offset") int offset, 
                                             @Param("limit") int limit);
} 
package com.example.mapper;

import com.example.entity.Application;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    @Insert("INSERT INTO applications(user_id, apply_type, apply_content, status) " +
            "VALUES(#{userId}, #{applyType}, #{applyContent}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Application application);

    @Select("SELECT * FROM applications WHERE user_id = #{userId} " +
            "ORDER BY create_time DESC LIMIT #{offset}, #{limit}")
    List<Application> findByUserId(@Param("userId") String userId, 
                                 @Param("offset") int offset, 
                                 @Param("limit") int limit);

    @Select("SELECT * FROM applications WHERE id = #{id}")
    Application findById(Long id);

    @Update("UPDATE applications SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") String status);
} 
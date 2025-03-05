package com.example.mapper;

import com.example.entity.Application;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    @Insert("INSERT INTO applications(org_name, region, contact_name, contact_phone, files, status, create_time, update_time) " +
            "VALUES(#{orgName}, #{region}, #{contactName}, #{contactPhone}, #{files,typeHandler=com.example.handler.StringListTypeHandler}, #{status}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Application application);

    @Select("SELECT * FROM applications WHERE id = #{id}")
    @Results({
        @Result(property = "files", column = "files", 
                typeHandler = com.example.handler.StringListTypeHandler.class)
    })
    Application findById(Long id);

    @Select("SELECT * FROM applications WHERE org_name LIKE CONCAT('%',#{orgName},'%') " +
            "ORDER BY create_time DESC LIMIT #{offset}, #{limit}")
    @Results({
        @Result(property = "files", column = "files", 
                typeHandler = com.example.handler.StringListTypeHandler.class)
    })
    List<Application> findByOrgName(@Param("orgName") String orgName, 
                                  @Param("offset") int offset, 
                                  @Param("limit") int limit);

    @Update("UPDATE applications SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") String status);
}
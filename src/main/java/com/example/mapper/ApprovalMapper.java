package com.example.mapper;

import com.example.entity.Approval;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ApprovalMapper {
    @Insert("INSERT INTO approvals(application_id, approver_id, approval_result, approval_comments) " +
            "VALUES(#{applicationId}, #{approverId}, #{approvalResult}, #{approvalComments})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Approval approval);
} 
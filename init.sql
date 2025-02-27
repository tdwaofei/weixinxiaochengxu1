-- 申请表：存储用户提交的各类申请
CREATE TABLE applications (
    id INT PRIMARY KEY AUTO_INCREMENT,    -- 主键ID
    org_name VARCHAR(100) NOT NULL COMMENT '机构名称',
    region VARCHAR(200) NOT NULL COMMENT '地区',
    contact_name VARCHAR(50) NOT NULL COMMENT '联系人',
    contact_phone VARCHAR(20) NOT NULL COMMENT '联系电话',
    files TEXT COMMENT '文件URL列表',
    status VARCHAR(20) DEFAULT 'pending', -- 申请状态（待审批/已通过/已拒绝）
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 创建时间
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 更新时间
);

-- 审核记录表：存储审批流程的记录
CREATE TABLE approvals (
    id INT PRIMARY KEY AUTO_INCREMENT,    -- 主键ID
    application_id INT NOT NULL,          -- 关联的申请ID
    approver_id VARCHAR(100) NOT NULL,    -- 审批人ID
    approval_result VARCHAR(20) NOT NULL,  -- 审批结果
    approval_comments TEXT,               -- 审批意见
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 审批时间
    FOREIGN KEY (application_id) REFERENCES applications(id)  -- 外键约束
);

-- 通知公告表：存储系统公告信息
CREATE TABLE announcements (
    id INT PRIMARY KEY AUTO_INCREMENT,    -- 主键ID
    title VARCHAR(200) NOT NULL,          -- 公告标题
    content TEXT NOT NULL,                -- 公告内容
    status VARCHAR(20) DEFAULT 'active',  -- 公告状态
    publish_date DATETIME DEFAULT CURRENT_TIMESTAMP,  -- 发布时间
    expire_date DATETIME                  -- 过期时间
); 
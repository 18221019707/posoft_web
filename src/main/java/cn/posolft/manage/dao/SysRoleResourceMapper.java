package cn.posolft.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.posolft.manage.pojo.SysRoleResource;
@Repository
public interface SysRoleResourceMapper {
    int insert(SysRoleResource record);

    int insertSelective(SysRoleResource record);
    
    int insertByList(List<SysRoleResource> records);
    
    int deleteByPrimaryKey(String id);
}
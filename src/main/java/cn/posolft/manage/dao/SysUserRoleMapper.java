package cn.posolft.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.posolft.manage.pojo.SysUserRole;
@Repository
public interface SysUserRoleMapper{
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
    
    int insertByList(List<SysUserRole> records);
    
    int deleteByPrimaryKey(String id);
}
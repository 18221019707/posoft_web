package cn.posolft.manage.dao;

import org.springframework.stereotype.Repository;

import cn.posolft.manage.pojo.SysRole;

@Repository
public interface SysRoleMapper extends BaseMapper<SysRole>{
	
	SysRole selectByPrimaryKey2(String id);
}
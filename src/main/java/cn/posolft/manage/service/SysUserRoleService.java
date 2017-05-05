package cn.posolft.manage.service;

import java.util.List;

import cn.posolft.manage.pojo.SysUserRole;

public interface SysUserRoleService{
	
	public int insert(SysUserRole record);
	
	public int insertSelective(SysUserRole record);
	
	/**
	 * 添加对象
	 * @param id
	 * @return
	 */
	public int insertByList(List<SysUserRole> sysUserRoles);
	/**
	 * 删除实例对象
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(String id);

}

package cn.posolft.manage.service;

import java.util.List;

import cn.posolft.manage.pojo.SysUser;
import cn.posolft.manage.pojo.SysUserRole;

public interface SysUserService extends BaseService<SysUser>{
	/**
	 * 保存用户信息
	 * @param sysUserRoles
	 * @param sysUser
	 */
	public void insertSysUserAndUserRole(List<SysUserRole> sysUserRoles,SysUser sysUser);

}

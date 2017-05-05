package cn.posolft.manage.service;

import java.util.List;

import cn.posolft.manage.pojo.SysRole;
import cn.posolft.manage.pojo.SysRoleResource;

public interface SysRoleService extends BaseService<SysRole>{
	
	/**
	 * 主键查询对象
	 * @param id
	 * @return
	 */
	public SysRole selectByPrimaryKey2(String id);
	/**
	 * 更新角色权限列表
	 * @param sysRoleResources
	 * @param roleId
	 */
	public void updateSysRoleResource(List<SysRoleResource> sysRoleResources,String roleId);

}

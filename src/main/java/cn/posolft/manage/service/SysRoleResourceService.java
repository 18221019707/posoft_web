package cn.posolft.manage.service;

import java.util.List;

import cn.posolft.manage.pojo.SysRoleResource;

public interface SysRoleResourceService{
	
	public int insert(SysRoleResource record);
	
	public int insertSelective(SysRoleResource record);
	
	/**
	 * 添加对象
	 * @param id
	 * @return
	 */
	public int insertByList(List<SysRoleResource> sysRoleResources);
	/**
	 * 删除实例对象
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(String id);

}

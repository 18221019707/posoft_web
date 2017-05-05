package cn.posolft.manage.service;

import java.util.List;

import cn.posolft.manage.pojo.SysResource;

public interface SysResourceService extends BaseService<SysResource>{
	/**
	 * 查询用户拥有URL使用权限
	 * @param userId
	 * @return
	 */
	public List<String> selectUserResource(String userId);

}

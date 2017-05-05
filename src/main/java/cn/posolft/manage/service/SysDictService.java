package cn.posolft.manage.service;

import cn.posolft.manage.pojo.SysDict;

public interface SysDictService extends BaseService<SysDict>{
	/**
	 * 清除缓存
	 */
	public void clearDict();

}

package cn.posolft.manage.service;

import java.util.List;

import cn.posolft.manage.pojo.SysLeftMenu;

public interface SysLeftMenuService extends BaseService<SysLeftMenu>{
	/**
	 * 清除缓存
	 */
	public void clearMenu();
	/**
	 * 清除用户缓存
	 * @param userId
	 */
	public void clearMenu(String userId);
	/**
	 * 获取用户菜单
	 * @param userId
	 * @return
	 */
	public List<SysLeftMenu> selectUserMenu(String userId);
	/**
	 * 获取用户菜单，先从缓存中取，没有调用selectUserMenu获取并保存至缓存
	 * @param userId
	 * @return
	 */
	public List<SysLeftMenu> selectUserMenuByCache(String userId);

}

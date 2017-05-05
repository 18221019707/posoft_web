package cn.posolft.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.posolft.manage.dao.BaseMapper;
import cn.posolft.manage.dao.SysLeftMenuMapper;
import cn.posolft.manage.dao.SysResourceMapper;
import cn.posolft.manage.pojo.SysLeftMenu;
import cn.posolft.manage.pojo.SysResource;
import cn.posolft.manage.service.SysLeftMenuService;

@Service("sysLeftMenuService") 
public class SysLeftMenuServiceImpl extends PosolftBaseServiceImpl<SysLeftMenu> implements SysLeftMenuService {
	@Resource
	private SysLeftMenuMapper sysLeftMenuMapper;
	@Resource
	private SysResourceMapper sysResourceMapper;
	
	private final static Map<String, List<SysLeftMenu>> menu_cache = new HashMap<String, List<SysLeftMenu>>();
	
	@Override
	public BaseMapper<SysLeftMenu> getBaseMapper() {
		return sysLeftMenuMapper;
	}
	@Override
	public void clearMenu() {
		menu_cache.clear();
	}
	
	@Override
	public void clearMenu(String userId) {
		if(menu_cache.containsKey(userId)){
			menu_cache.remove(userId);
		}
	}
	
	@Override
	public List<SysLeftMenu> selectUserMenuByCache(String userId) {
		List<SysLeftMenu> list = menu_cache.get(userId);
		if (list == null) {
			list = selectUserMenu(userId);
			menu_cache.put(userId, list);
		}
		return list;
	}
	
	@Override
	public List<SysLeftMenu> selectUserMenu(String userId) {
		SysLeftMenu sysLeftMenu = new SysLeftMenu();
		sysLeftMenu.setParentId("888888888888888888");
		//获取顶部菜单
		List<SysLeftMenu> sysLeftMenuTops = sysLeftMenuMapper.selectListByT(sysLeftMenu , null);
		List<SysResource> resoureList = sysResourceMapper.selectMapByUserId(userId);
		Map<String, SysResource> resoureMap = new HashMap<String, SysResource>();
		for (SysResource sysResource : resoureList) {
			resoureMap.put(sysResource.getId(), sysResource);
		}
		//移除无权限菜单，保留所有有权限菜单
		List<SysLeftMenu> sysLeftMenus = interate(sysLeftMenuTops,resoureMap);
		return sysLeftMenus;
	}
	
	private List<SysLeftMenu> interate(List<SysLeftMenu> sysLeftMenus,Map<String, SysResource> resoureMap){
		//倒过来遍历，解决正序移除时影响index变化导致错乱
		for (int i = sysLeftMenus.size()-1; i>=0; i--) {
			SysLeftMenu sysLeftMenu = sysLeftMenus.get(i);
			List<SysLeftMenu> sons = sysLeftMenu.getSons();
			if(sons!=null&&sons.size()>0){
				interate(sons,resoureMap);
			}else{
				String resourceId = sysLeftMenu.getResourceId();
				if(!resoureMap.containsKey(resourceId)){
					sysLeftMenus.remove(i);
				}
			}
		}
		return sysLeftMenus;
	}

}

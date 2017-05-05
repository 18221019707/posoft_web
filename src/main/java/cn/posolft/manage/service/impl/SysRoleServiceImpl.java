package cn.posolft.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import cn.posolft.manage.dao.BaseMapper;
import cn.posolft.manage.dao.SysRoleMapper;
import cn.posolft.manage.dao.SysRoleResourceMapper;
import cn.posolft.manage.pojo.SysRole;
import cn.posolft.manage.pojo.SysRoleResource;
import cn.posolft.manage.service.SysRoleService;
@Service("sysRoleService") 
public class SysRoleServiceImpl extends PosolftBaseServiceImpl<SysRole> implements SysRoleService {
	@Resource
	private SysRoleMapper sysRoleMapper;
	@Resource
	private SysRoleResourceMapper sysRoleResourceMapper;
	
	@Override
	public BaseMapper<SysRole> getBaseMapper() {
		return sysRoleMapper;
	}

	@Override
	public SysRole selectByPrimaryKey2(String id) {
		return  sysRoleMapper.selectByPrimaryKey2(id);
	}
	
	@Override
	@Transactional
	public void updateSysRoleResource(List<SysRoleResource> sysRoleResources,String roleId){
		sysRoleResourceMapper.deleteByPrimaryKey(roleId);
		if(sysRoleResources!=null&&sysRoleResources.size()>0){
			sysRoleResourceMapper.insertByList(sysRoleResources);
		}
	}	

}

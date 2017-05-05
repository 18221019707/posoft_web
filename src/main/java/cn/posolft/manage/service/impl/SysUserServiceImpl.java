package cn.posolft.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import cn.posolft.manage.dao.BaseMapper;
import cn.posolft.manage.dao.SysUserMapper;
import cn.posolft.manage.dao.SysUserRoleMapper;
import cn.posolft.manage.pojo.SysUser;
import cn.posolft.manage.pojo.SysUserRole;
import cn.posolft.manage.service.SysUserService;

@Service("sysUserService") 
public class SysUserServiceImpl extends PosolftBaseServiceImpl<SysUser> implements SysUserService {
	@Resource
	private SysUserMapper sysUserMapper;
	@Resource
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public BaseMapper<SysUser> getBaseMapper() {
		return sysUserMapper;
	}
	@Override
	@Transactional
	public void insertSysUserAndUserRole(List<SysUserRole> sysUserRoles,SysUser sysUser){
		sysUserMapper.insert(sysUser);
		if(sysUserRoles!=null&&sysUserRoles.size()>0){
			sysUserRoleMapper.insertByList(sysUserRoles);
		}
	}

}

package cn.posolft.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.posolft.manage.dao.SysUserRoleMapper;
import cn.posolft.manage.pojo.SysUserRole;
import cn.posolft.manage.service.SysUserRoleService;

@Service("sysUserRoleService") 
public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Resource
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public int insert(SysUserRole record) {
		return sysUserRoleMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUserRole record) {
		return sysUserRoleMapper.insertSelective(record);
	}

	@Override
	public int insertByList(List<SysUserRole> sysUserRoles) {
		return sysUserRoleMapper.insertByList(sysUserRoles);
	}
	
	@Override
	public int deleteByPrimaryKey(String id){
		return sysUserRoleMapper.deleteByPrimaryKey(id);
	}
}

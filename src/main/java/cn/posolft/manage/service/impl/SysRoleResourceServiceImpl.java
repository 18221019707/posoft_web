package cn.posolft.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.posolft.manage.dao.SysRoleResourceMapper;
import cn.posolft.manage.pojo.SysRoleResource;
import cn.posolft.manage.service.SysRoleResourceService;

@Service("sysRoleResourceService") 
public class SysRoleResourceServiceImpl implements SysRoleResourceService {
	@Resource
	private SysRoleResourceMapper sysRoleResourceMapper;
	
	@Override
	public int insert(SysRoleResource record) {
		return sysRoleResourceMapper.insert(record);
	}

	@Override
	public int insertSelective(SysRoleResource record) {
		return sysRoleResourceMapper.insertSelective(record);
	}

	@Override
	public int insertByList(List<SysRoleResource> sysRoleResources) {
		return sysRoleResourceMapper.insertByList(sysRoleResources);
	}
	
	@Override
	public int deleteByPrimaryKey(String id){
		return sysRoleResourceMapper.deleteByPrimaryKey(id);
	}
}

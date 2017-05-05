package cn.posolft.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.posolft.manage.dao.BaseMapper;
import cn.posolft.manage.dao.SysDictMapper;
import cn.posolft.manage.pojo.SysDict;
import cn.posolft.manage.service.SysDictService;

@Service("sysDictService") 
public class SysDictServiceImpl extends PosolftBaseServiceImpl<SysDict> implements SysDictService {
	@Resource
	private SysDictMapper sysDictMapper;
	
	private final static Map<String, List<SysDict>> dict_cache = new HashMap<String, List<SysDict>>();
	
	@Override
	public BaseMapper<SysDict> getBaseMapper() {
		return sysDictMapper;
	}
	@Override
	public void clearDict() {
		dict_cache.clear();
	}

}

package cn.posolft.manage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.posolft.framework.utils.StringUtil;
import cn.posolft.manage.dao.BaseMapper;
import cn.posolft.manage.dao.SysResourceMapper;
import cn.posolft.manage.pojo.SysResource;
import cn.posolft.manage.service.SysResourceService;
@Service("sysResourceService") 
public class SysResourceServiceImpl extends PosolftBaseServiceImpl<SysResource> implements SysResourceService {
	@Resource
	private SysResourceMapper sysResourceMapper;
	
	@Override
	public BaseMapper<SysResource> getBaseMapper() {
		return sysResourceMapper;
	}
	@Override
	public List<String> selectUserResource(String userId){
		List<Map<String, String>> list = sysResourceMapper.selectAuthUrlListByUserId(userId);
		List<String> userRes = new ArrayList<String>();
		if(list!=null){
			for (Map<String, String> map : list) {
				userRes.add((map.get("url")+"").trim());
				String depUrls = map.get("dep_url")+"";
				if (StringUtil.notEmpty(depUrls)) {
					for (String url : depUrls.split(",")) {
						userRes.add(url.trim());
					}
				}
			}
		}
		return userRes;
	}

}

package cn.posolft.manage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.posolft.manage.pojo.SysResource;
/**
 * @author Galen.Zhou
 */
@Repository
public interface SysResourceMapper extends BaseMapper<SysResource>{
	/**
	 * 获取用户资源Map
	 * @param userId
	 * @return
	 */
	public List<SysResource> selectMapByUserId(String userId);
	/**
	 * 获取用户资源Url列表
	 * @param userId
	 * @return
	 */
	public List<Map<String, String>> selectAuthUrlListByUserId(String userId);
    
}
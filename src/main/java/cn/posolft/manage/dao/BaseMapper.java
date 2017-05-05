package cn.posolft.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.posolft.framework.web.jdbc.CommonParam;

/**
 * 
 * @author Galen.Zhou
 * @param <T>
 */
public interface BaseMapper<T> {
	List<T> selectListByT(@Param("pojo")T t, @Param("param")CommonParam param);
	
	int selectCountByT(@Param("pojo")T t);
	
	//List<T> selectListByMap(@Param("map")Map<String, Object> map, @Param("param")CommonParam param);
	
	int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}

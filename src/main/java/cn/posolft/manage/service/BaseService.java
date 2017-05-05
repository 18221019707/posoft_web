package cn.posolft.manage.service;

import java.util.List;
import java.util.Map;

import cn.posolft.framework.web.jdbc.CommonParam;
import cn.posolft.framework.web.jdbc.PageRecord;


/**
 * @author Galen.Zhou
 * @param <T>
 */
public interface BaseService<T> {
	/**
	 * 查询实体列表
	 * @return
	 */
	public List<T> selectList();
	/**
	 * 获取实体列表分页，用于列表主页显示
	 * @return
	 */
	public PageRecord<T> paging(Map<String, Object> map, CommonParam param);
	/**
	 * 获取实体列表分页，用于列表主页显示
	 * @return
	 */
	public PageRecord<T> paging(T t, CommonParam param);
	/**
	 * 带参数查询列表
	 * @param t
	 * @return
	 */
	public List<T> selectListByT(T t);
	/**
	 * 分页带参数查询列表
	 * @param t
	 * @param param
	 * @return
	 */
	public List<T> selectListByT(T t, CommonParam param);
	/**
	 * 主键查询对象
	 * @param id
	 * @return
	 */
	public T selectByPrimaryKey(String id);
	/**
	 * 插入实例对象
	 * @param record
	 * @return
	 */
    public int insert(T record);
    /**
     * 选择性插入实例对象
     * @param record
     * @return
     */
    public int insertSelective(T record);
    /**
     * 更新实例对象
     * @param record
     * @return
     */
    public int updateByPrimaryKey(T record);
    /**
     * 选择性更新实例对象
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(T record);
    /**
     * 删除实例对象
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(String id);
}

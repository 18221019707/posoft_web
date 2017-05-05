package cn.posolft.manage.service.impl;

import java.util.List;
import java.util.Map;

import cn.posolft.framework.web.jdbc.CommonParam;
import cn.posolft.framework.web.jdbc.PageRecord;
import cn.posolft.manage.dao.BaseMapper;
import cn.posolft.manage.service.BaseService;

public abstract class PosolftBaseServiceImpl<T> implements BaseService<T>{
	
	public abstract BaseMapper<T> getBaseMapper();
	
	@Override
	public List<T> selectList() {
		//CommonParam param = new CommonParam();
		//param.setMaxRows();
		return this.getBaseMapper().selectListByT(null, null);
	}

	@Override
	public PageRecord<T> paging(Map<String, Object> map, CommonParam param) {
		return null;
	}

	@Override
	public PageRecord<T> paging(T t, CommonParam param) {
		int count = this.getBaseMapper().selectCountByT(t);
		List<T> dataList = this.getBaseMapper().selectListByT(t, param);
		PageRecord<T> pageRecord = new PageRecord<T>();
		pageRecord.setPage(param.getPage());
		pageRecord.setPageSize(param.getRows());
		pageRecord.setTotalCount(count);
		pageRecord.setDataList(dataList);
		return pageRecord;
	}
	@Override
	public List<T> selectListByT(T t){
		CommonParam param = new CommonParam();
		param.setMaxRows();
		return selectListByT(t,param);
	}
	@Override
	public List<T> selectListByT(T t, CommonParam param){
		List<T> dataList = this.getBaseMapper().selectListByT(t, param);
		return dataList;
	}

	@Override
	public T selectByPrimaryKey(String id) {
		return  this.getBaseMapper().selectByPrimaryKey(id);
	}

	@Override
	public int insert(T record) {
		return this.getBaseMapper().insert(record);
	}

	@Override
	public int insertSelective(T record) {
		return this.getBaseMapper().insertSelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record) {
		return this.getBaseMapper().updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return this.getBaseMapper().updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return this.getBaseMapper().deleteByPrimaryKey(id);
	}
	

}

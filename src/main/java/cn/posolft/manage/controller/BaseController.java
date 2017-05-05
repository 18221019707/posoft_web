package cn.posolft.manage.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;

import cn.posolft.framework.utils.StringUtil;
import cn.posolft.framework.web.jdbc.CommonParam;
import cn.posolft.manage.pojo.SortCond;
import cn.posolft.manage.pojo.SortCond.Order;
import cn.posolft.manage.pojo.SysUser;

public class BaseController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public SysUser getSysUser(){
		return (SysUser)request.getSession(true).getAttribute("loginUser");
	}
	
	public CommonParam getCommonParam(){
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		CommonParam param = new CommonParam();
		if(StringUtil.notEmpty(page)){
			param.setPage(Integer.valueOf(page));
		}
		if(StringUtil.notEmpty(rows)){
			param.setRows(Integer.valueOf(rows));
		}
		String sort = request.getParameter("sort");
		if(StringUtil.notEmpty(page)){
			SortCond sortCond = new SortCond(sort, Order.DESC);
			param.addSortCond(sortCond );
		}
		return param;
	}
	
	public List<String> getParameterList(String name) {
		String[] parameterValues = request.getParameterValues(name);
		if(parameterValues==null){
			return null;
		}
		return Arrays.asList(parameterValues);
	}

	public List<String> getParameterList(String name, String split) {
		String value = request.getParameter(name);
		if (StringUtil.notEmpty(value)) {
			String[] arr = value.split(split);
			return Arrays.asList(arr);
		}
		return Collections.emptyList();
	}
}

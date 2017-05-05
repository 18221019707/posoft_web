package cn.posolft.framework.web.jdbc;

import java.util.HashMap;

public class DataGridMap extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2017535211422250506L;
	
	public void success(Object value) {
		super.put("code", RetCode.INVOKE_SUCCESS.getCode());
		super.put("msg", RetCode.INVOKE_SUCCESS.getMsg());
		super.put("pageRecord", value);
	}
}

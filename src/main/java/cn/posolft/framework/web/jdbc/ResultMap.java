package cn.posolft.framework.web.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ResultMap extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2017535211422250506L;
	
	public void success() {
		success(null);
	}
	
	public void success(Object value) {
		super.put("code", RetCode.INVOKE_SUCCESS.getCode());
		super.put("msg", RetCode.INVOKE_SUCCESS.getMsg());
		super.put("data", value);
	}
	
	public void error(String code,String msg) {
		error(code, msg, null);
	}
	/**
	 * 非法表单提交
	 */
	public void illegalSubmit(){
		error(RetCode.ILLEGAL_SUBMIT.getCode(), RetCode.ILLEGAL_SUBMIT.getMsg());
	}
	/**
	 * 没有权限
	 */
	public void invokeAllow(){
		error(RetCode.INVOKE_ALLOW.getCode(), RetCode.INVOKE_ALLOW.getMsg());
	}
	/**
	 * 参数无效
	 */
	public void validError() {
		error(RetCode.INVALID_PARAM.getCode(),RetCode.INVALID_PARAM.getMsg(), null);
	}
	public void validError(BindingResult result) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		List<FieldError> fieldErrors = result.getFieldErrors();
		for (int i = 0; i < fieldErrors.size(); i++) {
			FieldError fieldError = fieldErrors.get(i);
			String field = fieldError.getField();
			String msg = fieldError.getDefaultMessage();
			data.put(field, msg);
		}
		error(RetCode.INVALID_PARAM.getCode(),RetCode.INVALID_PARAM.getMsg(), data);
	}
	
	public void error(String code,String msg,Map<String, Object> data) {
		super.put("code", code);
		super.put("msg", msg);
		super.put("data", data);
	}
}

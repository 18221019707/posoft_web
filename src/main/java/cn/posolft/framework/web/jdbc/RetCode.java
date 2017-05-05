package cn.posolft.framework.web.jdbc;

public enum RetCode{
	INVOKE_SUCCESS("0000", "invoke success"), // 调用成功
	ILLEGAL_SUBMIT("403", "Illegal submit"), // 非法的表单提交申请
	NOTFOUND_RESOURCE("404", "can't found resource"), // 资源不存在
	LOCKED_RESOURCE("405", "can't found resource"), // 资源被锁定
	SYS_ERROR("500", "system is busy,please wait"), // 系统出错了
	INVOKE_ALLOW("403", "Do not have permission "), // 没有权限调用接口
	SESSION_TIMEOUT("400", "session timeout "), // 超时
	DEVELOPING("9998", "the target service developing"), // 正在开发中
	OTHER_ERROR("9999", " Unknown Error"), // 未知错误
	NULL_PARAM("1001", "null param"), // 参数为空
	INVALID_PARAM("1002", "invalid param"), // 参数无效
	OUTLIMIT_PARAM("1003", "param length out of limit"); // 参数长度超过最大限制
	
	private String code;
	private String msg;
	
	private RetCode(String code,String msg) {
		this.setCode(code);
		this.setMsg(msg);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

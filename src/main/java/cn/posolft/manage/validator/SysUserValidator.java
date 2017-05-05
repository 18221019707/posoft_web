package cn.posolft.manage.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import cn.posolft.framework.utils.StringUtil;
import cn.posolft.manage.pojo.SysUser;

@Repository
public class SysUserValidator extends Validator {

	@Override
	public boolean supports(Class<?> classz) {
		return classz.getSimpleName().indexOf(SysUser.class.getSimpleName())>=0;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		SysUser sysUser = (SysUser)obj;
		if(StringUtil.empty(sysUser.getName())){
			errors.rejectValue("name", null, "请输入姓名");
		}
		if(StringUtil.empty(sysUser.getLoginName())){
			errors.rejectValue("loginName", null,"请输入用户名称");
		}
		if(StringUtil.empty(sysUser.getId())&&StringUtil.empty(sysUser.getPwd())){
			errors.rejectValue("pwd", null,"请输入密码");
		}
		if(StringUtil.empty(sysUser.getPhone())){
			errors.rejectValue("phone", null,"请输入手机号码");
		}
		if(StringUtil.empty(sysUser.getEmail())){
			errors.rejectValue("email", null,"请输入邮箱");
		}
	}

	
}

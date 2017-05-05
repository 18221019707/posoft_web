package cn.posolft.manage.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import cn.posolft.framework.utils.StringUtil;
import cn.posolft.manage.pojo.SysRole;

@Repository
public class SysRoleValidator extends Validator {

	@Override
	public boolean supports(Class<?> classz) {
		return classz.getSimpleName().indexOf(SysRole.class.getSimpleName())>=0;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		SysRole sysRole = (SysRole)obj;
		if(StringUtil.empty(sysRole.getName())){
			errors.rejectValue("name", null, "请输入角色名称");
		}
		if(StringUtil.empty(sysRole.getCode())){
			errors.rejectValue("code", null,"请输入角色代码");
		}
	}


}

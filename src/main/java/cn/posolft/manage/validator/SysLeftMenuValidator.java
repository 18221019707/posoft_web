package cn.posolft.manage.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import cn.posolft.framework.utils.StringUtil;
import cn.posolft.manage.pojo.SysLeftMenu;

@Repository
public class SysLeftMenuValidator extends Validator {

	@Override
	public boolean supports(Class<?> classz) {
		return classz.getSimpleName().indexOf(SysLeftMenu.class.getSimpleName())>=0;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		SysLeftMenu sysLeftMenu = (SysLeftMenu)obj;
		if(StringUtil.empty(sysLeftMenu.getName())){
			errors.rejectValue("name", null, "请输入资源名称");
		}
		if(StringUtil.empty(sysLeftMenu.getIdx()+"")){
			errors.rejectValue("idx", null, "请输入排序");
		}
		if(sysLeftMenu.getType().equals("1")){
			if(StringUtil.empty(sysLeftMenu.getResourceId())){
				errors.rejectValue("resourceId", null, "请选择资源");
			}
		}
	}


}

package cn.posolft.manage.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import cn.posolft.framework.utils.StringUtil;
import cn.posolft.manage.pojo.SysResource;

@Repository
public class SysResourceValidator extends Validator {

	@Override
	public boolean supports(Class<?> classz) {
		return classz.getSimpleName().indexOf(SysResource.class.getSimpleName())>=0;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		SysResource sysResource = (SysResource)obj;
		//ValidationUtils.rejectIfEmpty(errors, "name", "请输入资源名称");
		if(StringUtil.empty(sysResource.getName())){
			errors.rejectValue("name", null, "请输入资源名称");
		}
		if(StringUtil.empty(sysResource.getUrl())){
			errors.rejectValue("url", null, "请输入URL地址");
		}
	}


}

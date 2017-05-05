package cn.posolft.manage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.posolft.framework.utils.IdentityUtil;
import cn.posolft.framework.utils.MyBeanUtils;
import cn.posolft.framework.utils.Security;
import cn.posolft.framework.utils.StringUtil;
import cn.posolft.framework.web.jdbc.CommonParam;
import cn.posolft.framework.web.jdbc.DataGridMap;
import cn.posolft.framework.web.jdbc.PageRecord;
import cn.posolft.framework.web.jdbc.ResultMap;
import cn.posolft.framework.web.jdbc.RetCode;
import cn.posolft.manage.annotation.Token;
import cn.posolft.manage.constants.Constants;
import cn.posolft.manage.pojo.SysRole;
import cn.posolft.manage.pojo.SysUser;
import cn.posolft.manage.pojo.SysUserRole;
import cn.posolft.manage.service.SysLeftMenuService;
import cn.posolft.manage.service.SysRoleService;
import cn.posolft.manage.service.SysUserService;
import cn.posolft.manage.validator.SysUserValidator;

@Controller  
@RequestMapping("/sysUser")  
public class SysUserController extends BaseController{
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysLeftMenuService sysLeftMenuService;
      
    @RequestMapping("/toIndex")  
    public String toIndex(Model model){
        return "admin/sys/sys_user_list";  
    }
    
    @RequestMapping("/datagrid") 
    @ResponseBody
    public DataGridMap datagrid(SysUser sysUser){
    	CommonParam param = getCommonParam();
		PageRecord<SysUser> pageRecord = sysUserService.paging(sysUser, param);
		DataGridMap map = new DataGridMap();
		map.success(pageRecord);
        return map;  
    }
    
    @RequestMapping("/goAdd")  
    @Token(save=true)
    public String goAdd(Model model){
    	List<SysRole> sysRoles = sysRoleService.selectList();
    	model.addAttribute("sysRoles",sysRoles);
        return "admin/sys/sys_user_add";  
    }
    
    @RequestMapping("/goEdit")  
    @Token(save=true)
    public String goEdit(Model model){
    	String id = request.getParameter("id");
    	SysUser sysUser = sysUserService.selectByPrimaryKey(id);
    	List<SysRole> sysRoles = sysRoleService.selectList();
    	HashMap<String, String> userRoleMap = new HashMap<String, String>();
    	List<SysRole> sysUserRoles = sysUser.getSysRoles();
    	for (int i = 0; i < sysUserRoles.size(); i++) {
    		SysRole sysRole = sysUserRoles.get(i);
    		userRoleMap.put(sysRole.getId(), sysRole.getId());
		}
    	model.addAttribute("sysUser",sysUser);
    	model.addAttribute("sysRoles",sysRoles);
    	model.addAttribute("userRoleMap",userRoleMap);
        return "admin/sys/sys_user_edit";  
    }
    
    @RequestMapping("/doAdd") 
    @ResponseBody
    @Token(remove=true)
    public ResultMap doAdd(@Validated SysUser sysUser,BindingResult result,
    		@RequestParam(value = "roleId", required = false) String[] roleIds){
    	String repwd = request.getParameter("repwd");
    	if(!sysUser.getPwd().equals(repwd)){
    		result.rejectValue("repwd", null, "两次密码输入不一致");
    	}
    	if(result.hasErrors()){
    		ResultMap map = new ResultMap();
        	map.validError(result);
        	return map;
    	}
		sysUser.setId(IdentityUtil.randomLong()+"");
		if(StringUtil.empty(sysUser.getStatus())){
			sysUser.setStatus(Constants.USER_STATUS0);
		}
		sysUser.setPwd(Security.md5(sysUser.getPwd()));
		List<SysUserRole> sysUserRoles = new ArrayList<SysUserRole>();
		SysUserRole temp = null;
		for (String roleId : roleIds) {
			if(StringUtil.empty(roleId)){
				continue;
			}
			temp = new SysUserRole();
			temp.setUserId(sysUser.getId()+"");
			temp.setRoleId(roleId);
			sysUserRoles.add(temp);
		}
		sysUserService.insertSysUserAndUserRole(sysUserRoles, sysUser);
    	ResultMap map = new ResultMap();
    	map.success();
    	return map;
    }
    @RequestMapping("/doEdit") 
    @ResponseBody
    @Token(remove=true)
    public ResultMap doEdit(@Validated SysUser sysUser,BindingResult result){
    	if(result.hasErrors()){
    		ResultMap map = new ResultMap();
        	map.validError(result);
        	return map;
    	}
    	SysUser newObj = sysUserService.selectByPrimaryKey(sysUser.getId()+"");
		try {
			MyBeanUtils.copyBeanNotNull2Bean(sysUser, newObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sysUserService.updateByPrimaryKey(newObj);
		sysLeftMenuService.clearMenu(sysUser.getId());
    	ResultMap map = new ResultMap();
    	map.success();
    	return map;
    }
    
    @RequestMapping("/delete") 
    @ResponseBody
    public ResultMap delete(SysUser sysUser){
		String id = request.getParameter("id");
		int ret = sysUserService.deleteByPrimaryKey(id);
		ResultMap map = new ResultMap();
		if(ret>0){
			sysLeftMenuService.clearMenu(id);
			map.success();
		}else{
			map.error(RetCode.SYS_ERROR.getCode(), RetCode.SYS_ERROR.getMsg());
		}
    	return map;
    }
    
    @InitBinder  
    public void initBinder(DataBinder binder) {  
       binder.setValidator(new SysUserValidator());  
    }
    
} 

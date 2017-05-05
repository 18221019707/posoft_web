package cn.posolft.manage.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.posolft.framework.utils.Security;
import cn.posolft.framework.utils.StringUtil;
import cn.posolft.framework.web.jdbc.ResultMap;
import cn.posolft.framework.web.jdbc.RetCode;
import cn.posolft.manage.pojo.SysLeftMenu;
import cn.posolft.manage.pojo.SysUser;
import cn.posolft.manage.service.SysLeftMenuService;
import cn.posolft.manage.service.SysUserService;

@Controller  
@RequestMapping("/admin")  
public class AdminController extends BaseController{
	@Resource
	private SysUserService sysUserService;
	@Resource
	private SysLeftMenuService sysLeftMenuService;
	
	
    
	@RequestMapping("/console")
	public String console(Model model){
		SysUser sysUser = super.getSysUser();
		if(sysUser==null){
			return "login";
		}
		List<SysLeftMenu> sysLeftMenus = sysLeftMenuService.selectUserMenuByCache(sysUser.getId());
		model.addAttribute("sysLeftMenus", sysLeftMenus);
		return "admin/index";
	}
	@RequestMapping("/login")
	@ResponseBody
	public ResultMap login(SysUser sysUser,Model model){
		ResultMap map = new ResultMap();
		if(StringUtil.empty(sysUser.getPwd())||StringUtil.empty(sysUser.getLoginName())){
			map.error(RetCode.INVALID_PARAM.getCode(),"请输入用户名或密码");
			return map;
		}
		sysUser.setPwd(Security.md5(sysUser.getPwd()));
		List<SysUser> list = sysUserService.selectListByT(sysUser);
		if(list!=null&&list.size()>0){
			request.getSession(true).setAttribute("loginUser", list.get(0));
			map.success();
		}else{
			map.error(RetCode.INVALID_PARAM.getCode(),"用户名密码错误");
		}
		return map;
	}
    
} 

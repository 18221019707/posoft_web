package cn.posolft.manage.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.posolft.framework.utils.IdentityUtil;
import cn.posolft.framework.utils.MyBeanUtils;
import cn.posolft.framework.web.jdbc.CommonParam;
import cn.posolft.framework.web.jdbc.DataGridMap;
import cn.posolft.framework.web.jdbc.PageRecord;
import cn.posolft.framework.web.jdbc.ResultMap;
import cn.posolft.framework.web.jdbc.RetCode;
import cn.posolft.manage.annotation.Token;
import cn.posolft.manage.pojo.SysLeftMenu;
import cn.posolft.manage.pojo.SysResource;
import cn.posolft.manage.service.SysLeftMenuService;
import cn.posolft.manage.service.SysResourceService;
import cn.posolft.manage.validator.SysLeftMenuValidator;

@Controller  
@RequestMapping("/sysDict")  
public class SysDictController extends BaseController{
	@Resource
	private SysLeftMenuService sysLeftMenuService;
	@Resource
	private SysResourceService sysResourceService;
	
    @RequestMapping("/toIndex")  
    public String toIndex(HttpServletRequest request,Model model){
        return "admin/sys/sys_left_menu_list";  
    }
    
    @RequestMapping("/datagrid") 
    @ResponseBody
    public DataGridMap datagrid(SysLeftMenu sysLeftMenu){
    	CommonParam param = getCommonParam();
    	sysLeftMenu.setParentId("888888888888888888");
		PageRecord<SysLeftMenu> pageRecord = sysLeftMenuService.paging(sysLeftMenu, param);
		DataGridMap map = new DataGridMap();
		map.success(pageRecord);
        return map;  
    }
    
    @RequestMapping("/datagridChild") 
    @ResponseBody
    public DataGridMap datagridChild(SysLeftMenu sysLeftMenu){
    	CommonParam param = getCommonParam();
		PageRecord<SysLeftMenu> pageRecord = sysLeftMenuService.paging(sysLeftMenu, param);
		DataGridMap map = new DataGridMap();
		map.success(pageRecord);
        return map;  
    }
    
    @RequestMapping("/goAdd")  
    @Token(save=true)
    public String goAdd(Model model){
    	String pid = request.getParameter("pid");
    	SysLeftMenu parent = sysLeftMenuService.selectByPrimaryKey(pid);
		SysResource t = new SysResource();
		t.setParentId("888888888888888888");
		List<SysResource> sysResources = sysResourceService.selectListByT(t);
    	model.addAttribute("parent",parent);
    	model.addAttribute("sysResources",sysResources);
        return "admin/sys/sys_left_menu_add";  
    }
    
    @RequestMapping("/goEdit") 
    @Token(save=true)
    public String goEdit(Model model){
    	String id = request.getParameter("id");
    	SysLeftMenu sysLeftMenu = sysLeftMenuService.selectByPrimaryKey(id);
    	SysLeftMenu parent = sysLeftMenuService.selectByPrimaryKey(sysLeftMenu.getParentId());
    	SysResource t = new SysResource();
		t.setParentId("888888888888888888");
		List<SysResource> sysResources = sysResourceService.selectListByT(t);
    	model.addAttribute("parent",parent);
    	model.addAttribute("sysLeftMenu",sysLeftMenu);
    	model.addAttribute("sysResources",sysResources);
        return "admin/sys/sys_left_menu_edit";  
    }
    
    @RequestMapping("/doAdd") 
    @ResponseBody
    @Token(remove=true)
    public ResultMap doAdd(SysLeftMenu sysLeftMenu){
		sysLeftMenu.setId(IdentityUtil.uuid16());
		sysLeftMenuService.insert(sysLeftMenu);
    	ResultMap map = new ResultMap();
    	map.success();
    	return map;
    }
    @RequestMapping("/doEdit") 
    @ResponseBody
    @Token(remove=true)
    public ResultMap doEdit(SysLeftMenu sysLeftMenu){
    	SysLeftMenu newObj = sysLeftMenuService.selectByPrimaryKey(sysLeftMenu.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(sysLeftMenu, newObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sysLeftMenuService.updateByPrimaryKey(newObj);
    	ResultMap map = new ResultMap();
    	map.success();
    	return map;
    }
    
    @RequestMapping("/delete") 
    @ResponseBody
    public ResultMap delete(SysLeftMenu sysLeftMenu){
		String id = request.getParameter("id");
		int ret = sysLeftMenuService.deleteByPrimaryKey(id);
		ResultMap map = new ResultMap();
		if(ret>0){
			map.success();
		}else{
			map.error(RetCode.SYS_ERROR.getCode(), RetCode.SYS_ERROR.getMsg());
		}
    	return map;
    }
    
    @InitBinder  
    public void initBinder(DataBinder binder) {  
       binder.setValidator(new SysLeftMenuValidator());  
    }
    
} 

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
import cn.posolft.framework.utils.StringUtil;
import cn.posolft.framework.web.jdbc.CommonParam;
import cn.posolft.framework.web.jdbc.DataGridMap;
import cn.posolft.framework.web.jdbc.PageRecord;
import cn.posolft.framework.web.jdbc.ResultMap;
import cn.posolft.framework.web.jdbc.RetCode;
import cn.posolft.manage.annotation.Token;
import cn.posolft.manage.pojo.SysResource;
import cn.posolft.manage.pojo.SysRole;
import cn.posolft.manage.pojo.SysRoleResource;
import cn.posolft.manage.service.SysLeftMenuService;
import cn.posolft.manage.service.SysResourceService;
import cn.posolft.manage.service.SysRoleService;
import cn.posolft.manage.validator.SysRoleValidator;

@Controller  
@RequestMapping("/sysRole")  
public class SysRoleController extends BaseController{
	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysResourceService sysResourceService;
	@Resource
	private SysLeftMenuService sysLeftMenuService;
      
    @RequestMapping("/toIndex")  
    public String toIndex(Model model){
        return "admin/sys/sys_role_list";  
    }
    
    @RequestMapping("/datagrid") 
    @ResponseBody
    public DataGridMap datagrid(SysRole sysRole){
    	CommonParam param = getCommonParam();
		PageRecord<SysRole> pageRecord = sysRoleService.paging(sysRole, param);
		DataGridMap map = new DataGridMap();
		map.success(pageRecord);
        return map;  
    }
    
    @RequestMapping("/goAdd")  
    @Token(save=true)
    public String goAdd(Model model){
        return "admin/sys/sys_role_add";  
    }
    
    @RequestMapping("/goEdit")  
    @Token(save=true)
    public String goEdit(Model model){
    	String id = request.getParameter("id");
    	SysRole sysRole = sysRoleService.selectByPrimaryKey(id);
    	model.addAttribute("sysRole",sysRole);
        return "admin/sys/sys_role_edit";  
    }
    
    @RequestMapping("/goAuth")
    public String goAuth(Model model){
    	String id = request.getParameter("id");
    	SysRole sysRole = sysRoleService.selectByPrimaryKey2(id);
    	HashMap<String, String> roleResourceMap = new HashMap<String, String>();
    	List<SysResource> sysResources2 = sysRole.getSysResources();
    	for (int i = 0; i < sysResources2.size(); i++) {
    		SysResource sysResource = sysResources2.get(i);
    		roleResourceMap.put(sysResource.getId(), sysResource.getId());
		}
    	SysResource t = new SysResource();
    	t.setParentId("888888888888888888");
		List<SysResource> sysResources = sysResourceService.selectListByT(t);
    	model.addAttribute("sysResources",sysResources);
    	model.addAttribute("sysRole",sysRole);
    	model.addAttribute("roleResourceMap",roleResourceMap);
        return "admin/sys/sys_role_resource_list";  
    }
    
    @RequestMapping("/doAdd") 
    @ResponseBody
    @Token(remove=true)
    public ResultMap doAdd(@Validated SysRole sysRole,BindingResult result){
    	if(result.hasErrors()){
    		ResultMap map = new ResultMap();
        	map.validError(result);
        	return map;
    	}
		sysRole.setId(IdentityUtil.uuid16());
		sysRoleService.insert(sysRole);
    	ResultMap map = new ResultMap();
    	map.success();
    	return map;
    }
    @RequestMapping("/doEdit") 
    @ResponseBody
    @Token(remove=true)
    public ResultMap doEdit(@Validated SysRole sysRole,BindingResult result){
    	SysRole newObj = sysRoleService.selectByPrimaryKey(sysRole.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(sysRole, newObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sysRoleService.updateByPrimaryKey(newObj);
    	ResultMap map = new ResultMap();
    	map.success();
    	return map;
    }
    @RequestMapping("/doAuth") 
    @ResponseBody
    public ResultMap doAuth(SysRole sysRole,@RequestParam(value = "res", required = false) String[] ress){
    	SysRole newObj = sysRoleService.selectByPrimaryKey(sysRole.getId());
    	List<SysRoleResource> sysRoleResources = new ArrayList<SysRoleResource>();
    	SysRoleResource roleResource = null;
    	for (String re : ress) {
    		if(StringUtil.empty(re)){
    			continue;
    		}
    		roleResource = new SysRoleResource();
    		roleResource.setRoleId(newObj.getId());
    		roleResource.setResourceId(re);
    		sysRoleResources.add(roleResource);
		}
    	sysRoleService.updateSysRoleResource(sysRoleResources, newObj.getId());
    	sysLeftMenuService.clearMenu();
    	ResultMap map = new ResultMap();
    	map.success();
    	return map;
    }
    
    @RequestMapping("/delete") 
    @ResponseBody
    public ResultMap delete(SysRole sysRole){
		String id = request.getParameter("id");
		int ret = sysRoleService.deleteByPrimaryKey(id);
		ResultMap map = new ResultMap();
		if(ret>0){
			sysLeftMenuService.clearMenu();
			map.success();
		}else{
			map.error(RetCode.SYS_ERROR.getCode(), RetCode.SYS_ERROR.getMsg());
		}
    	return map;
    }
    
    @InitBinder  
    public void initBinder(DataBinder binder) {  
       binder.setValidator(new SysRoleValidator());  
    }
    
} 

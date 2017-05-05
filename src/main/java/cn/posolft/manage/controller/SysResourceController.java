package cn.posolft.manage.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
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
import cn.posolft.manage.pojo.SysResource;
import cn.posolft.manage.service.SysLeftMenuService;
import cn.posolft.manage.service.SysResourceService;
import cn.posolft.manage.validator.SysResourceValidator;

@Controller  
@RequestMapping("/sysResource")  
public class SysResourceController extends BaseController{
	@Resource
	private SysResourceService sysResourceService;
	@Resource
	private SysLeftMenuService sysLeftMenuService;
      
    @RequestMapping("/toIndex")  
    public String toIndex(Model model){
        return "admin/sys/sys_resource_list";  
    }
    
    @RequestMapping("/datagrid") 
    @ResponseBody
    public DataGridMap datagrid(SysResource sysResource){
    	CommonParam param = getCommonParam();
    	sysResource.setParentId("888888888888888888");
		PageRecord<SysResource> pageRecord = sysResourceService.paging(sysResource, param);
		DataGridMap map = new DataGridMap();
		map.success(pageRecord);
        return map;  
    }
    
    @RequestMapping("/datagridChild") 
    @ResponseBody
    public DataGridMap datagridChild(SysResource sysResource){
    	CommonParam param = getCommonParam();
		PageRecord<SysResource> pageRecord = sysResourceService.paging(sysResource, param);
		DataGridMap map = new DataGridMap();
		map.success(pageRecord);
        return map;  
    }
    
    @RequestMapping("/goAdd")  
    @Token(save=true)
    public String goAdd(Model model){
    	String pid = request.getParameter("pid");
    	SysResource parent = sysResourceService.selectByPrimaryKey(pid);
    	model.addAttribute("parent",parent);
        return "admin/sys/sys_resource_add";  
    }
    
    @RequestMapping("/goEdit")  
    @Token(save=true)
    public String goEdit(Model model){
    	String id = request.getParameter("id");
    	SysResource sysResource = sysResourceService.selectByPrimaryKey(id);
    	SysResource parent = sysResourceService.selectByPrimaryKey(sysResource.getParentId());
    	String depUrl = sysResource.getDepUrl();
    	String[] arr = depUrl.split(",");
		List<String> urls = Arrays.asList(arr);
    	model.addAttribute("parent",parent);
    	model.addAttribute("sysResource",sysResource);
    	model.addAttribute("urls",urls);
        return "admin/sys/sys_resource_edit";  
    }
    
    @RequestMapping("/doAdd") 
    @ResponseBody
    @Token(remove=true)
    public ResultMap doAdd(@Validated SysResource sysResource,BindingResult result){
    	if(result.hasErrors()){
    		ResultMap map = new ResultMap();
        	map.validError(result);
        	return map;
    	}
    	List<String> urls = this.getParameterList( "dep_urls");
    	StringBuilder sb = new StringBuilder();
		if (urls != null){
			for (String url : urls) {
				sb.append(url).append(",");
			}
		}
		sysResource.setId(IdentityUtil.uuid16());
		sysResource.setDepUrl(sb.toString());
		sysResourceService.insert(sysResource);
    	ResultMap map = new ResultMap();
    	map.success();
    	return map;
    }
    @RequestMapping("/doEdit") 
    @ResponseBody
    @Token(remove=true)
    public ResultMap doEdit(@Validated SysResource sysResource,BindingResult result){
    	SysResource newObj = sysResourceService.selectByPrimaryKey(sysResource.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(sysResource, newObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> urls = this.getParameterList("dep_urls");
		StringBuilder sb = new StringBuilder();
		if (urls != null){
			for (String url : urls) {
				sb.append(url).append(",");
			}
		}
		newObj.setDepUrl(sb.toString());
		sysResourceService.updateByPrimaryKey(newObj);
		sysLeftMenuService.clearMenu();
    	ResultMap map = new ResultMap();
    	map.success();
    	return map;
    }
    
    @RequestMapping("/delete") 
    @ResponseBody
    public ResultMap delete(SysResource sysResource){
		String id = request.getParameter("id");
		int ret = sysResourceService.deleteByPrimaryKey(id);
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
       binder.setValidator(new SysResourceValidator());  
    }
    
} 

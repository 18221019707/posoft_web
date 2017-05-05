package cn.posolft.manage.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.posolft.framework.utils.JsonUtil;
import cn.posolft.framework.web.jdbc.ResultMap;
import cn.posolft.manage.pojo.SysUser;
import cn.posolft.manage.service.SysResourceService;

/**
 * 权限拦截器
 * 
 * @author Galen
 * 
 */
public class AuthInterceptor implements HandlerInterceptor {
	
	@Resource
	private SysResourceService sysResourceService;

	/**
	 * 在controller后拦截
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在controller前拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		SysUser sysUser = (SysUser)request.getSession(true).getAttribute("loginUser");
		List<String> resource = sysResourceService.selectUserResource(sysUser.getId());
		String requestUri = request.getRequestURI().replaceFirst(request.getContextPath(), "");
		if(!resource.contains(requestUri)){
			if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter writer = response.getWriter();
				ResultMap map = new ResultMap();
				map.invokeAllow();
				writer.print(JsonUtil.toJson(map));
				writer.close();
			}else{
				response.sendRedirect(request.getContextPath()+"/error403.jsp");
			}
			return false;
		}
		return true;
	}

}

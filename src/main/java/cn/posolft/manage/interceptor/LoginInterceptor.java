package cn.posolft.manage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.posolft.manage.pojo.SysUser;

/**
 * 登录拦截器
 * 
 * @author  Galen
 * 
 */
public class LoginInterceptor implements HandlerInterceptor {

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
		if(sysUser==null){
			response.sendRedirect(request.getContextPath()+"/admin/console.do");
			/*if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter writer = response.getWriter();
				ResultMap map = new ResultMap();
				map.invokeAllow();
				writer.print(JsonUtil.toJson(map));
				writer.close();
			}else{
			}*/
			return false;
		}
		return true;
	}

}

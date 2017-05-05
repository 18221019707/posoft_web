package cn.posolft.manage.interceptor;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.posolft.framework.utils.IdentityUtil;
import cn.posolft.framework.utils.JsonUtil;
import cn.posolft.framework.utils.StringUtil;
import cn.posolft.framework.web.jdbc.ResultMap;
import cn.posolft.manage.annotation.Token;

public class TokenInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger logger = Logger.getLogger(Token.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);
            if (annotation != null) {
            	//初始化页面token
            	boolean needSaveSession = annotation.save();
                if (needSaveSession) {
					List<String> tokenList=(List<String>) request.getSession(true).getAttribute("token_list");//token list
                	if(tokenList==null){
            			tokenList = new ArrayList<String>();
            		}
                	String token = IdentityUtil.uuid32();
            		tokenList.add(token);
            		request.getSession(true).setAttribute("token_list", tokenList);
                    request.getSession(true).setAttribute("client_token", token);
                }
                //校验token
                boolean needRemoveSession = annotation.remove();
                if (needRemoveSession) {
                	String server_token="";
                	List<String> tokenList=(List<String>) request.getSession(true).getAttribute("token_list");//token list
                	String client_token = request.getHeader("ClientToken");
                	if(tokenList!=null&&tokenList.size()>0){
                		if(tokenList.contains(client_token)){//缓存token列表中存在请求的token，则请求通过
                			server_token=client_token;
                			tokenList.remove(client_token);//移除已经提交的token,防止重复提交
                		}
                	}
                	String token = IdentityUtil.uuid32();
                	tokenList.add(token);
                	if(tokenList.size()>=100){//超过100的时候删除首次加入的元素
                		tokenList.remove(0);
                	}
                	request.getSession(true).setAttribute("token_list", tokenList);
                	response.setHeader("server_token", token);
                	if (StringUtil.empty(server_token) || StringUtil.empty(client_token) || !server_token.equals(client_token)) {
            			if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {
            				response.setContentType("application/json;charset=UTF-8");
            				PrintWriter writer = response.getWriter();
            				ResultMap map = new ResultMap();
            				map.illegalSubmit();
            				writer.print(JsonUtil.toJson(map));
            				writer.close();
            				logger.warn("please don't repeat submit,url:"+ request.getServletPath());
            				return false;
            			} else {
            				throw new IllegalArgumentException("非法表单提交申请！");
            			}
            		}else{
            			return true;
            		}
                }
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }
}

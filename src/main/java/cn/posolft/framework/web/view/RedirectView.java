package cn.posolft.framework.web.view;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

public class RedirectView extends View {

	/**
	 * 
	 */
	private String url;
	private boolean withQueryString = false;
	private final String contextPath = getContxtPath();

	private String getContxtPath() {
		String cp = request.getContextPath();
		return ("".equals(cp) || "/".equals(cp)) ? null : cp;
	}

	public RedirectView(String url) {
		if (contextPath != null && url.indexOf("://") == -1) {
			url = contextPath + url;
		}
		this.url = url;
	}

	public RedirectView(String url, Map<String, String> params) {
		this(url);
		if (params != null && params.size() > 0) {
			StringBuffer sb = new StringBuffer();
			int size = params.size();
			int i = 0;
			for (Entry<String, String> entry : params.entrySet()) {
				sb.append(entry.getKey()).append("=").append(entry.getValue());
				if (++i < size) {
					sb.append("&");
				}
			}
			try {
				url = url + (url.indexOf("?") != -1 ? "&" : "?") + URLEncoder.encode(sb.toString(), encoding);
			} catch (UnsupportedEncodingException e) {
				url = url + (url.indexOf("?") != -1 ? "&" : "?") + sb.toString();
			}
		}
	}

	public RedirectView(String url, boolean withQueryString) {
		this(url);
		this.withQueryString = withQueryString;
	}

	@Override
	public void view() {
		if (withQueryString) {
			String queryString = request.getQueryString();
			if (queryString != null) {
				url = url + (url.indexOf("?") != -1 ? "&" : "?") + queryString;
			}
		}
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}

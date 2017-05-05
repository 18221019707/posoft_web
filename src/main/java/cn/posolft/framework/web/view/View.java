package cn.posolft.framework.web.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * View.
 */
public abstract class View {

	protected HttpServletRequest request;
	protected HttpServletResponse response;

	protected static final String encoding = "UTF-8";

	public View() {
		
	}

	public void init(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public final View put(String name, Object value) {
		request.setAttribute(name, value);
		return this;
	}

	public abstract void view() throws RuntimeException;

	public static enum ContentType {
		JSON("application/json; charset=" + encoding + ""), TEXT("application/text; charset=" + encoding + ""), HTML("text/html; charset=" + encoding + ""), XML(
				"text/xml; charset=" + encoding + "");
		private String type;

		public String getType() {
			return this.type;
		}

		private ContentType(String type) {
			this.type = type;
		}
	}
}

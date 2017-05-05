package cn.posolft.framework.web.view;

import java.io.OutputStream;

import cn.posolft.framework.utils.AuthCodeUtil;
import cn.posolft.framework.utils.IOUtil;
import cn.posolft.framework.utils.StringUtil;


public class AuthCodeView extends View {

	/**
	 * 
	 */
	private String authCode;
	public static String defSessionKey = "PUFF_SERVER_AUTHCODE";
	public String sessionKey;
	private int size = 4;

	public AuthCodeView setSessionKey(String sessionKey) {
		if (StringUtil.notBlank(sessionKey)) {
			this.sessionKey = sessionKey;
		}
		return this;
	}

	public AuthCodeView setAuthCode(String authCode) {
		if (StringUtil.notBlank(authCode) && authCode.length() >= 4 && authCode.length() < 7) {
			this.authCode = authCode;
		}
		return this;
	}

	public AuthCodeView setSize(int size) {
		if (size > 4 && size < 7) {
			this.size = size;
		}
		return this;
	}

	@Override
	public void view() {
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			authCode = StringUtil.empty(authCode, AuthCodeUtil.getRandom(size));
			if (StringUtil.notBlank(sessionKey)) {
				request.getSession().setAttribute(sessionKey, authCode);
			}
			response.setContentType("image/png");
			AuthCodeUtil.draw(out, authCode);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			IOUtil.close(out);
		}
	}
}
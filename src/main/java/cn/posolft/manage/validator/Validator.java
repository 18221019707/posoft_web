package cn.posolft.manage.validator;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Validator implements org.springframework.validation.Validator{

	private static final String EMAIL_ADDRESS_PATTERN = "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
	private static final String MOBILE_ADDRESS_PATTERN = "^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8})$";
	
	protected boolean integer(String val, int min, int max) {
		try {
			int value = Integer.valueOf(val);
			if (value < min || value > max) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static final String datePattern = "yyyy-MM-dd";
	private static final String TEL_ADDRESS_PATTERN = "^\\d{3,4}-?\\d{7,9}$";


	protected boolean date(String value, Date min, Date max) {
		try {
			Date temp = new SimpleDateFormat(datePattern).parse(value);
			if (temp.before(min) || temp.after(max)) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	protected boolean date(String value, String datePattern) {
		try {
			new SimpleDateFormat(datePattern).parse(value);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	protected boolean date(String field, String datePattern, String min, String max) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			return date(field, sdf.parse(min), sdf.parse(max));
		} catch (ParseException e) {
			return false;
		}
	}

	protected boolean equalFiled(String s1, String s2) {
		if (s1 == null || s2 == null || (!s1.equals(s2))) {
			return false;
		}
		return true;
	}

	protected boolean equalInteger(Integer i1, Integer i2) {
		if (i1 == null || i2 == null || (i1.intValue() != i2.intValue())) {
			return false;
		}
		return true;
	}

	protected boolean email(String value) {
		return validateRegex(value, EMAIL_ADDRESS_PATTERN, false);
	}
	protected boolean mobile(String value) {
		return validateRegex(value, MOBILE_ADDRESS_PATTERN, false);
	}
	protected boolean tel(String value) {
		return validateRegex(value, TEL_ADDRESS_PATTERN, false);
	}
	protected boolean url(String value) {
		try {
			if (value.startsWith("https://")) {
				value = "http://" + value.substring(8);
			}
			new URL(value);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}
	}

	protected boolean validateRegex(String value, String regExpression, boolean isCaseSensitive) {
		Pattern pattern = isCaseSensitive ? Pattern.compile(regExpression) : Pattern.compile(regExpression, Pattern.CASE_INSENSITIVE);
		if (value == null) {
			return false;
		}
		Matcher matcher = pattern.matcher(value);
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}

	protected void validateRegex(String field, String regExpression) {
		validateRegex(field, regExpression, true);
	}
	
	protected boolean string(String value, boolean notEmpty, int minLen, int maxLen) {
		if (value == null || value.length() < minLen || value.length() > maxLen) {
			return false;
		} else if (notEmpty && "".equals(value.trim())) {
			return false;
		}
		return true;
	}

	protected void string(String field, int minLen, int maxLen) {
		string(field, true, minLen, maxLen);
	}
}

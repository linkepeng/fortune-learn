package com.fortune.tools.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具
 * 
 * @author linkepeng
 * @date 2018年12月8日
 */
public class RegexUtils {
	/**
	 * 检查电子邮件是否正确<br>
	 * @author linkepeng
	 * @param email
	 * @return 
	 */
	public static boolean isEmail(String email) {
		String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		return matcherRegex(regex, email);
	}

	/**
	 *
	 * 函数名称：matcherRegex<br>
	 * 函数功能：检查字符串str是否匹配正则表达式regex<br>
	 * 例：String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";<br>
	 * RegexUtils.matcherRegex(regex,"xinxin@163.com")<br>
	 * 输出：true
	 * @author linkepeng
	 * @param regex - 正则表达式
	 * @param str   - 要检查的字符串
	 * @return boolean
	 */
	public static boolean matcherRegex(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
    /**
     *  判断请求路径是否正确的请求网络URL路径
     * @author linkepeng
     * @param webUrl
     * @return
     */
    public static boolean isWebUrl(String webUrl){
        String regex="(http|https|ftp):\\/\\/([\\w-]+\\.)+[\\w-]+([\\/\\:][\\w- .\\/?%&=\\;#\\*]*)?";
        return matcherRegex(regex, webUrl);
    }

}

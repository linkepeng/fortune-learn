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

	/**
	 * 功能描述：判断输入的字符串是否为纯汉字
	 * @param str 传入的字符窜
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(String str) {
		String regex = "[\u0391-\uFFE5]+$";
		return matcherRegex(regex, str);
	}

	/**
	 * 功能描述：人民币转成大写
	 * @param str 数字字符串
	 * @return String 人民币转换成大写后的字符串
	 */
	public static String hangeToBig(String str) {
		double value;
		try {
			value = Double.parseDouble(str.trim());
		} catch (Exception e) {
			return null;
		}
		// 段内位置表示
		char[] hunit = { '拾', '佰', '仟' };
		// 段名表示
		char[] vunit = { '万', '亿' };
		// 数字表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
		// 转化成整形
		long midVal = (long) (value * 100);
		// 转化成字符串
		String valStr = String.valueOf(midVal);
		// 取整数部分
		String head = valStr.substring(0, valStr.length() - 2);
		// 取小数部分
		String rail = valStr.substring(valStr.length() - 2);

		// 整数部分转化的结果
		String prefix = "";
		// 小数部分转化的结果
		String suffix = "";
		// 处理小数点后面的数
		if (rail.equals("00")) {
			// 如果小数部分为0
			suffix = "整";
		} else {
			// 否则把角分转化出来
			suffix = digit[rail.charAt(0) - '0'] + "角"
					+ digit[rail.charAt(1) - '0'] + "分";
		}
		// 处理小数点前面的数
		// 把整数部分转化成字符数组
		char[] chDig = head.toCharArray();
		// 标志'0'表示出现过0
		char zero = '0';
		// 连续出现0的次数
		byte zeroSerNum = 0;
		// 循环处理每个数字
		for (int i = 0; i < chDig.length; i++) {
			// 取段内位置
			int idx = (chDig.length - i - 1) % 4;
			// 取段位置
			int vidx = (chDig.length - i - 1) / 4;
			// 如果当前字符是0
			if (chDig[i] == '0') {
				// 连续0次数递增
				zeroSerNum++;
				// 标志
				if (zero == '0') {
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				continue;
			}
			// 连续0次数清零
			zeroSerNum = 0;
			// 如果标志不为0,则加上,例如万,亿什么的
			if (zero != '0') {
				prefix += zero;
				zero = '0';
			}
			// 转化该数字表示
			prefix += digit[chDig[i] - '0'];
			if (idx > 0){
				prefix += hunit[idx - 1];
			}

			if (idx == 0 && vidx > 0) {
				// 段结束位置应该加上段名如万,亿
				prefix += vunit[vidx - 1];
			}
		}

		if (prefix.length() > 0) {
			// 如果整数部分存在,则有圆的字样
			prefix += '圆';
		}
		// 返回正确表示
		return prefix + suffix;
	}

	/**
	 * 功能描述：判断是否为质数
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x) {
		if (x <= 7) {
			if (x == 2 || x == 3 || x == 5 || x == 7) {
				return true;
			}
		}
		int c = 7;
		if (x % 2 == 0) {
			return false;
		}
		if (x % 3 == 0) {
			return false;
		}
		if (x % 5 == 0) {
			return false;
		}
		int end = (int) Math.sqrt(x);
		while (c <= end) {
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 6;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 6;
		}
		return true;
	}

}

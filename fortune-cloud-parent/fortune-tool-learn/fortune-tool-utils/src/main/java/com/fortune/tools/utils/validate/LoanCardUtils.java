package com.fortune.tools.utils.validate;

import org.apache.commons.lang3.StringUtils;

/**
 * 贷款卡编码的校验算法
 *
 * 贷款卡编码一共有16位，最后两位是校验位 整个贷款卡编码的规则如下：
 * 前三位：分别位数字或者大写英文字母
 * 第四位到第十四位：分别为数字 后两位的校验码为
 * 前十四位乘以权重相加后除以97后的余数再加1 后得到的数字
 * 如果此数字为个位数，前面还需要补一个零
 * 前十四位编码对应的权重为  1, 3, 5, 7, 11, 2, 13, 1, 1, 17, 19, 97, 23, 29
 * 如果某一位字母，则需要将此字母转换为数字，A转为10，B转11，以此类推。
 * @author linkepeng
 * @date 2018年12月8日
 */
public class LoanCardUtils {
	
	/**
	 * 权重数组
	 */
    private static final int[] WEIGHT = { 1, 3, 5, 7, 11, 2, 13, 1, 1, 17, 19, 97, 23, 29 };
    
    /**
     * 最大长度 16
     */
    private static final int LOAN_MAX_LEN = 16;
    
    /**
     * 判断头三位是否为字母或者大写字母 正则表达式
     */
    private static final String WORD_PATTERN = "^[0-9A-Z]{3}";
    
    /**
     * 十三位是否为纯数字
     */
    private static final String NO_PATTERN = "^\\\\d{13}$";
    
    /**
     * 验证是否为贷款卡码
     *
     * @param check
     *            需要验证的贷款号码
     * @return
     */
    public static boolean  isLoanCard(String check) {
        // 判断是否为十六位,并且是否传进来的为空
    	if(StringUtils.isBlank(check)) {
    		return false;
    	}
    	int loanLen = StringUtils.length(check);
    	if(loanLen != LOAN_MAX_LEN) {
    		return false;
    	}
        // 判断头三位是否为字母或者大写字母
        if (!check.substring(0, 3).matches(WORD_PATTERN)) {
            return false;
        }
        // 判断是否为最后十三位是否为纯数字
        if (!check.substring(3, check.length()).matches(NO_PATTERN)) {
            return false;
        }
        // 截取后两位验证码
        String validate = check.substring(14, check.length());
        // 获取前十四位字符
        char[] chars = check.substring(0, 14).toCharArray();
        // 计算权重总数值
        int sum = 0;
        for (int i = 0; i < WEIGHT.length; i++) {
            char t = chars[i];
            if (String.valueOf(t).matches("^[A-Z]$")) {
                // 如果前三位有字母的花,转换为对应的数据
                int x = (int) t % 65 + 10;
                sum += x * WEIGHT[i];
            } else {
                sum += Integer.parseInt(String.valueOf(t)) * WEIGHT[i];
            }
        }
        int result = sum % 97 + 1;
        return (result <= 9) ? validate.equals("0" + result) : validate.equals("" + result);
    }
}

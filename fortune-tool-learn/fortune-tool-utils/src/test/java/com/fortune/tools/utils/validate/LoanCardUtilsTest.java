package com.fortune.tools.utils.validate;

import org.junit.Test;

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
public class LoanCardUtilsTest {
    @Test
    public void loanCardTest(){

        /**
         * 3301220000001069
         * 3301220000005644
         * 3301220000001101
         * 3301220000005644
         * 3301220000001101
         * 3301220000001649
         * 3301220000005644
         */
        String loanCardStr = "3301220000001069";
        System.out.println("贷款卡号" + loanCardStr + "验证合格？ " + LoanCardUtils.isLoanCard(loanCardStr));
        loanCardStr = "3301220000001649";
        System.out.println("贷款卡号" + loanCardStr + "验证合格？ " + LoanCardUtils.isLoanCard(loanCardStr));
        loanCardStr = "3301220000005645";
        System.out.println("贷款卡号" + loanCardStr + "验证合格？ " + LoanCardUtils.isLoanCard(loanCardStr));

    }
}

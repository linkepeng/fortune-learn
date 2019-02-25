package com.fortune.tools.utils.security;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class RSAUtilsTest {
    //公钥
    private byte[] publicKey;
    //私钥
    private byte[] privateKey;

    /**
     * 初始化密钥
     * @throws Exception
     */
    @Before
    public void initKey() throws Exception{
        Map<String,Object> keyMap=RSAUtils.initKey();
        publicKey=RSAUtils.getPublicKey(keyMap);
        privateKey=RSAUtils.getPrivateKey(keyMap);
        System.err.println("公钥:\n"+Base64.encodeBase64String(publicKey));
        System.err.println("私钥：\n"+Base64.encodeBase64String(privateKey));
    }

    @Test
    public void testSign() throws Exception{
        String inputStr="RSA数字签名";
        byte[] data=inputStr.getBytes();
        //产生签名 从服务器端加密以后，发送给客户端
        byte[] sign=RSAUtils.sign(data, privateKey);
        System.err.println("签名：\n"+Hex.encodeHexString(sign));
        //验证签名
        boolean status=RSAUtils.verify(data, publicKey, sign);
        System.err.println("状态：\n"+status);
        assertTrue(status);
    }

    @Test
    public void testEnDecry() throws Exception{
        System.err.println("\n-------------私钥加密 --公钥解密----------");
        String inputStr="RSA加密算法";
        System.err.println("原文：\n"+inputStr);
        byte[] data1=inputStr.getBytes();
        //加密
        byte[] encodeData1=RSAUtils.encryptByPrivateKey(data1, privateKey);
        System.err.println("加密后：\n"+Base64.encodeBase64String(encodeData1));
        //解密
        byte[] decodeData1=RSAUtils.decryptByPublicKey(encodeData1, publicKey);
        String outputStr1=new String(decodeData1);
        System.err.println("解密后：\n"+outputStr1);
        //校验
        assertEquals(inputStr, outputStr1);
        System.err.println("\n-------------公钥加密 --私钥解密----------");

        String inputStr2="RSA Enypt Algorithm";
        System.err.println("原文：\n"+inputStr2);
        byte[] data2=inputStr2.getBytes();
        //加密
        byte[] encodeData2=RSAUtils.encryptByPublicKey(data2, publicKey);
        System.err.println("加密后：\n"+Base64.encodeBase64String(encodeData2));
        //解密
        byte[] decodeData2=RSAUtils.decryptByPrivateKey(encodeData2, privateKey);
        String outputStr2=new String(decodeData2);
        System.err.println("解密后：\n"+outputStr2);
    }


}
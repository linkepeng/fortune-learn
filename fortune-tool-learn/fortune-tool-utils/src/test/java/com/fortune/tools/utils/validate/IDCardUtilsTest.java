package com.fortune.tools.utils.validate;


import org.junit.Assert;
import org.junit.Test;

public class IDCardUtilsTest {


    @Test
    public void testVerify(){
        String idCard = "35042519920815091X";
        Assert.assertFalse(IDCardUtils.verify(idCard));
    }
}
package com.fortune.tools.utils.io;


import org.junit.Test;

public class CopyFileUtilsTest {

    @Test
    public void testCopyFile() {
        //复制单个文件，如果目标存在，则覆盖
        String srcPath = "D:/temp/tempfile0.txt";
        String destPath = "D:/temp_bak/tempfile0_bak.txt";
        CopyFileUtils.copyFile(srcPath, destPath, true);
        //如果目标存在，则不覆盖
        CopyFileUtils.copyFile(srcPath, destPath);
        System.out.println();
        //复制文件夹，如果目标存在，则覆盖
        String srcDir = "C:/logs";
        String destDir = "D:/logs";
        CopyFileUtils.copyDirectory(srcDir, destDir, true);
    }
}
package com.fortune.tools.utils.io;

import org.junit.Test;


public class DeleteFileUtilsTest {

    @Test
    public void delete() {
        // 删除文件
        String dir = "D:/temp/temp0";
        DeleteFileUtils.delete(dir);
    }

    @Test
    public void deleteFile() {
        // 删除单个文件
        String file = "D:/temp/temp0/temp1/temp.txt";
        DeleteFileUtils.deleteFile(file);
    }

    @Test
    public void deleteDirectory() {
        // 删除一个目录
        String dir = "D:/temp/temp0/temp1";
        DeleteFileUtils.deleteDirectory(dir);
    }
}
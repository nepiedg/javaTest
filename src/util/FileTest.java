package util;

import java.io.File;
import java.io.IOException;

// 文件类型
public class FileTest {
    private final static String root = "E:/code/d3/";

    // 创建文件
    public static boolean CreatFile(String path, String filename) {
        File file = new File(path + filename);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 创建文件夹
    public static boolean CreateDir(String path) {
        File file = new File(root + path);
        return file.mkdir();
    }

    // 创建多级文件夹
    public static boolean createDirs(String path) {
        File file = new File(root + path);
        return file.mkdirs();
    }
}

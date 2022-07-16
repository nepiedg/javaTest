package util;

import java.io.File;
import java.io.IOException;

// 文件类型
public class FileTest {
    private static String root = "E:/code/d3/";

    public static void CreatFile(String path, String filename) {
        File file = new File(path + filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CreateDir(String path) {
        File file = new File(root + path);
        file.mkdir();
    }

    public static void createDirs(String path) {
        File file = new File(root + path);
        file.mkdirs();
    }
}

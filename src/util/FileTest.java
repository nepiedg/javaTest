package util;

import java.io.File;
import java.io.IOException;

// 文件类型
public class FileTest {
    public static void CreatFile(String path, String filename) {
        File file = new File(path + filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

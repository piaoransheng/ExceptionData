package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    /**
     * 获取当前项目目录下所有excel文件
     *
     * @return 项目目录下所有excel文件
     */
    public static List<File> excelFileList() {
        List<File> excelFileList = new ArrayList<>();
        //1.获取当前项目所在目录
        String projectPath = projectPath();
        if (projectPath != null) {
            //2.扫描该目录下的所有excel文件
            File fileDirectory = new File(projectPath);
            if (fileDirectory.isDirectory()) {
                File[] fileArray = fileDirectory.listFiles();
                if (fileArray != null) {
                    for (File file : fileArray) {
                        if (!file.isDirectory()) {
                            if (((file.getName().toUpperCase().endsWith("XLS")) || file.getName().toUpperCase().endsWith("XLSX")) && !file.getName().contains("已处理")) {
                                excelFileList.add(file);
                            }
                        }
                    }
                    System.out.println("需要处理excel文件数量：" + excelFileList.size());
                }
            }
        }
        return excelFileList;
    }

    /**
     * 获取当前项目所在目录
     *
     * @return 当前项目所在目录
     */
    private static String projectPath() {
        File file = new File("");
        String projectPath = null;
        try {
            projectPath = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projectPath;
    }
}

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
        System.out.println("文件目录：" + projectPath);
        if (projectPath != null) {
            //2.扫描该目录下的所有excel文件
            File fileDirectory = new File(projectPath);
            if (fileDirectory.isDirectory()) {
                File[] fileArray = fileDirectory.listFiles();
                if (fileArray != null) {
                    System.out.println("文件数量：" + fileArray.length);
                    for (File file : fileArray) {
                        if (!file.isDirectory()) {
                            if ((file.getName().toUpperCase().endsWith("XLS")) || file.getName().toUpperCase().endsWith("XLSX")) {
                                excelFileList.add(file);
                            }
                        }
                    }
                    System.out.println("excel文件数量：" + excelFileList.size());
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

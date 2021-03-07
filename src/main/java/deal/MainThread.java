package deal;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import util.ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainThread {
    public static void main(String[] args) {

        //1.获取项目目录下所有的excel文件
        List<File> fileList = ExcelUtil.excelFileList();
        if (CollectionUtils.isNotEmpty(fileList)) {
            for (File file : fileList) {
                Workbook workbook = null;
                FileInputStream fileInputStream = null;
                FileOutputStream fileOutputStream = null;

                //2.读取工作簿
                try {
                    fileInputStream = new FileInputStream(file);   //文件流对象
                    workbook = WorkbookFactory.create(fileInputStream);
                } catch (Exception e) {
                    System.out.println("文件类型错误:" + e);
                }

                //3.创建异常数据sheet
                if (workbook != null) {
                    //2.3创建sheet
                    try {
                        fileOutputStream = new FileOutputStream(file);   //文件输入流对象
                        if (workbook.getSheet("异常数据") == null) {
                            Sheet sheet = workbook.createSheet("异常数据");
                            System.out.println(sheet.getFirstRowNum());
                            workbook.write(fileOutputStream);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("创建异常数据错误：" + e);
                    }
                }

                //关闭流
                try {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (workbook != null) {
                        workbook.close();
                    }
                } catch (IOException e) {
                    System.out.println("关闭流错误:" + e);
                }

            }
        }
    }
}

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     * 给list的每个属性都指定是升序还是降序
     *
     * @param list        排序集合
     * @param sortnameArr 参数数组
     * @param typeArr     每个属性对应的升降序数组， true升序，false降序
     */

    public static <E> void sort(List<E> list, final String[] sortnameArr, final boolean[] typeArr) {
        if (sortnameArr.length != typeArr.length) {
            throw new RuntimeException("属性数组元素个数和升降序数组元素个数不相等");
        }
        list.sort((a, b) -> {
            int ret = 0;
            try {
                for (int i = 0; i < sortnameArr.length; i++) {
                    ret = ExcelUtil.compareObject(sortnameArr[i], typeArr[i], a, b);
                    if (0 != ret) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ret;
        });
    }

    /**
     * 对2个对象按照指定属性名称进行排序
     *
     * @param sortname 属性名称
     * @param isAsc    true升序，false降序
     * @param a        参数a
     * @param b        参数b
     * @return 整形结果
     * @throws Exception 异常
     */
    private static <E> int compareObject(final String sortname, final boolean isAsc, E a, E b) throws Exception {
        int ret;
        Object value1 = ExcelUtil.forceGetFieldValue(a, sortname);
        Object value2 = ExcelUtil.forceGetFieldValue(b, sortname);
        String str1 = value1.toString();
        String str2 = value2.toString();
        if (value1 instanceof Number && value2 instanceof Number) {
            int maxlen = Math.max(str1.length(), str2.length());
            str1 = ExcelUtil.addZero2Str((Number) value1, maxlen);
            str2 = ExcelUtil.addZero2Str((Number) value2, maxlen);
        } else if (value1 instanceof Date && value2 instanceof Date) {
            long time1 = ((Date) value1).getTime();
            long time2 = ((Date) value2).getTime();
            int maxlen = Long.toString(Math.max(time1, time2)).length();
            str1 = ExcelUtil.addZero2Str(time1, maxlen);
            str2 = ExcelUtil.addZero2Str(time2, maxlen);
        }
        if (isAsc) {
            ret = str1.compareTo(str2);
        } else {
            ret = str2.compareTo(str1);
        }
        return ret;
    }

    /**
     * 获取指定对象的指定属性值（去除private,protected的限制）
     *
     * @param obj       属性名称所在的对象
     * @param fieldName 属性名称
     * @return 对象结果
     * @throws Exception 异常信息
     */
    private static Object forceGetFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        Object object;
        boolean accessible = field.isAccessible();
        if (!accessible) {
            // 如果是private,protected修饰的属性，需要修改为可以访问的
            field.setAccessible(true);
            object = field.get(obj);
            // 还原private,protected属性的访问性质
            field.setAccessible(false);
            return object;
        }
        object = field.get(obj);
        return object;
    }

    /**
     * 给数字对象按照指定长度在左侧补0.
     * <p>
     * 使用案例: addZero2Str(11,4) 返回 "0011", addZero2Str(-18,6)返回 "-000018"
     *
     * @param numObj 数字对象
     * @param length 指定的长度
     * @return 异常
     */
    private static String addZero2Str(Number numObj, int length) {
        NumberFormat nf = NumberFormat.getInstance();
        // 设置是否使用分组
        nf.setGroupingUsed(false);
        // 设置最大整数位数
        nf.setMaximumIntegerDigits(length);
        // 设置最小整数位数
        nf.setMinimumIntegerDigits(length);
        return nf.format(numObj);
    }

}

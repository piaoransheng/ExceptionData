package deal;

import bill.QueryStationDetailBillDetailPageVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import util.ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
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


                //2.创建工作簿
                try {
                    fileInputStream = new FileInputStream(file);      //文件流对象
                    workbook = WorkbookFactory.create(fileInputStream);
                } catch (IOException | InvalidFormatException e) {
                    System.out.println("创建工作簿失败:" + e);
                    e.printStackTrace();
                }


                //3.读取excel数据
                QueryStationDetailBillDetailPageVO headRowData;
                List<QueryStationDetailBillDetailPageVO> billDetailList = new ArrayList<>();
                int lastRowNum;
                if (workbook != null && workbook.getSheet("异常数据") == null) {
                    Sheet sheet = workbook.getSheetAt(0);
                    if (sheet != null) {
                        //列表表头
                        Row headRow = sheet.getRow(5);
                        headRowData = listRowData(headRow);
                        billDetailList.add(headRowData);
                        //列表数据
                        lastRowNum = sheet.getLastRowNum();
                        if (lastRowNum >= 8) {
                            for (int h = 6; h <= lastRowNum - 3; h++) {
                                Row row = sheet.getRow(h);
                                QueryStationDetailBillDetailPageVO listRowData = listRowData(row);
                                billDetailList.add(listRowData);
                            }
                        }
                    }
                }

                //4.创建异常数据sheet并写入
                try {
                    fileOutputStream = new FileOutputStream(file);   //文件输入流对象
                    if (workbook != null && workbook.getSheet("异常数据") == null) {
                        Sheet sheet = workbook.createSheet("异常数据");
                        for (int i = 0; i <= billDetailList.size() - 1; i++) {
                            QueryStationDetailBillDetailPageVO billDetailVO = billDetailList.get(i);
                            Row row = sheet.createRow(i);
                            setListRowData(row, billDetailVO);
                        }
                        workbook.write(fileOutputStream);
                    }
                } catch (IOException e) {
                    System.out.println("创建异常数据sheet失败:" + e);
                    e.printStackTrace();
                }

                //5.关闭流
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
                    System.out.println("关闭流失败:" + e);
                    e.printStackTrace();
                }

                //6.文件重命名
                String prePath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("."));   //不带后缀的文件名
                String sufPathWithD = file.getName().substring(file.getName().lastIndexOf("."));  //带.的后缀名
                String newFilePath = prePath + "(已处理)" + sufPathWithD;
                boolean b = file.renameTo(new File(newFilePath));
                System.out.println("文件重命名结果：" + b);

            }
        }
    }

    /**
     * 获取列表数据
     *
     * @param row 列表行
     * @return 列表数据集合
     */
    private static QueryStationDetailBillDetailPageVO listRowData(Row row) {
        QueryStationDetailBillDetailPageVO detailBillDetailPageVO = new QueryStationDetailBillDetailPageVO();
        detailBillDetailPageVO.setOrderCode(row.getCell(0).toString());
        detailBillDetailPageVO.setOperationSource(row.getCell(1).toString());
        detailBillDetailPageVO.setBusiCode(row.getCell(2).toString());
        detailBillDetailPageVO.setDeviceCode(row.getCell(3).toString());
        detailBillDetailPageVO.setGunNumber(row.getCell(4).toString());
        detailBillDetailPageVO.setVin(row.getCell(5).toString());
        detailBillDetailPageVO.setPlateNumber(row.getCell(6).toString());
        if (row.getCell(7) != null) {
            detailBillDetailPageVO.setMotorcade(row.getCell(7).toString());
        }
        if (row.getCell(8) != null) {
            detailBillDetailPageVO.setCircuit(row.getCell(8).toString());
        }
        detailBillDetailPageVO.setPhone(row.getCell(9).toString());
        detailBillDetailPageVO.setStartDate(row.getCell(10).toString());
        detailBillDetailPageVO.setEndDate(row.getCell(11).toString());
        detailBillDetailPageVO.setRealAmount(row.getCell(12).toString());
        detailBillDetailPageVO.setRealElectric(row.getCell(13).toString());
        detailBillDetailPageVO.setChargeAmount(row.getCell(14).toString());
        detailBillDetailPageVO.setElectricAmount(row.getCell(15).toString());
        detailBillDetailPageVO.setRealTime(row.getCell(16).toString());
        detailBillDetailPageVO.setPersonalAccountPay(row.getCell(17).toString());
        detailBillDetailPageVO.setAccountPay(row.getCell(18).toString());
        detailBillDetailPageVO.setAuthPay(row.getCell(19).toString());
        detailBillDetailPageVO.setIcCardPay(row.getCell(20).toString());
        detailBillDetailPageVO.setIcCard(row.getCell(21).toString());
        detailBillDetailPageVO.setStartSoc(row.getCell(22).toString());
        detailBillDetailPageVO.setEndSoc(row.getCell(23).toString());
        detailBillDetailPageVO.setTipElectric(row.getCell(24).toString());
        detailBillDetailPageVO.setTipUnitPrice(row.getCell(25).toString());
        detailBillDetailPageVO.setTipServiceFee(row.getCell(26).toString());
        detailBillDetailPageVO.setTipElectricFee(row.getCell(27).toString());
        detailBillDetailPageVO.setTipTotalFee(row.getCell(28).toString());
        detailBillDetailPageVO.setTipChargingTime(row.getCell(29).toString());
        detailBillDetailPageVO.setPeakElectric(row.getCell(30).toString());
        detailBillDetailPageVO.setPeakUnitPrice(row.getCell(31).toString());
        detailBillDetailPageVO.setPeakServiceFee(row.getCell(32).toString());
        detailBillDetailPageVO.setPeakElectricFee(row.getCell(33).toString());
        detailBillDetailPageVO.setPeakTotalFee(row.getCell(34).toString());
        detailBillDetailPageVO.setPeakChargingTime(row.getCell(35).toString());
        detailBillDetailPageVO.setFlatElectric(row.getCell(36).toString());
        detailBillDetailPageVO.setFlatUnitPrice(row.getCell(37).toString());
        detailBillDetailPageVO.setFlatServiceFee(row.getCell(38).toString());
        detailBillDetailPageVO.setFlatElectricFee(row.getCell(39).toString());
        detailBillDetailPageVO.setFlatTotalFee(row.getCell(40).toString());
        detailBillDetailPageVO.setFlatChargingTime(row.getCell(41).toString());
        detailBillDetailPageVO.setEbbElectric(row.getCell(42).toString());
        detailBillDetailPageVO.setEbbUnitPrice(row.getCell(43).toString());
        detailBillDetailPageVO.setEbbServiceFee(row.getCell(44).toString());
        detailBillDetailPageVO.setEbbElectricFee(row.getCell(45).toString());
        detailBillDetailPageVO.setEbbTotalFee(row.getCell(46).toString());
        detailBillDetailPageVO.setEbbChargingTime(row.getCell(47).toString());
        return detailBillDetailPageVO;
    }

    /**
     * 设置列表数据
     *
     * @param row          行
     * @param billDetailVO 行数据
     */
    private static void setListRowData(Row row, QueryStationDetailBillDetailPageVO billDetailVO) {
        row.createCell(0).setCellValue(billDetailVO.getOrderCode());
        row.createCell(1).setCellValue(billDetailVO.getOperationSource());
        row.createCell(2).setCellValue(billDetailVO.getBusiCode());
        row.createCell(3).setCellValue(billDetailVO.getDeviceCode());
        row.createCell(4).setCellValue(billDetailVO.getGunNumber());
        row.createCell(5).setCellValue(billDetailVO.getVin());
        row.createCell(6).setCellValue(billDetailVO.getPlateNumber());
        row.createCell(7).setCellValue(billDetailVO.getMotorcade());
        row.createCell(8).setCellValue(billDetailVO.getCircuit());
        row.createCell(9).setCellValue(billDetailVO.getPhone());
        row.createCell(10).setCellValue(billDetailVO.getStartDate());
        row.createCell(11).setCellValue(billDetailVO.getEndDate());
        row.createCell(12).setCellValue(billDetailVO.getRealAmount());
        row.createCell(13).setCellValue(billDetailVO.getRealElectric());
        row.createCell(14).setCellValue(billDetailVO.getChargeAmount());
        row.createCell(15).setCellValue(billDetailVO.getElectricAmount());
        row.createCell(16).setCellValue(billDetailVO.getRealTime());
        row.createCell(17).setCellValue(billDetailVO.getPersonalAccountPay());
        row.createCell(18).setCellValue(billDetailVO.getAccountPay());
        row.createCell(19).setCellValue(billDetailVO.getAuthPay());
        row.createCell(20).setCellValue(billDetailVO.getIcCardPay());
        row.createCell(21).setCellValue(billDetailVO.getIcCard());
        row.createCell(22).setCellValue(billDetailVO.getStartSoc());
        row.createCell(23).setCellValue(billDetailVO.getEndSoc());
        row.createCell(24).setCellValue(billDetailVO.getTipElectric());
        row.createCell(25).setCellValue(billDetailVO.getTipUnitPrice());
        row.createCell(26).setCellValue(billDetailVO.getTipServiceFee());
        row.createCell(27).setCellValue(billDetailVO.getTipElectricFee());
        row.createCell(28).setCellValue(billDetailVO.getTipTotalFee());
        row.createCell(29).setCellValue(billDetailVO.getTipChargingTime());
        row.createCell(30).setCellValue(billDetailVO.getPeakElectric());
        row.createCell(31).setCellValue(billDetailVO.getPeakUnitPrice());
        row.createCell(32).setCellValue(billDetailVO.getPeakServiceFee());
        row.createCell(33).setCellValue(billDetailVO.getPeakElectricFee());
        row.createCell(34).setCellValue(billDetailVO.getPeakTotalFee());
        row.createCell(35).setCellValue(billDetailVO.getPeakChargingTime());
        row.createCell(36).setCellValue(billDetailVO.getFlatElectric());
        row.createCell(37).setCellValue(billDetailVO.getFlatUnitPrice());
        row.createCell(38).setCellValue(billDetailVO.getFlatServiceFee());
        row.createCell(39).setCellValue(billDetailVO.getFlatElectricFee());
        row.createCell(40).setCellValue(billDetailVO.getFlatTotalFee());
        row.createCell(41).setCellValue(billDetailVO.getFlatChargingTime());
        row.createCell(42).setCellValue(billDetailVO.getEbbElectric());
        row.createCell(43).setCellValue(billDetailVO.getEbbUnitPrice());
        row.createCell(44).setCellValue(billDetailVO.getEbbServiceFee());
        row.createCell(45).setCellValue(billDetailVO.getEbbElectricFee());
        row.createCell(46).setCellValue(billDetailVO.getEbbTotalFee());
        row.createCell(47).setCellValue(billDetailVO.getEbbChargingTime());
    }

    /**
     * 筛选异常的订单
     * <p>
     * 1.soc为空的或者0的
     * 2.soc差距大但是充电量小
     * 3.vin 充电时候支付号码跟 vin 不一样的
     * 4.峰平谷 跟总量对不上的
     * 5.订单开始时间结束时间充电费一样的
     *
     * @param billDetailList 订单集合
     */
    private static void selectList(List<QueryStationDetailBillDetailPageVO> billDetailList) {
        for (int i = billDetailList.size() - 1; i >= 1; i--) {
            QueryStationDetailBillDetailPageVO rowData = billDetailList.get(i);
            //1.soc为空的或者0的
            if (rowData.getStartSoc() != null && !rowData.getStartSoc().equals("0") && rowData.getEndSoc() != null && !rowData.getEndSoc().equals("0")) {
                billDetailList.remove(i);
                //2.soc差距大但是充电量小
            }
        }
    }

    /**
     * 计算两个百分比数的差
     *
     * @param num1 被减数
     * @param num2 减数
     * @return 差
     * @throws Exception 异常
     */
    private static double comparePrecent(String num1, String num2) throws Exception {
        //接受字符串类型的百分数
        NumberFormat nf = NumberFormat.getPercentInstance();
        //将double类型的量转化为字符串输出
        DecimalFormat df = new DecimalFormat("0%");
        //用NumberFormat的parse方法和doubleValue方法将字符串百分数转换为double类型的可计算数值
        //再将double转为String输出
//        String result = df.format(compare);
        return nf.parse(num1).doubleValue() - nf.parse(num2).doubleValue();
    }
}
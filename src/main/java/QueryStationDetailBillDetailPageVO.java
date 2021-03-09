public class QueryStationDetailBillDetailPageVO {
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 订单来源
     */
    private String operationSource;
    /**
     * 交易编码
     */
    private String busiCode;
    /**
     * 设备编号
     */
    private String deviceCode;
    /**
     * 枪编号
     */
    private String gunNumber;
    /**
     * VIN码
     */
    private String vin;
    /**
     * 车牌号
     */
    private String plateNumber;
    /**
     * 所属车队
     */
    private String motorcade;
    /**
     * 线路
     */
    private String circuit;
    /**
     * 用户名（原型是手机号）
     */
    private String phone;
    /**
     * 订单开始时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String startDate;
    /**
     * 订单结束时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String endDate;
    /**
     * 订单金额（元）
     */
    private String realAmount;
    /**
     * 充电量(度)
     */
    private String realElectric;
    /**
     * 充电电费(元)
     */
    private String chargeAmount;
    /**
     * 充电服务费(元)
     */
    private String electricAmount;
    /**
     * 充电时长(00:15:12)
     */
    private String realTime;
    /**
     * 个人账户支付
     */
    private String personalAccountPay;
    /**
     * 客户账户支付
     */
    private String accountPay;
    /**
     * 授信支付
     */
    private String authPay;
    /**
     * IC卡余额支付
     */
    private String icCardPay;
    /**
     * IC卡号
     */
    private String icCard;
    /**
     * 起始SOC
     */
    private String startSoc;
    /**
     * 结束SOC
     */
    private String endSoc;
    /**
     * 尖充电量
     */
    private String tipElectric;
    /**
     * 尖实际电费单价+服务费单价（元）
     */
    private String tipUnitPrice;
    /**
     * 尖服务费（元）
     */
    private String tipServiceFee;
    /**
     * 尖电费（元）
     */
    private String tipElectricFee;
    /**
     * 尖总费用（元）
     */
    private String tipTotalFee;
    /**
     * 尖充电时长（分钟）
     */
    private String tipChargingTime;
    /**
     * 峰充电量
     */
    private String peakElectric;
    /**
     * 峰实际电费单价+服务费单价（元）
     */
    private String peakUnitPrice;
    /**
     * 峰服务费（元）
     */
    private String peakServiceFee;
    /**
     * 峰电费（元）
     */
    private String peakElectricFee;
    /**
     * 峰总费用（元）
     */
    private String peakTotalFee;
    /**
     * 峰充电时长（分钟）
     */
    private String peakChargingTime;
    /**
     * 平充电量
     */
    private String flatElectric;
    /**
     * 平实际电费单价+服务费单价（元）
     */
    private String flatUnitPrice;
    /**
     * 平服务费（元）
     */
    private String flatServiceFee;
    /**
     * 平电费（元）
     */
    private String flatElectricFee;
    /**
     * 平总费用（元）
     */
    private String flatTotalFee;
    /**
     * 平充电时长（分钟）
     */
    private String flatChargingTime;
    /**
     * 谷充电量
     */
    private String ebbElectric;
    /**
     * 谷实际电费单价+服务费单价（元）
     */
    private String ebbUnitPrice;
    /**
     * 谷服务费（元）
     */
    private String ebbServiceFee;
    /**
     * 谷电费（元）
     */
    private String ebbElectricFee;
    /**
     * 谷总费用（元）
     */
    private String ebbTotalFee;
    /**
     * 谷充电时长（分钟）
     */
    private String ebbChargingTime;
    /**
     * 异常原因
     */
    private String exceptionReason;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOperationSource() {
        return operationSource;
    }

    public void setOperationSource(String operationSource) {
        this.operationSource = operationSource;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getGunNumber() {
        return gunNumber;
    }

    public void setGunNumber(String gunNumber) {
        this.gunNumber = gunNumber;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMotorcade() {
        return motorcade;
    }

    public void setMotorcade(String motorcade) {
        this.motorcade = motorcade;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(String realAmount) {
        this.realAmount = realAmount;
    }

    public String getRealElectric() {
        return realElectric;
    }

    public void setRealElectric(String realElectric) {
        this.realElectric = realElectric;
    }

    public String getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(String chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public String getElectricAmount() {
        return electricAmount;
    }

    public void setElectricAmount(String electricAmount) {
        this.electricAmount = electricAmount;
    }

    public String getRealTime() {
        return realTime;
    }

    public void setRealTime(String realTime) {
        this.realTime = realTime;
    }

    public String getPersonalAccountPay() {
        return personalAccountPay;
    }

    public void setPersonalAccountPay(String personalAccountPay) {
        this.personalAccountPay = personalAccountPay;
    }

    public String getAccountPay() {
        return accountPay;
    }

    public void setAccountPay(String accountPay) {
        this.accountPay = accountPay;
    }

    public String getAuthPay() {
        return authPay;
    }

    public void setAuthPay(String authPay) {
        this.authPay = authPay;
    }

    public String getIcCardPay() {
        return icCardPay;
    }

    public void setIcCardPay(String icCardPay) {
        this.icCardPay = icCardPay;
    }

    public String getIcCard() {
        return icCard;
    }

    public void setIcCard(String icCard) {
        this.icCard = icCard;
    }

    public String getStartSoc() {
        return startSoc;
    }

    public void setStartSoc(String startSoc) {
        this.startSoc = startSoc;
    }

    public String getEndSoc() {
        return endSoc;
    }

    public void setEndSoc(String endSoc) {
        this.endSoc = endSoc;
    }

    public String getTipElectric() {
        return tipElectric;
    }

    public void setTipElectric(String tipElectric) {
        this.tipElectric = tipElectric;
    }

    public String getTipUnitPrice() {
        return tipUnitPrice;
    }

    public void setTipUnitPrice(String tipUnitPrice) {
        this.tipUnitPrice = tipUnitPrice;
    }

    public String getTipServiceFee() {
        return tipServiceFee;
    }

    public void setTipServiceFee(String tipServiceFee) {
        this.tipServiceFee = tipServiceFee;
    }

    public String getTipElectricFee() {
        return tipElectricFee;
    }

    public void setTipElectricFee(String tipElectricFee) {
        this.tipElectricFee = tipElectricFee;
    }

    public String getTipTotalFee() {
        return tipTotalFee;
    }

    public void setTipTotalFee(String tipTotalFee) {
        this.tipTotalFee = tipTotalFee;
    }

    public String getTipChargingTime() {
        return tipChargingTime;
    }

    public void setTipChargingTime(String tipChargingTime) {
        this.tipChargingTime = tipChargingTime;
    }

    public String getPeakElectric() {
        return peakElectric;
    }

    public void setPeakElectric(String peakElectric) {
        this.peakElectric = peakElectric;
    }

    public String getPeakUnitPrice() {
        return peakUnitPrice;
    }

    public void setPeakUnitPrice(String peakUnitPrice) {
        this.peakUnitPrice = peakUnitPrice;
    }

    public String getPeakServiceFee() {
        return peakServiceFee;
    }

    public void setPeakServiceFee(String peakServiceFee) {
        this.peakServiceFee = peakServiceFee;
    }

    public String getPeakElectricFee() {
        return peakElectricFee;
    }

    public void setPeakElectricFee(String peakElectricFee) {
        this.peakElectricFee = peakElectricFee;
    }

    public String getPeakTotalFee() {
        return peakTotalFee;
    }

    public void setPeakTotalFee(String peakTotalFee) {
        this.peakTotalFee = peakTotalFee;
    }

    public String getPeakChargingTime() {
        return peakChargingTime;
    }

    public void setPeakChargingTime(String peakChargingTime) {
        this.peakChargingTime = peakChargingTime;
    }

    public String getFlatElectric() {
        return flatElectric;
    }

    public void setFlatElectric(String flatElectric) {
        this.flatElectric = flatElectric;
    }

    public String getFlatUnitPrice() {
        return flatUnitPrice;
    }

    public void setFlatUnitPrice(String flatUnitPrice) {
        this.flatUnitPrice = flatUnitPrice;
    }

    public String getFlatServiceFee() {
        return flatServiceFee;
    }

    public void setFlatServiceFee(String flatServiceFee) {
        this.flatServiceFee = flatServiceFee;
    }

    public String getFlatElectricFee() {
        return flatElectricFee;
    }

    public void setFlatElectricFee(String flatElectricFee) {
        this.flatElectricFee = flatElectricFee;
    }

    public String getFlatTotalFee() {
        return flatTotalFee;
    }

    public void setFlatTotalFee(String flatTotalFee) {
        this.flatTotalFee = flatTotalFee;
    }

    public String getFlatChargingTime() {
        return flatChargingTime;
    }

    public void setFlatChargingTime(String flatChargingTime) {
        this.flatChargingTime = flatChargingTime;
    }

    public String getEbbElectric() {
        return ebbElectric;
    }

    public void setEbbElectric(String ebbElectric) {
        this.ebbElectric = ebbElectric;
    }

    public String getEbbUnitPrice() {
        return ebbUnitPrice;
    }

    public void setEbbUnitPrice(String ebbUnitPrice) {
        this.ebbUnitPrice = ebbUnitPrice;
    }

    public String getEbbServiceFee() {
        return ebbServiceFee;
    }

    public void setEbbServiceFee(String ebbServiceFee) {
        this.ebbServiceFee = ebbServiceFee;
    }

    public String getEbbElectricFee() {
        return ebbElectricFee;
    }

    public void setEbbElectricFee(String ebbElectricFee) {
        this.ebbElectricFee = ebbElectricFee;
    }

    public String getEbbTotalFee() {
        return ebbTotalFee;
    }

    public void setEbbTotalFee(String ebbTotalFee) {
        this.ebbTotalFee = ebbTotalFee;
    }

    public String getEbbChargingTime() {
        return ebbChargingTime;
    }

    public void setEbbChargingTime(String ebbChargingTime) {
        this.ebbChargingTime = ebbChargingTime;
    }

    public String getExceptionReason() {
        return exceptionReason;
    }

    public void setExceptionReason(String exceptionReason) {
        this.exceptionReason = exceptionReason;
    }
}
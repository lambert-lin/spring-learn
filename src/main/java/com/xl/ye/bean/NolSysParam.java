package com.xl.ye.bean;

import java.lang.String;

public class NolSysParam {
	private String sysId;
	
	private String paramCode;

	private String paramName;

	private String paramDesc;

	private String paramValue;

	private String rsrv1;

	private String rsrv2;

	private String useFlag;

	private String inptDate;

	private String inptTime;
	
	private String mntDate;

	private String mntTime;

	private String rcrdStCode;

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getParamCode() {
		return paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamDesc() {
		return paramDesc;
	}

	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getRsrv1() {
		return rsrv1;
	}

	public void setRsrv1(String rsrv1) {
		this.rsrv1 = rsrv1;
	}

	public String getRsrv2() {
		return rsrv2;
	}

	public void setRsrv2(String rsrv2) {
		this.rsrv2 = rsrv2;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	public String getInptDate() {
		return inptDate;
	}

	public void setInptDate(String inptDate) {
		this.inptDate = inptDate;
	}

	public String getInptTime() {
		return inptTime;
	}

	public void setInptTime(String inptTime) {
		this.inptTime = inptTime;
	}

	public String getMntDate() {
		return mntDate;
	}

	public void setMntDate(String mntDate) {
		this.mntDate = mntDate;
	}

	public String getMntTime() {
		return mntTime;
	}

	public void setMntTime(String mntTime) {
		this.mntTime = mntTime;
	}

	public String getRcrdStCode() {
		return rcrdStCode;
	}

	public void setRcrdStCode(String rcrdStCode) {
		this.rcrdStCode = rcrdStCode;
	}

	@Override
	public String toString() {
		return paramValue;
	}

}
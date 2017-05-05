package cn.posolft.pojo;

public class A {
	
	private String date;//日期
	private double syrye;//上一日余额
	private double dyye;//当日余额
	private double drcz;//当日充值
	private double drtk;//单日提款
	private double drsxf;//当日手续费
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getSyrye() {
		return syrye;
	}
	public void setSyrye(double syrye) {
		this.syrye = syrye;
	}
	public double getDrcz() {
		return drcz;
	}
	public void setDrcz(double drcz) {
		this.drcz = drcz;
	}
	public double getDrtk() {
		return drtk;
	}
	public void setDrtk(double drtk) {
		this.drtk = drtk;
	}
	public double getDrsxf() {
		return drsxf;
	}
	public void setDrsxf(double drsxf) {
		this.drsxf = drsxf;
	}
	
	public double getDyye() {
		return dyye;
	}
	public void setDyye(double dyye) {
		this.dyye = dyye;
	}
	/**
	 * 计算设置得到当日交易余额
	 * @return
	 */
	public double getAndSetDyye(){
		this.dyye = this.syrye + this.drcz - this.drtk - this.drsxf;
		return this.dyye;
	}
	
}

package cn.posolft.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		double csye = 100d;//初始余额
		List<A> as = new ArrayList<A>();
		for (int i = 0; i < as.size(); i++) {
			A a = as.get(i);
			//设置上一日余额
			if(i==0){
				a.setSyrye(csye);
			}else{
				A b = as.get(i-1);
				a.setSyrye(b.getDyye());
			}
			//设置计算当日余额
			a.getAndSetDyye();
			as.set(i, a);
		}
	}
}

package com.pwm.bean;

import org.junit.Before;

import com.pwm.beans.MeterResultBean;
import com.pwm.util.TesteBeanUtil;

public class MeterResultBeanTeste extends TesteBeanUtil {
	
	private MeterResultBean bean;
	
	@Before
	public void inicializar() {
		this.bean = new MeterResultBean();
	}

	@Override
	public Object getBean() {
		return this.bean;
	}
}

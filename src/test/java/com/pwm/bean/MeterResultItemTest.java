package com.pwm.bean;

import org.junit.Before;

import com.pwm.beans.MeterResultItem;
import com.pwm.util.TesteBeanUtil;

public class MeterResultItemTest extends TesteBeanUtil {

	private MeterResultItem bean; 
	
	@Before
	public void inicializar() {
		this.bean = new MeterResultItem();
	}
	
	@Override
	public Object getBean() {
		return this.bean;
	}
}

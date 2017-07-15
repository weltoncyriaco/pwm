package com.pwm.util;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Test;

public abstract class TesteBeanUtil extends TestUtil {


	public abstract Object getBean();
	
	@Test
	public void validarExistenciaMetodosGet() {
		Assert.assertNotNull(getBean());
		try {
			for (Field field : getBean().getClass().getDeclaredFields()) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				if (!SERIAL_VERSION_UID.equalsIgnoreCase(field.getName())) {
					Assert.assertNotNull(field.getName(), getMetodoInstance(field, getBean()));
				}
			}
		} catch (IllegalArgumentException e) {
			Assert.fail(ERRO_ACESSAR_FIELD);
		}
	}
	
	@Test
	public void validarExistenciaMetodosSet() {
		Assert.assertNotNull(getBean());
		try {
			for (Field field : getBean().getClass().getDeclaredFields()) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				if (!SERIAL_VERSION_UID.equalsIgnoreCase(field.getName())) {
					Assert.assertNotNull(field.getName(), setMetodoInstance(field, getBean()));
				}
			}
		} catch (IllegalArgumentException e) {
			Assert.fail(ERRO_ACESSAR_FIELD);
		}
	}
}

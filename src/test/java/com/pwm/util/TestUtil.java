package com.pwm.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.pwm.utils.Numeros;

public abstract class TestUtil {

	protected static final String GET = "get";
	protected static final String SET = "set";	
	protected static final String SERIAL_VERSION_UID = "serialVersionUID";
	protected static final String ERRO_ACESSAR_FIELD = "Erro ao acessar field";
	
	protected Method setMetodoInstance(Field field, Object variaveis) {
		try {
			String metodo = getMetodoNome(SET, field);
			return variaveis.getClass().getDeclaredMethod(metodo, field.getType());
		} catch (NoSuchMethodException | SecurityException e) {
			return null;
		}
	}
	
	protected Method getMetodoInstance(Field field, Object variaveis) {
		String metodo = getMetodoNome(GET, field);
		return getMetodoInstance(metodo, variaveis);
	}

	protected Method getMetodoInstance(String metodo, Object variaveis) {
		try {
			return variaveis.getClass().getDeclaredMethod(metodo);
		} catch (NoSuchMethodException | SecurityException e) {
			return null;
		}
	}

	protected String getMetodoNome(String tipo, Field field) {
		String metodo = new StringBuilder(field.getName()).replace(Numeros.ZERO, Numeros.UM, field.getName().substring(Numeros.ZERO, Numeros.UM).toUpperCase()).toString();
		return tipo.concat(metodo);
	}
}

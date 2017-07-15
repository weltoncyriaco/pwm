package com.pwm.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pwm.beans.VariavelChecarSenha;
import com.pwm.util.TesteBeanUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VariavelChecarSenhaTest extends TesteBeanUtil {

	private static final String METODO_DEVE_INICIAR_COM_INCREMENTAR = "O metodo %s deve iniciar com incrementar.";
	private static final String INCREMENTAR = "incrementar";
	private static final String INCREMENTA = "incrementa";
	
	@Autowired
	private VariavelChecarSenha variaveis;
	

	@Override
	public Object getBean() {
		return this.variaveis;
	}
	
	@Test
	public void validarInjecaoDependencia() {
		Assert.assertNotNull(variaveis);
	}

	@Test
	public void validarIncializar() {
		Assert.assertNotNull(variaveis);
		try {
			for (Field field : variaveis.getClass().getDeclaredFields()) {
				if (!field.isAccessible()) {
					field.setAccessible(true);
				}
				Assert.assertNotNull(field.getName(), field.get(variaveis));
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			Assert.fail(ERRO_ACESSAR_FIELD);
		}
	}
	
	
	@Test
	public void validarMetodosIncrementar() {
		try {
			for (Method method : variaveis.getClass().getDeclaredMethods()) {
				if (!method.getName().startsWith(INCREMENTAR) && method.getName().startsWith(INCREMENTA)) {
					Assert.fail(String.format(METODO_DEVE_INICIAR_COM_INCREMENTAR, method.getName()));
				}
			}
		} catch (IllegalArgumentException e) {
			Assert.fail(ERRO_ACESSAR_FIELD);
		}
	}
	

	@Test
	public void validarMetodosIncrementarNomeIncompleto() {
		try {
			for (Method method : variaveis.getClass().getDeclaredMethods()) {
				if (method.getName().startsWith(INCREMENTAR)) {
					String getMmethodName = method.getName().replaceFirst(INCREMENTAR, GET);
					Object valorOriginal = getMetodoInstance(getMmethodName, variaveis).invoke(variaveis);
					method.invoke(variaveis);
					Object valorFinal = getMetodoInstance(getMmethodName, variaveis).invoke(variaveis);
					Assert.assertNotEquals(valorOriginal, valorFinal);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			Assert.fail(ERRO_ACESSAR_FIELD);
		}
	}
}

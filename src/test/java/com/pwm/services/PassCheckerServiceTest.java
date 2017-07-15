package com.pwm.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pwm.beans.MeterResultBean;
import com.pwm.utils.Constantes;
import com.pwm.utils.Numeros;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassCheckerServiceTest {

	private static final String SENHA_MUITO_FORTE_MINUSCULA = "numeromediadesenvlviasyrtyvbnvbdacomasdasaqasdazxcakjnmwerntestefavdfsdasdkjwenqjwh";
	private static final String SENHA_FORTE_MINUSCULA = "numeromediadesenvlvidacomqasdazxcakjnmwerntestefavdfsdasdkjwenqjwh";
	private static final String SENHA_BOA_MINUSCULA = "numeromediadesenvlvidacomtestefavdfsdasdkjwenqjwh";
	private static final String SENHA_FRACA_MINUSCULA = "numeromediadesenvlvida";
	private static final String PASSWORD_MINUSCULA = "password";
	private static final String SENHA_MINUSCULA = "senha";
	
	private static final String SENHA_MUITO_FORTE_MAIUSCULA = "NUMEROMEDIADESENVLVIASYRTYVBNVBDACOMASDASAQASDAZXCAKJNMWERNTESTEFAVDFSDASDKJWENQJWH";
	private static final String SENHA_FORTE_MAIUSCULA = "NUMEROMEDIADESENVLVIDACOMQASDAZXCAKJNMWERNTESTEFAVDFSDASDKJWENQJWH";
	private static final String SENHA_BOA_MAIUSCULA = "NUMEROMEDIADESENVLVIDACOMTESTEFAVDFSDASDKJWENQJWH";
	private static final String SENHA_FRACA_MAIUSCULA = "NUMEROMEDIADESENVLVIDA";
	private static final String PASSWORD_MAIUSCULA = "PASSWORD";
	private static final String SENHA_MAIUSCULA = "SENHA";

	private static final String SENHA_LETRA_MUITO_FRACA = "sEnh";
	private static final String SENHA_LETRA_FRACA = "dEsEnVO";
	private static final String SENHA_LETRA_BOA = "dEsEnVOlvi";
	private static final String SENHA_LETRA_FORTE = "dEsEnVOlviMento";
	private static final String SENHA_LETRA_MUITO_FORTE = "dEsEnVOlviMentoPwMetEr";
	
	private static final String SENHA_NUMERO_MUITO_FRACA = "s3";
	private static final String SENHA_NUMERO_FRACA = "s3nh";
	private static final String SENHA_NUMERO_BOA = "d3s1nVe";
	private static final String SENHA_NUMERO_FORTE = "d3s1nVe0";
	private static final String SENHA_NUMERO_MUITO_FORTE = "d3s1nVe02tS";
	
	@Autowired
	private PassCheckerService service;
	
	@Test
	public void validarInjecaoDependencia() {
		Assert.assertNotNull(service);
	}
	
	@Test
	public void validarSenhaMinuscula() {
		MeterResultBean result = service.checarSenha(SENHA_MINUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_MINUSCULA, (result.getScore() == Numeros.SETE && Constantes.COMPLEXIDADE_SENHA_MUITO_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(PASSWORD_MINUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(PASSWORD_MINUSCULA, (result.getScore() == Numeros.OITO && Constantes.COMPLEXIDADE_SENHA_MUITO_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_FRACA_MINUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_FRACA_MINUSCULA, (result.getScore() == Numeros.VINTE_E_TRES && Constantes.COMPLEXIDADE_SENHA_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_BOA_MINUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_BOA_MINUSCULA, (result.getScore() == Numeros.QUARENTA_E_NOVE && Constantes.COMPLEXIDADE_SENHA_BOA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_FORTE_MINUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_FORTE_MINUSCULA, (result.getScore() == Numeros.SESSENTA_E_QUATRO && Constantes.COMPLEXIDADE_SENHA_FORTE.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_MUITO_FORTE_MINUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_MUITO_FORTE_MINUSCULA, (result.getScore() == Numeros.OITENTA && Constantes.COMPLEXIDADE_SENHA_MUITO_FORTE.equals(result.getResultado())));
	}
	
	@Test
	public void validarSenhaMaiusculas() {
		MeterResultBean result = service.checarSenha(SENHA_MAIUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_MAIUSCULA, (result.getScore() == Numeros.SETE && Constantes.COMPLEXIDADE_SENHA_MUITO_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(PASSWORD_MAIUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(PASSWORD_MAIUSCULA, (result.getScore() == Numeros.OITO && Constantes.COMPLEXIDADE_SENHA_MUITO_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_FRACA_MAIUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_FRACA_MAIUSCULA, (result.getScore() == Numeros.VINTE_E_TRES && Constantes.COMPLEXIDADE_SENHA_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_BOA_MAIUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_BOA_MAIUSCULA, (result.getScore() == Numeros.QUARENTA_E_NOVE && Constantes.COMPLEXIDADE_SENHA_BOA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_FORTE_MAIUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_FORTE_MAIUSCULA, (result.getScore() == Numeros.SESSENTA_E_QUATRO && Constantes.COMPLEXIDADE_SENHA_FORTE.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_MUITO_FORTE_MAIUSCULA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_MUITO_FORTE_MAIUSCULA, (result.getScore() == Numeros.OITENTA && Constantes.COMPLEXIDADE_SENHA_MUITO_FORTE.equals(result.getResultado())));
	}
	
	@Test
	public void validarSenhaSomenteLetras() {
		MeterResultBean result = service.checarSenha(SENHA_LETRA_MUITO_FRACA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_LETRA_MUITO_FRACA, (result.getScore() == Numeros.DEZOITO && Constantes.COMPLEXIDADE_SENHA_MUITO_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_LETRA_FRACA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_LETRA_FRACA, (result.getScore() == Numeros.TRINTA_E_DOIS && Constantes.COMPLEXIDADE_SENHA_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_LETRA_BOA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_LETRA_BOA, (result.getScore() == Numeros.QUARENTA_E_TRES && Constantes.COMPLEXIDADE_SENHA_BOA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_LETRA_FORTE);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_LETRA_FORTE, (result.getScore() == Numeros.SESSENTA_E_DOIS && Constantes.COMPLEXIDADE_SENHA_FORTE.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_LETRA_MUITO_FORTE);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_LETRA_MUITO_FORTE, (result.getScore() == Numeros.NOVENTA_E_CINCO && Constantes.COMPLEXIDADE_SENHA_MUITO_FORTE.equals(result.getResultado())));
	}
	
	@Test
	public void validarSenhaComNumeros() {
		MeterResultBean result = service.checarSenha(SENHA_NUMERO_MUITO_FRACA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_NUMERO_MUITO_FRACA, (result.getScore() == Numeros.QUATORZE && Constantes.COMPLEXIDADE_SENHA_MUITO_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_NUMERO_FRACA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_NUMERO_FRACA, (result.getScore() == Numeros.VINTE_E_DOIS && Constantes.COMPLEXIDADE_SENHA_FRACA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_NUMERO_BOA);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_NUMERO_BOA, (result.getScore() == Numeros.CINQUENTA_E_OITO && Constantes.COMPLEXIDADE_SENHA_BOA.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_NUMERO_FORTE);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_NUMERO_FORTE, (result.getScore() == Numeros.SETENTA_E_OITO && Constantes.COMPLEXIDADE_SENHA_FORTE.equals(result.getResultado())));
		
		result = service.checarSenha(SENHA_NUMERO_MUITO_FORTE);
		Assert.assertNotNull(result);
		Assert.assertTrue(SENHA_NUMERO_MUITO_FORTE, (result.getScore() == Numeros.CEM && Constantes.COMPLEXIDADE_SENHA_MUITO_FORTE.equals(result.getResultado())));
	}
}

package com.pwm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwm.beans.MeterResultBean;
import com.pwm.beans.MeterResultItem;
import com.pwm.beans.VariavelChecarSenha;
import com.pwm.utils.Constantes;
import com.pwm.utils.Multiplicadores;
import com.pwm.utils.Numeros;
import com.pwm.utils.Regexs;

@Service
public class PassCheckerServiceImpl implements PassCheckerService {
	
	@Autowired
	private VariavelChecarSenha variaveis;

	@Override
	public MeterResultBean checarSenha(String senha) {
		variaveis.inicializar();
		variaveis.setScore(senha.length() * Multiplicadores.TAMANHO);
		variaveis.setTamanho(senha.length());
		variaveis.setPasswordArray(getArrayCaracteres(senha));
		validarSenha(senha);
		calcularScore(senha);
		determinarComplexidadeSenha();
		
		MeterResultBean result = MontarResultado();
		return result;
	}

	private void validarSenha(String senha) {
		validarSenhaLetrasNumerosSimbolos();
		validarSenhaLetrasSequenciais(senha);
		validarSenhaNumerosSequenciais(senha);
		validarSenhaSimbolosSequenciais(senha);
	}
	
	private void calcularScore(String senha) {
		calcularScoreLetraMaiuscula();
		calcularScoreLetraMinuscula();
		calcularScoreNumero();
		calcularScoreSimbolo();
		calcularScoreCaractere();
		calcularDeducoesScore();
		calcularScoreCaractereRequerido();
		calcularScoreRequerimentos(senha);
	}
	
	private void calcularDeducoesScore() {
		calcularDeducoesScoreApenasLetras();
		calcularDeducoesScoreApenasNumeros();
		calcularDeducoesScoreCaractereRepetido();
		calcularDeducoesScoreLetrasMaiusculasConsecutivas();
		calcularDeducoesScoreLetrasMinusculasConsecutivas();
		calcularDeducoesScoreNumerosConsecutivos();
		calcularDeducoesScoreLetrasSequenciais();
		calcularDeducoesScoreNumerosSequenciais();
		calcularDeducoesScoreSimbolosSequenciais();
	}

	private MeterResultBean MontarResultado() {
		MeterResultBean result = new MeterResultBean(variaveis.getComplexidade(), variaveis.getScore()); 
		result.addItens(new MeterResultItem().setDescricao(Constantes.NUMBER_OF_CHARACTERS).setQuantidade(variaveis.getTamanho()).setBonus(variaveis.getCaracteresBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.UPPERCASE_LETTERS).setQuantidade(variaveis.getLetraMaiuscula()).setBonus(variaveis.getLetrasMaiusculasBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.LOWERCASE_LETTERS).setQuantidade(variaveis.getLetraMinuscula()).setBonus(variaveis.getLetrasMinusculasBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.NUMBERS).setQuantidade(variaveis.getNumero()).setBonus(variaveis.getNumerosBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.SYMBOLS).setQuantidade(variaveis.getSimbolo()).setBonus(variaveis.getSimbolosBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.MIDDLE_NUMBERS_OR_SYMBOLS).setQuantidade(variaveis.getCaractereAoMeio()).setBonus(variaveis.getCaractereAoMeioBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.REQUIREMENTS).setQuantidade(variaveis.getRequerimento()).setBonus(variaveis.getRequerimentosBonus()));
		
		result.addItens(new MeterResultItem().setDescricao(Constantes.LETTERS_ONLY).setQuantidade(variaveis.getApenasLetra()).setBonus(variaveis.getApenasLetrasBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.NUMBERS_ONLY).setQuantidade(variaveis.getApenasNumero()).setBonus(variaveis.getApenasNumerosBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.REPEAT_CHARACTERS_CASE_INSENSITIVE).setQuantidade(variaveis.getCaractereRepetido()).setBonus(variaveis.getCaracteresRepetidosBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.CONSECUTIVE_UPPERCASE_LETTERS).setQuantidade(variaveis.getLetraMaiusculaConsecutiva()).setBonus(variaveis.getLetrasMaiusculasConsecutivasBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.CONSECUTIVE_LOWERCASE_LETTERS).setQuantidade(variaveis.getLetraMinusculasConsecutiva()).setBonus(variaveis.getLetrasMinusculasConsecutivasBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.CONSECUTIVE_NUMBERS).setQuantidade(variaveis.getNumeroConsecutivo()).setBonus(variaveis.getNumerosConsecutivosBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.SEQUENTIAL_LETTERS_3).setQuantidade(variaveis.getLetraSequencial()).setBonus(variaveis.getLetrasSequeciaisBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.SEQUENTIAL_NUMBERS_3).setQuantidade(variaveis.getNumeroSequencial()).setBonus(variaveis.getNumerosSequenciaisBonus()));
		result.addItens(new MeterResultItem().setDescricao(Constantes.SEQUENTIAL_SYMBOLS_3).setQuantidade(variaveis.getSimboloSequencial()).setBonus(variaveis.getSimbolosSequenciaisBonus()));
		return result;
	}

	private void calcularScoreCaractereRequerido() {
		int[] arrChars = new int[Numeros.CINCO];
		arrChars[Numeros.ZERO] = variaveis.getTamanho();
		arrChars[Numeros.UM] = variaveis.getLetraMaiuscula();
		arrChars[Numeros.DOIS] = variaveis.getLetraMinuscula();
		arrChars[Numeros.TRES] = variaveis.getNumero();
		arrChars[Numeros.QUATRO] = variaveis.getSimbolo();
		
		String[] arrCharsIds = new String[Numeros.CINCO];
		arrCharsIds[Numeros.ZERO] = "nLength";
		arrCharsIds[Numeros.UM] = "nAlphaUC";
		arrCharsIds[Numeros.DOIS] = "nAlphaLC";
		arrCharsIds[Numeros.TRES] = "nNumber";
		arrCharsIds[Numeros.QUATRO] = "nSymbol";
		
		int arrCharsLen = arrChars.length;
		
		for (int c=Numeros.ZERO; c < arrCharsLen; c++) {
			int valorMinimo = ((arrCharsIds[c] == "nLength") ? (Constantes.TAMANHO_MINIMO - Numeros.UM) : Numeros.ZERO);
			if (arrChars[c] == (valorMinimo + Numeros.UM)) {
				variaveis.incrementarCaractereRequerido();
			}
			else if (arrChars[c] > (valorMinimo + Numeros.UM)) {
				variaveis.incrementarCaractereRequerido();
			}
		}
	}

	private void calcularScoreRequerimentos(String senha) {
		variaveis.setRequerimento(variaveis.getCaractereRequerido());
		int nMinReqChars = (senha.length() >= Constantes.TAMANHO_MINIMO) ?  Numeros.TRES : Numeros.QUATRO;
		if (variaveis.getRequerimento() > nMinReqChars) { 
			variaveis.setScore((variaveis.getScore() + (variaveis.getRequerimento() * Numeros.DOIS)));
			variaveis.setRequerimentosBonus(getDescricaoBonusAdicao((variaveis.getRequerimento() * Numeros.DOIS)));
		}
	}

	private void calcularDeducoesScoreSimbolosSequenciais() {
		if (variaveis.getSimboloSequencial() > Numeros.ZERO) {  
			variaveis.setScore((variaveis.getScore() - (variaveis.getSimboloSequencial() * Multiplicadores.SIMBOLOS_SEQUENCIAIS))); 
			variaveis.setSimbolosSequenciaisBonus(getDescricaoBonusSubtracao((variaveis.getSimboloSequencial() * Multiplicadores.SIMBOLOS_SEQUENCIAIS)));
		}
	}

	private void calcularDeducoesScoreNumerosSequenciais() {
		if (variaveis.getNumeroSequencial() > Numeros.ZERO) {  
			variaveis.setScore((variaveis.getScore() - (variaveis.getNumeroSequencial() * Multiplicadores.NUMEROS_SEQUENCIAIS))); 
			variaveis.setNumerosSequenciaisBonus(getDescricaoBonusSubtracao((variaveis.getNumeroSequencial() * Multiplicadores.NUMEROS_SEQUENCIAIS)));
		}
	}

	private void calcularDeducoesScoreLetrasSequenciais() {
		if (variaveis.getLetraSequencial() > Numeros.ZERO) {  
			variaveis.setScore((variaveis.getScore() - (variaveis.getLetraSequencial() * Multiplicadores.LETRAS_SEQUENCIAIS))); 
			variaveis.setLetrasSequeciaisBonus(getDescricaoBonusSubtracao((variaveis.getLetraSequencial() * Multiplicadores.LETRAS_SEQUENCIAIS)));
		}
	}

	private void calcularDeducoesScoreNumerosConsecutivos() {
		if (variaveis.getNumeroConsecutivo() > Numeros.ZERO) {  
			variaveis.setScore((variaveis.getScore() - (variaveis.getNumeroConsecutivo() * Multiplicadores.NUMEROS_CONSECUTIVOS)));  
			variaveis.setNumerosConsecutivosBonus(getDescricaoBonusSubtracao((variaveis.getNumeroConsecutivo() * Multiplicadores.NUMEROS_CONSECUTIVOS)));
		}
	}

	private void calcularDeducoesScoreLetrasMinusculasConsecutivas() {
		if (variaveis.getLetraMinusculasConsecutiva() > Numeros.ZERO) {  
			variaveis.setScore((variaveis.getScore() - (variaveis.getLetraMinusculasConsecutiva() * Multiplicadores.LETRAS_MINUSCULAS_CONSECUTIVAS))); 
			variaveis.setLetrasMinusculasConsecutivasBonus(getDescricaoBonusSubtracao((variaveis.getLetraMinusculasConsecutiva() * Multiplicadores.LETRAS_MINUSCULAS_CONSECUTIVAS)));
		}
	}

	private void calcularDeducoesScoreLetrasMaiusculasConsecutivas() {
		if (variaveis.getLetraMaiusculaConsecutiva() > Numeros.ZERO) {  
			variaveis.setScore((variaveis.getScore() - (variaveis.getLetraMaiusculaConsecutiva() * Multiplicadores.LETRAS_MAIUSCULAS_CONSECUTIVAS))); 
			variaveis.setLetrasMaiusculasConsecutivasBonus(getDescricaoBonusSubtracao((variaveis.getLetraMaiusculaConsecutiva() * Multiplicadores.LETRAS_MAIUSCULAS_CONSECUTIVAS)));
		}
	}

	private void calcularDeducoesScoreCaractereRepetido() {
		if (variaveis.getCaractereRepetido() > Numeros.ZERO) {  
			variaveis.setScore((variaveis.getScore() - variaveis.getRepeticaoIncremental()));
			variaveis.setCaracteresRepetidosBonus(getDescricaoBonusSubtracao(variaveis.getRepeticaoIncremental()));
		}
	}

	private void calcularDeducoesScoreApenasNumeros() {
		if (variaveis.getLetraMinuscula() == Numeros.ZERO && variaveis.getLetraMaiuscula() == Numeros.ZERO && variaveis.getSimbolo() == Numeros.ZERO && variaveis.getNumero() > Numeros.ZERO) {  // Only Numbers
			variaveis.setScore((variaveis.getScore() - variaveis.getTamanho())); 
			variaveis.setApenasNumero(variaveis.getTamanho());
			variaveis.setApenasNumerosBonus(getDescricaoBonusSubtracao(variaveis.getTamanho()));
		}
	}

	private void calcularDeducoesScoreApenasLetras() {
		if ((variaveis.getLetraMinuscula() > Numeros.ZERO || variaveis.getLetraMaiuscula() > Numeros.ZERO) && variaveis.getSimbolo() == Numeros.ZERO && variaveis.getNumero() == Numeros.ZERO) {  
			variaveis.setScore((variaveis.getScore() - variaveis.getTamanho()));
			variaveis.setApenasLetra(variaveis.getTamanho());
			variaveis.setApenasLetrasBonus(getDescricaoBonusSubtracao(variaveis.getTamanho()));
		}
	}

	private void calcularScoreCaractere() {
		if (variaveis.getCaractereAoMeio() > Numeros.ZERO) {	
			variaveis.setScore((variaveis.getScore() + (variaveis.getCaractereAoMeio() * Multiplicadores.CARACTERE_MEIO)));
			variaveis.setCaractereAoMeioBonus(getDescricaoBonusAdicao((variaveis.getCaractereAoMeio() * Multiplicadores.CARACTERE_MEIO)));
		}
	}

	private void calcularScoreSimbolo() {
		if (variaveis.getSimbolo() > Numeros.ZERO) {	
			variaveis.setScore((variaveis.getScore() + (variaveis.getSimbolo() * Multiplicadores.SIMBOLO)));
			variaveis.setSimbolosBonus(getDescricaoBonusAdicao((variaveis.getSimbolo() * Multiplicadores.SIMBOLO)));
		}
	}

	private void calcularScoreNumero() {
		if (variaveis.getNumero() > Numeros.ZERO && variaveis.getNumero() < variaveis.getTamanho()) {	
			variaveis.setScore((variaveis.getScore() + (variaveis.getNumero() * Multiplicadores.NUMERO)));
			variaveis.setNumerosBonus(getDescricaoBonusAdicao((variaveis.getNumero() * Multiplicadores.NUMERO)));
		}
	}

	private void calcularScoreLetraMinuscula() {
		if (variaveis.getLetraMinuscula() > Numeros.ZERO && variaveis.getLetraMinuscula() < variaveis.getTamanho()) {	
			variaveis.setScore((variaveis.getScore() + ((variaveis.getTamanho() - variaveis.getLetraMinuscula()) * Numeros.DOIS)));
			variaveis.setLetrasMinusculasBonus(getDescricaoBonusAdicao(((variaveis.getTamanho() - variaveis.getLetraMinuscula()) * Numeros.DOIS)));
		}
	}

	private void calcularScoreLetraMaiuscula() {
		variaveis.setCaracteresBonus(getDescricaoBonusAdicao(variaveis.getScore()));
		if (variaveis.getLetraMaiuscula() > Numeros.ZERO && variaveis.getLetraMaiuscula() < variaveis.getTamanho()) {	
			variaveis.setScore((variaveis.getScore() + ((variaveis.getTamanho() - variaveis.getLetraMaiuscula()) * Numeros.DOIS)));
			variaveis.setLetrasMaiusculasBonus(getDescricaoBonusAdicao(((variaveis.getTamanho() - variaveis.getLetraMaiuscula()) * Numeros.DOIS)));
		}
	}

	private String getDescricaoBonusAdicao(int valor) {
		return Constantes.ADICAO_SIMBOLO_ESPACO.concat(String.valueOf(valor));
	}
	
	private String getDescricaoBonusSubtracao(int valor) {
		return Constantes.SUBTRACAO_SIMBOLO_ESPACO.concat(String.valueOf(valor));
	}

	private void validarSenhaSimbolosSequenciais(String senha) {
		for (int s = Numeros.ZERO; s < Numeros.OITO; s++) {
			String sFwd = Constantes.SIMBOLOS.substring(s, (s + Numeros.TRES));
			String sRev = new StringBuilder(sFwd).reverse().toString();
			if (senha.toLowerCase().indexOf(sFwd) != Numeros.MENOS_UM || senha.toLowerCase().indexOf(sRev) != Numeros.MENOS_UM) {
				variaveis.incrementarSimboloSequencial();
				variaveis.incrementarCaractereSequecial();
			}
		}
	}

	private void validarSenhaNumerosSequenciais(String senha) {
		for (int s = Numeros.ZERO; s < Numeros.OITO; s++) {
			String sFwd = Constantes.NUMEROS.substring(s, (s + Numeros.TRES));
			String sRev = new StringBuilder(sFwd).reverse().toString();
			if (senha.toLowerCase().indexOf(sFwd) != Numeros.MENOS_UM || senha.toLowerCase().indexOf(sRev) != Numeros.MENOS_UM) {
				variaveis.incrementarNumeroSequencial();
				variaveis.incrementarCaractereSequecial();
			}
		}
	}

	private void validarSenhaLetrasSequenciais(String senha) {
		for (int s = Numeros.ZERO; s < Numeros.VINTE_E_TRES; s++) {
			String sFwd = Constantes.ALFABETO.substring(s, (s + Numeros.TRES));
			String sRev = new StringBuilder(sFwd).reverse().toString();
			if (senha.toLowerCase().indexOf(sFwd) != Numeros.MENOS_UM || senha.toLowerCase().indexOf(sRev) != Numeros.MENOS_UM) {
				variaveis.incrementarLetraSequencial();
				variaveis.incrementarCaractereSequecial();
			}
		}
	}

	private void validarSenhaLetrasNumerosSimbolos() {
		for (int a = Numeros.ZERO; a < variaveis.getPasswordArrayLength(); a++) {
			String letra = variaveis.getPasswordArray()[a];
			if (letra.matches(Regexs.AZ_MAIUSCULO)) {
				validarSenhaLetraMaiuscula(a);
			} else if (letra.matches(Regexs.AZ_MINUSCULO)) {
				validarSenhaLetraMinuscula(a);
			} else if (letra.matches(Regexs.NUMEROS)) {
				validarSenhaNumeros(a);
			} else if (letra.matches(Regexs.CARACTERES)) {
				validarSenhaCaracteres(a);
			}
			validarSenhaCaracteresRepetidos(a);
		}
	}

	private void validarSenhaCaracteresRepetidos(int a) {
		boolean bCharExists = false;
		for (int b=Numeros.ZERO; b < variaveis.getPasswordArrayLength(); b++) {
			if (variaveis.getPasswordArray()[a].equals(variaveis.getPasswordArray()[b]) && a != b) { 
				bCharExists = true;
				variaveis.setRepeticaoIncremental(variaveis.getRepeticaoIncremental()+Math.abs(variaveis.getPasswordArrayLength()/(b-a)));
			}
		}
		if (bCharExists) { 
			variaveis.incrementarCaractereRepetido(); 
			variaveis.setCaractereUnico(variaveis.getPasswordArrayLength()-variaveis.getCaractereRepetido());
			variaveis.setRepeticaoIncremental((int) ((variaveis.getCaractereUnico() > Numeros.ZERO) ? Math.ceil((variaveis.getRepeticaoIncremental()/variaveis.getCaractereUnico()))+Numeros.UM : Math.ceil(variaveis.getRepeticaoIncremental()))); 
		}
	}

	private void validarSenhaCaracteres(int a) {
		if (a > Numeros.ZERO && a < (variaveis.getPasswordArrayLength() - Numeros.UM)) {
			variaveis.incrementarCaractereAoMeio();
		}
		if (variaveis.getSimboloTemporario() != Numeros.MENOS_UM) {
			if ((variaveis.getSimboloTemporario() + Numeros.UM) == a) {
				variaveis.incrementarSimboloConsecutivo();
				variaveis.incrementarTipoCaractereConsecutivo();
			}
		}
		variaveis.setSimboloTemporario(a);
		variaveis.incrementarSimbolo();
	}

	private void validarSenhaNumeros(int a) {
		if (a > Numeros.ZERO && a < (variaveis.getPasswordArrayLength() - Numeros.UM)) {
			variaveis.incrementarCaractereAoMeio();
		}
		if (variaveis.getNumeroTemporario() != Numeros.MENOS_UM) {
			if ((variaveis.getNumeroTemporario() + Numeros.UM) == a) {
				variaveis.incrementarNumeroConsecutivo();
				variaveis.incrementarTipoCaractereConsecutivo();
			}
		}
		variaveis.setNumeroTemporario(a);
		variaveis.incrementarNumero();
	}

	private void validarSenhaLetraMinuscula(int a) {
		if (variaveis.getLetraMinusculaTemporaria() != Numeros.MENOS_UM) {
			if ((variaveis.getLetraMinusculaTemporaria() + Numeros.UM) == a) {
				variaveis.incrementarLetraMinusculasConsecutiva();
				variaveis.incrementarTipoCaractereConsecutivo();
			}
		}
		variaveis.setLetraMinusculaTemporaria(a);
		variaveis.incrementarLetraMinuscula();
	}

	private void validarSenhaLetraMaiuscula(int a) {
		if (variaveis.getLetraMaiusculaTemporaria() != Numeros.MENOS_UM) {
			if ((variaveis.getLetraMaiusculaTemporaria() + Numeros.UM) == a) {
				variaveis.incrementarLetraMaiusculaConsecutiva();
				variaveis.incrementarTipoCaractereConsecutivo();
			}
		}
		variaveis.setLetraMaiusculaTemporaria(a);
		variaveis.incrementarLetraMaiuscula();
	}

	private void determinarComplexidadeSenha() {
		int score = variaveis.getScore();
		if (score > Numeros.CEM) {
			score = Numeros.CEM;
		} else if (score < Numeros.ZERO) {
			score = Numeros.ZERO;
		}
		if (score >= Numeros.ZERO && score < Numeros.VINTE) {
			variaveis.setComplexidade(Constantes.COMPLEXIDADE_SENHA_MUITO_FRACA);
		} else if (score >= Numeros.VINTE && score < Numeros.QUARENTA) {
			variaveis.setComplexidade(Constantes.COMPLEXIDADE_SENHA_FRACA);
		} else if (score >= Numeros.QUARENTA && score < Numeros.SESSENTA) {
			variaveis.setComplexidade(Constantes.COMPLEXIDADE_SENHA_BOA);
		} else if (score >= Numeros.SESSENTA && score < Numeros.OITENTA) {
			variaveis.setComplexidade(Constantes.COMPLEXIDADE_SENHA_FORTE);
		} else if (score >= Numeros.OITENTA && score <= Numeros.CEM) {
			variaveis.setComplexidade(Constantes.COMPLEXIDADE_SENHA_MUITO_FORTE);
		}
		variaveis.setScore(score);
	}
	
	private String[] getArrayCaracteres(String pwd) {
		String[] arrPwd = pwd.replaceAll(Regexs.ESPACO, Constantes.VAZIO).split(Regexs.ALL);
		return arrPwd;
	}
}

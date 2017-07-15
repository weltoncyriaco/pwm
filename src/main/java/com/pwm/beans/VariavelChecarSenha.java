package com.pwm.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.pwm.utils.Constantes;
import com.pwm.utils.Numeros;

@Component
public class VariavelChecarSenha implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int score;
	
	private int tamanho;
	
	private String complexidade;
	
	private int letraMaiuscula;
	
	private int letraMinuscula;
	
	private int numero;
	
	private int simbolo;
	
	private int caractereAoMeio;
	
	private int requerimento;
	
	private int apenasLetra;
	
	private int apenasNumero;
	
	private int caractereUnico;
	
	private int caractereRepetido;
	
	private int repeticaoIncremental;
	
	private int letraMaiusculaConsecutiva;
	
	private int letraMinusculasConsecutiva;
	
	private int numeroConsecutivo;
	
	private int simboloConsecutivo;
	
	private int tipoCaractereConsecutivo;
	
	private int letraSequencial;
	
	private int numeroSequencial;
	
	private int simboloSequencial;
	
	private int caractereSequecial;
	
	private int caractereRequerido;
	
	private int multiplosTiposCaracteresConsecutivo;
	
	private int letraMaiusculaTemporaria;
	
	private int letraMinusculaTemporaria;
	
	private int simboloTemporario;
	
	private int numeroTemporario;
	
	private int passwordArrayLength;
	
	private String[] passwordArray;
	
	private String caracteresBonus;
	
	private String letrasMaiusculasBonus;
	
	private String letrasMinusculasBonus;
	
	private String numerosBonus;
	
	private String simbolosBonus;
	
	private String apenasLetrasBonus;
	
	private String apenasNumerosBonus;
	
	private String caracteresRepetidosBonus;
	
	private String letrasMaiusculasConsecutivasBonus;
	
	private String letrasMinusculasConsecutivasBonus;
	
	private String numerosConsecutivosBonus;
	
	private String letrasSequeciaisBonus;
	
	private String numerosSequenciaisBonus;
	
	private String requerimentosBonus;
	
	private String simbolosSequenciaisBonus;
	
	private String caractereAoMeioBonus;
	
	@PostConstruct
	public void inicializar() {
		this.score = Numeros.ZERO;
		this.complexidade = Constantes.VAZIO;
		this.tamanho = Numeros.ZERO;
		this.letraMaiuscula = Numeros.ZERO;
		this.letraMinuscula = Numeros.ZERO;
		this.numero = Numeros.ZERO;
		this.simbolo = Numeros.ZERO;
		this.caractereAoMeio = Numeros.ZERO;
		this.requerimento = Numeros.ZERO;
		this.apenasLetra = Numeros.ZERO;
		this.apenasNumero = Numeros.ZERO;
		this.caractereUnico = Numeros.ZERO;
		this.caractereRepetido = Numeros.ZERO;
		this.repeticaoIncremental = Numeros.ZERO;
		this.letraMaiusculaConsecutiva = Numeros.ZERO;
		this.letraMinusculasConsecutiva = Numeros.ZERO;
		this.numeroConsecutivo = Numeros.ZERO;
		this.simboloConsecutivo = Numeros.ZERO;
		this.tipoCaractereConsecutivo = Numeros.ZERO;
		this.letraSequencial = Numeros.ZERO;
		this.numeroSequencial = Numeros.ZERO;
		this.simboloSequencial = Numeros.ZERO;
		this.caractereSequecial = Numeros.ZERO;
		this.caractereRequerido = Numeros.ZERO;
		this.multiplosTiposCaracteresConsecutivo = Numeros.ZERO;
		this.letraMaiusculaTemporaria = Numeros.MENOS_UM;
		this.letraMinusculaTemporaria = Numeros.MENOS_UM;
		this.simboloTemporario = Numeros.MENOS_UM;
		this.numeroTemporario = Numeros.MENOS_UM;
		this.passwordArrayLength = Numeros.ZERO;
		this.caracteresBonus = Constantes.VAZIO;
		this.letrasMaiusculasBonus = Constantes.VAZIO;
		this.letrasMinusculasBonus = Constantes.VAZIO;
		this.numerosBonus = Constantes.VAZIO;
		this.simbolosBonus = Constantes.VAZIO;
		this.apenasLetrasBonus = Constantes.VAZIO;
		this.apenasNumerosBonus = Constantes.VAZIO;
		this.caracteresRepetidosBonus = Constantes.VAZIO;
		this.letrasMaiusculasConsecutivasBonus = Constantes.VAZIO;
		this.letrasMinusculasConsecutivasBonus = Constantes.VAZIO;
		this.numerosConsecutivosBonus = Constantes.VAZIO;
		this.letrasSequeciaisBonus = Constantes.VAZIO;
		this.numerosSequenciaisBonus = Constantes.VAZIO;
		this.requerimentosBonus = Constantes.VAZIO;
		this.simbolosSequenciaisBonus = Constantes.VAZIO;
		this.caractereAoMeioBonus = Constantes.VAZIO;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getComplexidade() {
		return complexidade;
	}

	public void setComplexidade(String complexidade) {
		this.complexidade = complexidade;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getLetraMaiuscula() {
		return letraMaiuscula;
	}

	public void setLetraMaiuscula(int letraMaiuscula) {
		this.letraMaiuscula = letraMaiuscula;
	}

	public void incrementarLetraMaiuscula() {
		this.letraMaiuscula++;
	}

	public int getLetraMinuscula() {
		return letraMinuscula;
	}

	public void setLetraMinuscula(int letraMinuscula) {
		this.letraMinuscula = letraMinuscula;
	}
	
	public void incrementarLetraMinuscula() {
		this.letraMinuscula++;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void incrementarNumero() {
		this.numero++;
	}

	public int getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(int simbolo) {
		this.simbolo = simbolo;
	}
	
	public void incrementarSimbolo() {
		this.simbolo++;
	}

	public int getCaractereAoMeio() {
		return caractereAoMeio;
	}

	public void setCaractereAoMeio(int caractereAoMeio) {
		this.caractereAoMeio = caractereAoMeio;
	}
	
	public void incrementaCaractereAoMeio() {
		this.caractereAoMeio++;
	}

	public int getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(int requerimento) {
		this.requerimento = requerimento;
	}

	public int getApenasLetra() {
		return apenasLetra;
	}

	public void setApenasLetra(int apenasLetra) {
		this.apenasLetra = apenasLetra;
	}

	public int getApenasNumero() {
		return apenasNumero;
	}

	public void setApenasNumero(int apenasNumero) {
		this.apenasNumero = apenasNumero;
	}

	public int getCaractereUnico() {
		return caractereUnico;
	}

	public void setCaractereUnico(int caractereUnico) {
		this.caractereUnico = caractereUnico;
	}

	public int getCaractereRepetido() {
		return caractereRepetido;
	}

	public void setCaractereRepetido(int caractereRepetido) {
		this.caractereRepetido = caractereRepetido;
	}
	
	public void incrementarCaractereRepetido() {
		this.caractereRepetido++;
	}

	public int getRepeticaoIncremental() {
		return repeticaoIncremental;
	}

	public void setRepeticaoIncremental(int repeticaoIncremental) {
		this.repeticaoIncremental = repeticaoIncremental;
	}

	public int getLetraMaiusculaConsecutiva() {
		return letraMaiusculaConsecutiva;
	}

	public void setLetraMaiusculaConsecutiva(int letraMaiusculaConsecutiva) {
		this.letraMaiusculaConsecutiva = letraMaiusculaConsecutiva;
	}
	
	public void incrementarLetraMaiusculaConsecutiva() {
		this.letraMaiusculaConsecutiva++;
	}

	public int getLetraMinusculasConsecutiva() {
		return letraMinusculasConsecutiva;
	}

	public void setLetraMinusculasConsecutiva(int letraMinusculasConsecutiva) {
		this.letraMinusculasConsecutiva = letraMinusculasConsecutiva;
	}
	
	public void incrementarLetraMinusculasConsecutiva() {
		this.letraMinusculasConsecutiva++;
	}

	public int getNumeroConsecutivo() {
		return numeroConsecutivo;
	}

	public void setNumeroConsecutivo(int numeroConsecutivo) {
		this.numeroConsecutivo = numeroConsecutivo;
	}
	
	public void incrementarNumeroConsecutivo() {
		this.numeroConsecutivo++;
	}

	public int getSimboloConsecutivo() {
		return simboloConsecutivo;
	}

	public void setSimboloConsecutivo(int simboloConsecutivo) {
		this.simboloConsecutivo = simboloConsecutivo;
	}
	
	public void incrementarSimboloConsecutivo() {
		this.simboloConsecutivo++;
	}

	public int getTipoCaractereConsecutivo() {
		return tipoCaractereConsecutivo;
	}

	public void setTipoCaractereConsecutivo(int tipoCaractereConsecutivo) {
		this.tipoCaractereConsecutivo = tipoCaractereConsecutivo;
	}
	
	public void incrementarTipoCaractereConsecutivo() {
		this.tipoCaractereConsecutivo++;
	}

	public int getLetraSequencial() {
		return letraSequencial;
	}

	public void setLetraSequencial(int letraSequencial) {
		this.letraSequencial = letraSequencial;
	}
	
	public void incrementarLetraSequencial() {
		this.letraSequencial++;
	}

	public int getNumeroSequencial() {
		return numeroSequencial;
	}

	public void setNumeroSequencial(int numeroSequencial) {
		this.numeroSequencial = numeroSequencial;
	}
	
	public void incrementarNumeroSequencial() {
		this.numeroSequencial++;
	}

	public int getSimboloSequencial() {
		return simboloSequencial;
	}

	public void setSimboloSequencial(int simboloSequencial) {
		this.simboloSequencial = simboloSequencial;
	}
	
	public void incrementarSimboloSequencial() {
		this.simboloSequencial++;
	}

	public int getCaractereSequecial() {
		return caractereSequecial;
	}

	public void setCaractereSequecial(int caractereSequecial) {
		this.caractereSequecial = caractereSequecial;
	}
	
	public void incrementarCaractereSequecial() {
		this.caractereSequecial++;
	}

	public int getCaractereRequerido() {
		return caractereRequerido;
	}

	public void setCaractereRequerido(int caractereRequerido) {
		this.caractereRequerido = caractereRequerido;
	}
	
	public void incrementarCaractereRequerido() {
		this.caractereRequerido++;
	}

	public int getMultiplosTiposCaracteresConsecutivo() {
		return multiplosTiposCaracteresConsecutivo;
	}

	public void setMultiplosTiposCaracteresConsecutivo(int multiplosTiposCaracteresConsecutivo) {
		this.multiplosTiposCaracteresConsecutivo = multiplosTiposCaracteresConsecutivo;
	}

	public int getLetraMaiusculaTemporaria() {
		return letraMaiusculaTemporaria;
	}

	public void setLetraMaiusculaTemporaria(int letraMaiusculaTemporaria) {
		this.letraMaiusculaTemporaria = letraMaiusculaTemporaria;
	}

	public int getLetraMinusculaTemporaria() {
		return letraMinusculaTemporaria;
	}

	public void setLetraMinusculaTemporaria(int letraMinusculaTemporaria) {
		this.letraMinusculaTemporaria = letraMinusculaTemporaria;
	}

	public int getSimboloTemporario() {
		return simboloTemporario;
	}

	public void setSimboloTemporario(int simboloTemporario) {
		this.simboloTemporario = simboloTemporario;
	}

	public int getNumeroTemporario() {
		return numeroTemporario;
	}

	public void setNumeroTemporario(int numeroTemporario) {
		this.numeroTemporario = numeroTemporario;
	}

	public int getPasswordArrayLength() {
		return passwordArrayLength;
	}

	public void setPasswordArrayLength(int passwordArrayLength) {
		this.passwordArrayLength = passwordArrayLength;
	}

	public String[] getPasswordArray() {
		return passwordArray;
	}

	public void setPasswordArray(String[] passwordArray) {
		this.passwordArray = passwordArray;
		setPasswordArrayLength(this.passwordArray != null ? this.passwordArray.length : Numeros.ZERO);
	}

	public String getCaracteresBonus() {
		return caracteresBonus;
	}

	public void setCaracteresBonus(String caracteresBonus) {
		this.caracteresBonus = caracteresBonus;
	}

	public String getLetrasMaiusculasBonus() {
		return letrasMaiusculasBonus;
	}

	public void setLetrasMaiusculasBonus(String letrasMaiusculasBonus) {
		this.letrasMaiusculasBonus = letrasMaiusculasBonus;
	}

	public String getLetrasMinusculasBonus() {
		return letrasMinusculasBonus;
	}

	public void setLetrasMinusculasBonus(String letrasMinusculasBonus) {
		this.letrasMinusculasBonus = letrasMinusculasBonus;
	}

	public String getNumerosBonus() {
		return numerosBonus;
	}

	public void setNumerosBonus(String numerosBonus) {
		this.numerosBonus = numerosBonus;
	}

	public String getSimbolosBonus() {
		return simbolosBonus;
	}

	public void setSimbolosBonus(String simbolosBonus) {
		this.simbolosBonus = simbolosBonus;
	}

	public String getApenasLetrasBonus() {
		return apenasLetrasBonus;
	}

	public void setApenasLetrasBonus(String apenasLetrasBonus) {
		this.apenasLetrasBonus = apenasLetrasBonus;
	}

	public String getApenasNumerosBonus() {
		return apenasNumerosBonus;
	}

	public void setApenasNumerosBonus(String apenasNumerosBonus) {
		this.apenasNumerosBonus = apenasNumerosBonus;
	}

	public String getCaracteresRepetidosBonus() {
		return caracteresRepetidosBonus;
	}

	public void setCaracteresRepetidosBonus(String caracteresRepetidosBonus) {
		this.caracteresRepetidosBonus = caracteresRepetidosBonus;
	}

	public String getLetrasMaiusculasConsecutivasBonus() {
		return letrasMaiusculasConsecutivasBonus;
	}

	public void setLetrasMaiusculasConsecutivasBonus(String letrasMaiusculasConsecutivasBonus) {
		this.letrasMaiusculasConsecutivasBonus = letrasMaiusculasConsecutivasBonus;
	}

	public String getLetrasMinusculasConsecutivasBonus() {
		return letrasMinusculasConsecutivasBonus;
	}

	public void setLetrasMinusculasConsecutivasBonus(String letrasMinusculasConsecutivasBonus) {
		this.letrasMinusculasConsecutivasBonus = letrasMinusculasConsecutivasBonus;
	}

	public String getNumerosConsecutivosBonus() {
		return numerosConsecutivosBonus;
	}

	public void setNumerosConsecutivosBonus(String numerosConsecutivosBonus) {
		this.numerosConsecutivosBonus = numerosConsecutivosBonus;
	}

	public String getLetrasSequeciaisBonus() {
		return letrasSequeciaisBonus;
	}

	public void setLetrasSequeciaisBonus(String letrasSequeciaisBonus) {
		this.letrasSequeciaisBonus = letrasSequeciaisBonus;
	}

	public String getNumerosSequenciaisBonus() {
		return numerosSequenciaisBonus;
	}

	public void setNumerosSequenciaisBonus(String numerosSequenciaisBonus) {
		this.numerosSequenciaisBonus = numerosSequenciaisBonus;
	}

	public String getRequerimentosBonus() {
		return requerimentosBonus;
	}

	public void setRequerimentosBonus(String requerimentosBonus) {
		this.requerimentosBonus = requerimentosBonus;
	}

	public String getSimbolosSequenciaisBonus() {
		return simbolosSequenciaisBonus;
	}

	public void setSimbolosSequenciaisBonus(String simbolosSequenciaisBonus) {
		this.simbolosSequenciaisBonus = simbolosSequenciaisBonus;
	}

	public String getCaractereAoMeioBonus() {
		return caractereAoMeioBonus;
	}

	public void setCaractereAoMeioBonus(String caractereAoMeioBonus) {
		this.caractereAoMeioBonus = caractereAoMeioBonus;
	}
}
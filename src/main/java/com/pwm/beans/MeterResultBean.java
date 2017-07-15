package com.pwm.beans;

import java.util.ArrayList;
import java.util.List;

public class MeterResultBean {

	private String resultado;
	
	private int score;
	
	private List<MeterResultItem> itens;

	public MeterResultBean(String resultado, int score) {
		super();
		this.resultado = resultado;
		this.score = score;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<MeterResultItem> getItens() {
		return itens;
	}

	public void setItens(List<MeterResultItem> itens) {
		this.itens = itens;
	}
	
	public MeterResultBean addItens(MeterResultItem item) {
		if (this.itens == null) {
			this.itens = new ArrayList<>();
		}
		this.itens.add(item);
		return this;
	}
}

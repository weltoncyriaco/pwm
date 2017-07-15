package com.pwm.beans;

public class MeterResultItem {

	private String descricao;
	
	private Integer quantidade;
	
	private String bonus;

	
	public MeterResultItem() {
		super();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public MeterResultItem setDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public MeterResultItem setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		return this;
	}

	public String getBonus() {
		return bonus;
	}

	public MeterResultItem setBonus(String bonus) {
		this.bonus = bonus;
		return this;
	}
}

package com.example.apicampeonato.models.enums;

public enum TipoPartidaEnum {

	FASE_DE_GRUPOS(0, "Fase de grupos"), OITAVAS_DE_FINAL(1, "Oitavas de final"),
	QUARTAS_DE_FINAL(2, "Quartas de final"), SEMI_FINAL(3, "Semi final"), FINAL(4, "Final"),
	PONTOS_CORRIDOS(5, "Pontos corridos");

	private int cod;
	private String desc;

	private TipoPartidaEnum(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public static TipoPartidaEnum toEnum(String desc) {

		if (desc == null) {
			return null;
		}

		for (TipoPartidaEnum index : TipoPartidaEnum.values()) {

			if (desc.equals(index.getDesc())) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + desc);
	}

	public static TipoPartidaEnum toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoPartidaEnum index : TipoPartidaEnum.values()) {

			if (cod == index.getCod()) {
				return index;
			}
		}

		throw new IllegalArgumentException("Enum inválido: " + cod);
	}

}

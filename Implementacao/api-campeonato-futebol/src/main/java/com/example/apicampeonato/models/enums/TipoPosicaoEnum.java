package com.example.apicampeonato.models.enums;

public enum TipoPosicaoEnum {
	
	GOLEIRO(0, "Central"),
	ZAGUEIRO(1, "Bandeirinha"),
	LATERAL(2, "Reserva"),
	VOLANTE(3, "Video"),
	MEIO_CAMPISTA(4, "Meio campista"),
	CENTROAVANTE(5, "Centroavante"),
	PONTA_ESQUERDA(6, "Ponta esquerda"),
	PONTA_DIREITA(7, "Ponta direita");
	
	private int cod;
	private String desc;
	
	private TipoPosicaoEnum(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public static TipoPosicaoEnum toEnum(String desc) {
		
		if (desc == null) {
			return null;
		}
		
		for (TipoPosicaoEnum index : TipoPosicaoEnum.values()) {
			
			if (desc.equals(index.getDesc())) {
				return index;
			}
		}
		
		throw new IllegalArgumentException("Enum inválido: " + desc);
	}
	

}

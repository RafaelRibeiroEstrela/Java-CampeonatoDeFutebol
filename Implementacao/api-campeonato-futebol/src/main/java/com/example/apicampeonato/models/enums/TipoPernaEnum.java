package com.example.apicampeonato.models.enums;

public enum TipoPernaEnum {
	
	DIREITA(0, "Direita"),
	ESQUERDA(1, "Esquerda");
	
	private int cod;
	private String desc;
	
	private TipoPernaEnum(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public static TipoPernaEnum toEnum(String desc) {
		
		if (desc == null) {
			return null;
		}
		
		for (TipoPernaEnum index : TipoPernaEnum.values()) {
			
			if (desc.equals(index.getDesc())) {
				return index;
			}
		}
		
		throw new IllegalArgumentException("Enum inválido: " + desc);
	}
	

}

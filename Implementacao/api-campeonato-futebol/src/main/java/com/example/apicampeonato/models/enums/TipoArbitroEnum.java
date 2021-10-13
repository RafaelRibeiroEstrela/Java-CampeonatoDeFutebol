package com.example.apicampeonato.models.enums;

public enum TipoArbitroEnum {
	
	CENTRAL(0, "Central"),
	BANDEIRINHA(1, "Bandeirinha"),
	RESERVA(2, "Reserva"),
	VIDEO(3, "Video");
	
	private int cod;
	private String desc;
	
	private TipoArbitroEnum(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public static TipoArbitroEnum toEnum(String desc) {
		
		if (desc == null) {
			return null;
		}
		
		for (TipoArbitroEnum index : TipoArbitroEnum.values()) {
			
			if (desc.equals(index.getDesc())) {
				return index;
			}
		}
		
		throw new IllegalArgumentException("Enum inválido: " + desc);
	}
	

}

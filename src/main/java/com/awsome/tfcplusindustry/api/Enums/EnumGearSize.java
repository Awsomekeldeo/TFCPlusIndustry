package com.awsome.tfcplusindustry.api.Enums;

public enum EnumGearSize {
	SMALL("Small"),
	MEDIUM("Medium"),
	LARGE("Large");
	
	private final String size;
	
	private static final EnumGearSize SIZES[] = new EnumGearSize[] {
			SMALL, MEDIUM, LARGE
	};
	
	private EnumGearSize(String s) {
		size = s;
	}
	
	public String getSize() {
		return size;
	}
}
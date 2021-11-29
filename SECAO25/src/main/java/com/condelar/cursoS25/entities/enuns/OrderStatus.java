package com.condelar.cursoS25.entities.enuns;

public enum OrderStatus {
	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCALED(5);

	private int code;

	OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code");
	}

}
package edu.fudan.mylang.pf.query;

public class OrderItem {
	public static int ASC = 1;
	public static int DESC = 2;
	private String column;
	private int order;

	public OrderItem() {

	}

	public OrderItem(String column, int order) {
		super();
		this.column = column;
		this.order = order;
	}

	public String getPropertyName() {
		return column;
	}

	public int getOrder() {
		return order;
	}

	@Override
	public String toString() {

		return column + (order == ASC ? " ASC" : " DESC");
	}

}

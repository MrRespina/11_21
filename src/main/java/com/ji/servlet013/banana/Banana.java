package com.ji.servlet013.banana;

public class Banana {
	
	private int b_num;
	private String b_trademark;
	private String b_location;
	private int b_bundle;
	private String b_color;
	private String b_flavor;
	private int b_price;
	private String b_introduce;
	
	public Banana() {
		// TODO Auto-generated constructor stub
	}

	public Banana(int b_num, String b_trademark, String b_location, int b_bundle, String b_color, String b_flavor,
			int b_price, String b_introduce) {
		super();
		this.b_num = b_num;
		this.b_trademark = b_trademark;
		this.b_location = b_location;
		this.b_bundle = b_bundle;
		this.b_color = b_color;
		this.b_flavor = b_flavor;
		this.b_price = b_price;
		this.b_introduce = b_introduce;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getB_trademark() {
		return b_trademark;
	}

	public void setB_trademark(String b_trademark) {
		this.b_trademark = b_trademark;
	}

	public String getB_location() {
		return b_location;
	}

	public void setB_location(String b_location) {
		this.b_location = b_location;
	}

	public int getB_bundle() {
		return b_bundle;
	}

	public void setB_bundle(int b_bundle) {
		this.b_bundle = b_bundle;
	}

	public String getB_color() {
		return b_color;
	}

	public void setB_color(String b_color) {
		this.b_color = b_color;
	}

	public String getB_flavor() {
		return b_flavor;
	}

	public void setB_flavor(String b_flavor) {
		this.b_flavor = b_flavor;
	}

	public int getB_price() {
		return b_price;
	}

	public void setB_price(int b_price) {
		this.b_price = b_price;
	}

	public String getB_introduce() {
		return b_introduce;
	}

	public void setB_introduce(String b_introduce) {
		this.b_introduce = b_introduce;
	}
	
	

}

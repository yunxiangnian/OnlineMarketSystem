package com.yunxiangnian.bean;

import java.io.Serializable;

public class Clothes implements Serializable{
	private String id;//商品编号
	private String brand;//品牌
	private String style;//款式
	private String color;//颜色
	private String size;//尺码
	private int num;//数量
	private float price;//单价
	private String description;//描述
	@Override
	public String toString() {
		return "Clothes [id=" + id + ", brand=" + brand + ", style=" + style + ", color=" + color + ", size=" + size
				+ ", num=" + num + ", price=" + price + ", description=" + description + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

package com.yunxiangnian.bean;

import java.io.Serializable;

public class OrderDetails implements Serializable{
		private int itemid;//购买的商品id
		private Clothes clothes;//购买的商品
		private int shoppingNum;//购买的商品数量
		private float num;//这次购买的金额
		public int getItemid() {
			return itemid;
		}
		public void setItemid(int itemid) {
			this.itemid = itemid;
		}
		public Clothes getClothes() {
			return clothes;
		}
		public void setClothes(Clothes clothes) {
			this.clothes = clothes;
		}
		public int getShoppingNum() {
			return shoppingNum;
		}
		public void setShoppingNum(int shoppingNum) {
			this.shoppingNum = shoppingNum;
		}
		public float getNum() {
			return num;
		}
		public void setNum(float num) {
			this.num = num;
		}
		public OrderDetails() {
			super();
		}
}

package com.yunxiangnian.bean;

import java.io.Serializable;

public class OrderDetails implements Serializable{
		private int itemid;//�������Ʒid
		private Clothes clothes;//�������Ʒ
		private int shoppingNum;//�������Ʒ����
		private float num;//��ι���Ľ��
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

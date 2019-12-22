package com.yunxiangnian.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utils.OrderStatusType;

public class Order implements Serializable{
		private int orderId;
		private List<OrderDetails> list=new ArrayList<>();
		private String createDate;
		private float num;//×Ü½ð¶î
		private OrderStatusType status=OrderStatusType.UNPAID;//¶©µ¥×´Ì¬
		private int userId;
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public List<OrderDetails> getList() {
			return list;
		}
		public void setList(List<OrderDetails> list) {
			this.list = list;
		}
		public String getCreateDate() {
			return createDate;
		}
		public void setCreateDate(String createDate) {
			this.createDate = createDate;
		}
		public float getNum() {
			return num;
		}
		public void setNum(float num) {
			this.num = num;
		}
		public OrderStatusType getStatus() {
			return status;
		}
		public void setStatus(OrderStatusType status) {
			this.status = status;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
}

package service;

import java.util.List;

import com.yunxiangnian.bean.Order;

import utils.BusinessException;

public interface OrderService {
	public void buyProducts(Order o)throws BusinessException;
	public List<Order> findlist()throws BusinessException;
	public Order findByOrderId(int orderId)throws BusinessException;
}

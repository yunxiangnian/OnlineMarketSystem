package service;

import java.util.List;

import com.yunxiangnian.bean.Order;

import utils.BusinessException;
import utils.OrderIO;

public class OrderServiceImpl implements OrderService{
	private OrderIO orderio=new OrderIO();
	@Override
	public void buyProducts(Order o) throws BusinessException {
		orderio.add(o);
	}

	@Override
	public List<Order> findlist() throws BusinessException {
		return orderio.list();
	}

	@Override
	public Order findByOrderId(int orderId) throws BusinessException {
		return orderio.findByOrderId(orderId);
	}

}

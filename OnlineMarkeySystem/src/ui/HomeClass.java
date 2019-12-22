package ui;

import java.util.Date;
import java.util.List;

import com.yunxiangnian.bean.Clothes;
import com.yunxiangnian.bean.Order;
import com.yunxiangnian.bean.OrderDetails;

import service.ClothesService;
import service.ClothesServiceImpl;
import service.OrderService;
import service.OrderServiceImpl;
import utils.BusinessException;
import utils.ConsoleTable;
import utils.DateUtils;
import utils.OrderIO;

public class HomeClass extends BaseClass {
	private OrderService orderService = new OrderServiceImpl();
	private OrderIO orderIo = new OrderIO();
//	private OrderService orderService;
//	private ClothesService clothesService;
	private ClothesService clothesService = new ClothesServiceImpl();
//	public HomeClass(){
//		orderService=(OrderService)beanFactory.getBean("OrderService");
//		clothesService=(ClothesService)beanFactory.getBean("ClothesService");
//	}
	public void show() {
		showProducts();
		System.out.println("welcome:" + currUser.getName());
		menu();
	}

	private void menu() {
		boolean flag = true;
		while (flag) {
			println(getString("home.function"));
			println(getString("info.select"));
			String select = input.nextLine();
			switch (select) {
			case "1":// 1查询全部订单
				findList();
				flag = false;
				break;
			case "2":// 2查找对应ID订单
				findOrderById();
				flag = false;
				break;
			case "3":// 3购买
				try {
					buyProduct();
					flag = false;
				} catch (BusinessException e) {
					println(e.getMessage());
				}
				break;
			case "4":// 显示商品
				show();
				break;
			case "0":
				flag = false;
				println(getString("info.exit"));
				System.exit(0);
				break;
			default:
				println(getString("input.error"));
				break;
			}
		}
	}

	private void buyProduct() throws BusinessException {
		//
		boolean flag = true;
		int count = 1;
		float sum = 0.0f;
		Order order = new Order();//生成的订单
		while (flag) {
			println(getString("product.input.id"));
			String id = input.nextLine();
			println(getString("product.input.shoppingNum"));
			String shoppingNum = input.nextLine();
			OrderDetails orderdetails = new OrderDetails();
			Clothes clothes = clothesService.findById(id);
			int num = Integer.parseInt(shoppingNum);
			if (num > clothes.getNum()) {
				throw new BusinessException("product.num.error");
			}
			//
			clothes.setNum(clothes.getNum() - num);
			orderdetails.setClothes(clothes);
			orderdetails.setShoppingNum(num);
			orderdetails.setNum(clothes.getPrice() * num);
			sum +=orderdetails.getNum();
			orderdetails.setItemid(count++);
			order.getList().add(orderdetails);

			println(getString("product.buy.continue"));
			String isbuy = input.nextLine();
			switch (isbuy) {
			case "1":
				flag = true;
				break;
			case "2":
				flag = false;
				break;
			default:
				break;
			}
		}
		order.setCreateDate(DateUtils.toDate(new Date()));
		order.setUserId(currUser.getId());
		order.setNum(sum);
		order.setOrderId(orderService.findlist().size() + 1);
		orderService.buyProducts(order);
		clothesService.updateXml();
		show();
	}

	private void findOrderById() {
		println(getString("product.input.oid"));
		String oid=input.nextLine();
		Order order=orderService.findByOrderId(Integer.parseInt(oid));
		if(order!=null){
			showOrder(order);
		}else{
			println(getString("product.order.error"));
		}
		menu();
	}

	private void findList() {
		List<Order> list = orderService.findlist();
		for (Order o : list) {
			showOrder(o);
		}
		menu();
	}

	private void showOrder(Order o) {
		print(getString("product.order.oid") + o.getOrderId());
		print("\t" + getString("product.order.createDate") + o.getCreateDate());
		println("\t" + getString("product.order.sum") + o.getNum());
		ConsoleTable t = new ConsoleTable(9, true);
		t.appendRow();
		t.appendColum("itemid").appendColum("brand").appendColum("style").appendColum("color").appendColum("size")
				.appendColum("price").appendColum("description").appendColum("shoppingNum").appendColum("sum");

		for (OrderDetails item : o.getList()) {
			t.appendRow();
			t.appendColum(o.getOrderId()).appendColum(item.getClothes().getBrand())
					.appendColum(item.getClothes().getStyle()).appendColum(item.getClothes().getColor())
					.appendColum(item.getClothes().getSize())
					.appendColum(item.getClothes().getPrice()).appendColum(item.getClothes().getDescription())
					.appendColum(item.getShoppingNum()).appendColum(item.getNum());
		}
		println(t.toString());
	}

	private void showProducts() {
		List<Clothes> list = clothesService.list();
		ConsoleTable t = new ConsoleTable(8, true);
		t.appendRow();
		t.appendColum("id").appendColum("brand").appendColum("style").appendColum("color").appendColum("size")
				.appendColum("num").appendColum("price").appendColum("description");
		// System.out.println(t.toString());
		for (Clothes c : list) {
			t.appendRow();
			t.appendColum(c.getId()).appendColum(c.getBrand()).appendColum(c.getStyle()).appendColum(c.getColor())
					.appendColum(c.getSize()).appendColum(c.getNum()).appendColum(c.getPrice())
					.appendColum(c.getDescription());
		}
		println(t.toString());
	}
}

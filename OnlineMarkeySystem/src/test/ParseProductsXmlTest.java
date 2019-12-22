package test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.yunxiangnian.bean.Clothes;

import utils.ProductsXmlUtils;

public class ParseProductsXmlTest {

	@Test
	public void test(){
		List<Clothes> products=ProductsXmlUtils.parserProductFromXml();
		System.out.println(Arrays.toString(products.toArray()));
	}
}

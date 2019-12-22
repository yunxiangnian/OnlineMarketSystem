package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.yunxiangnian.bean.Clothes;

public class ProductsXmlUtils {
	public static List<Clothes> parserProductFromXml(){
		List<Clothes> products=new ArrayList<>();
		XStream xStream=new XStream(new XppDriver());
		Clothes clothes=new Clothes();
//		xStream.processAnnotations(Clothes.class);
		xStream.setClassLoader(clothes.getClass().getClassLoader());
		xStream.alias("list", products.getClass());
		xStream.alias("clothes", Clothes.class);
		xStream.useAttributeFor(Clothes.class, "id");
		
		try{
			BufferedInputStream in=new BufferedInputStream(new FileInputStream("Products.xml"));
			products=(List<Clothes>)xStream.fromXML(in);
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return products;
	}
	
	public static void writeProductsToXml(List<Clothes> products){
		XStream xStream=new XStream(new XppDriver());
		xStream.alias("list", products.getClass());
		xStream.alias("clothes", Clothes.class);
		xStream.useAttributeFor(Clothes.class, "id");
		try{
			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("Products.xml"));
			out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes());
			xStream.toXML(products,out);
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

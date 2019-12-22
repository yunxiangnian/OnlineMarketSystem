package framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	private Iterator<Element> iterator = null;

	public static BeanFactory beanFactory = null;

	private BeanFactory(String xml) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(xml);
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(is);
			org.dom4j.Element rootElement = document.getRootElement();
			iterator = rootElement.elementIterator();
			is.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BeanFactory init() {
		if (beanFactory == null) {
			synchronized (BeanFactory.class) {
				if (beanFactory == null) {
					beanFactory = new BeanFactory("bean.xml");
				}
			}
		}
		return beanFactory;
	}

	public Object getBean(String id) {
		while (iterator.hasNext()) {
			Element bean = iterator.next();
			String sid = bean.attributeValue("id");
			if (sid.equals(id)) {
				String ClassName = bean.attributeValue("class");
				try {
					return Class.forName(ClassName).newInstance();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}

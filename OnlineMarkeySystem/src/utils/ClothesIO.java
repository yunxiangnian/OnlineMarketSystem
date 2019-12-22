package utils;

import java.util.ArrayList;
import java.util.List;

import com.yunxiangnian.bean.Clothes;

public class ClothesIO {
	private static  List<Clothes>  list=new ArrayList<>();
	
	public Clothes findById(String cid)throws BusinessException{
		for(Clothes c:list){
			if(c.getId().equals(cid)){
				return c;
			}
		}
		return null;
	}
	public List<Clothes> list() throws BusinessException{
		if(list.size()==0){
			list=ProductsXmlUtils.parserProductFromXml();
		}
		return list;
	}
	
	public void updateXml() throws BusinessException{
		ProductsXmlUtils.writeProductsToXml(list);
	}
	
}

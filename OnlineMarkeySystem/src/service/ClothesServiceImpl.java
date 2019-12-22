package service;

import java.util.List;

import com.yunxiangnian.bean.Clothes;

import utils.BusinessException;
import utils.ClothesIO;
import utils.ProductsXmlUtils;

public class ClothesServiceImpl implements ClothesService{
	private ClothesIO clothesIO=new ClothesIO();
	@Override
	public List<Clothes> list() throws BusinessException {
		return clothesIO.list();
	}

	@Override
	public Clothes findById(String cid) throws BusinessException {
		return clothesIO.findById(cid);
	}
	public void updateXml() throws BusinessException{
		clothesIO.updateXml(); 
	}
}

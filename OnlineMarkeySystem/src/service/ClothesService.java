package service;

import java.util.List;

import com.yunxiangnian.bean.Clothes;

import utils.BusinessException;

public interface ClothesService {
	public List<Clothes> list() throws BusinessException;
	public Clothes findById(String cid)throws BusinessException;
	public void updateXml() throws BusinessException;
}

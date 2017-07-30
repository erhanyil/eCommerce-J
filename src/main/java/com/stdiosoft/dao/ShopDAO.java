package com.stdiosoft.dao;

import com.stdiosoft.model.Shop;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ShopDAO {
	@Autowired
	@Qualifier(value="sessionFactory")
	private SessionFactory sessionFactory;

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Shop> getShopList() {
		Session sf = getSession();
		List<Shop> listShop = (List<Shop>) sf
				.createCriteria(Shop.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listShop;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public void newShop(Shop _shop) {
		Session sf = getSession();
		Shop newShop = new Shop();
		newShop.setShopAdress(_shop.getShopAdress());
		newShop.setShopName(_shop.getShopName());
		newShop.setShopPhone(_shop.getShopPhone());
		sf.save(newShop);
		sf.flush();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public void deleteShop(Shop _shop) {
		Session sf = getSession();
		sf.delete(_shop);
		sf.flush();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public void editShop(Shop _shop) {
		Session sf = getSession();
		Shop newShop = new Shop();
		newShop.setId(_shop.getId());
		newShop.setShopName(_shop.getShopName());
		newShop.setShopAdress(_shop.getShopAdress());
		newShop.setShopPhone(_shop.getShopPhone());
		sf.saveOrUpdate(newShop);
		sf.flush();
	}



	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public void closeSession(Session _session){
		_session.clear();
		_session.close();
	}
}
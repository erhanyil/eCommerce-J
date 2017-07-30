package com.stdiosoft.model;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {

	@Id
	@GeneratedValue
	@Column(name = "shop_id")
	private int id;

	@Column(name = "shop_name")
	private String shopName;

	@Column(name = "shop_adress")
	private String shopAdress;

	@Column(name = "shop_phone")
	private String shopPhone;


	public int getId() {
		return id;
	}

	public void setId(int _id) {
		id = _id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String _shopName) {
		shopName = _shopName;
	}

	public String getShopAdress() {
		return shopAdress;
	}

	public void setShopAdress(String _shopAdress) {
		shopAdress = _shopAdress;
	}

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String _shopPhone) {
		shopPhone = _shopPhone;
	}

}

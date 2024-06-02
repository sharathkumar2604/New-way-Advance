package com.sharath.jpaproject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cooldrinksdto")
@NamedQuery(name ="readAll",query="select r from CoolDrinksDto r")

@NamedQuery(name ="readById",query="select r from CoolDrinksDto r where r.id=:id")

@NamedQuery(name="readByBrand",query ="select r from CoolDrinksDto r where r.brand=:brand")

@NamedQuery(name = "updatePriceByName", query = "UPDATE CoolDrinksDto co SET co.price = :price WHERE co.brand = :brand")

@NamedQuery(name = "deleteByNamePriceAndQty", query = "delete from CoolDrinksDto co where co.brand = :brand and co.price=:price and co.qty=:qty")
public class CoolDrinksDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String brand;

	private String qty;

	private String flovor;

	private int price;

	public CoolDrinksDto() {
	}

	public CoolDrinksDto(String brand, String qty, String flovor, int price) {
		this.brand = brand;
		this.qty = qty;
		this.flovor = flovor;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getFlovor() {
		return flovor;
	}

	public void setFlovor(String flovor) {
		this.flovor = flovor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CoolDrinksDto [id=" + id + ", brand=" + brand + ", qty=" + qty + ", flovor=" + flovor + ", price="
				+ price + "]";
	}

}

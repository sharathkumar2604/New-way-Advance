package com.sharath.jpaproject.service;

import java.util.List;

import com.sharath.jpaproject.Repo.CoolDrinksRepo;
import com.sharath.jpaproject.Repo.CoolDrinksRepoImpl;
import com.sharath.jpaproject.dto.CoolDrinksDto;

public class CoolDrinksServiceImpl implements CoolDrinksService {

	
	CoolDrinksRepo repo = new CoolDrinksRepoImpl();
	@Override
	public boolean saveAll(CoolDrinksDto... dtos) {

		return repo.saveAll(dtos);
	}
	@Override
	public List<CoolDrinksDto> readAll() {
		// TODO Auto-generated method stub
		return repo.readAll();
	}
	@Override
	public CoolDrinksDto readById(int id) {
		// TODO Auto-generated method stub
		return repo.readById(id);
	}
	@Override
	public List<CoolDrinksDto> readByBrand(String ... name) {
		return repo.readByBrand(name);
	}
	@Override
	public String updatePriceByName(int price, String name) {
		// TODO Auto-generated method stub
		return repo.updatePriceByName(price,name);
	}
	@Override
	public String deleteByNamePriceAndQty(String name, int price, String qty) {
		// TODO Auto-generated method stub
		return repo.deleteByNamePriceAndQty(name,price,qty);
	}
	

}

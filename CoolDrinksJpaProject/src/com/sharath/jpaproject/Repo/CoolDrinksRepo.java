package com.sharath.jpaproject.Repo;

import java.util.List;

import com.sharath.jpaproject.dto.CoolDrinksDto;

public interface CoolDrinksRepo {

	public boolean saveAll(CoolDrinksDto[] dtos);

	public List<CoolDrinksDto> readAll();

	public CoolDrinksDto readById(int id);

	public List<CoolDrinksDto> readByBrand(String ... name);

	public String updatePriceByName(int price, String name);

	public String deleteByNamePriceAndQty(String name, int price, String qty);

	

}

package com.sharath.jpaproject.runner;

import com.sharath.jpaproject.dto.CoolDrinksDto;
import com.sharath.jpaproject.service.CoolDrinksService;
import com.sharath.jpaproject.service.CoolDrinksServiceImpl;

public class CoolDrinksRunner {
	
	
	public static void main(String[] args) {
	
		CoolDrinksService service = new CoolDrinksServiceImpl();
		
		
		CoolDrinksDto d1 = new CoolDrinksDto("Sprite","500ml","Soda",32);
		CoolDrinksDto d2 = new CoolDrinksDto("MountainDew","1000ml","Soda",62);
		CoolDrinksDto d3 = new CoolDrinksDto("Bindhu","500ml","Jeera-Soda",32);
		CoolDrinksDto d4 = new CoolDrinksDto("Coke","1000ml","Cockine-Soda",42);
		CoolDrinksDto d5 = new CoolDrinksDto("Mirinda","250ml","Orange-Soda",22);
		
//	service.saveAll(d1,d2,d3,d4,d5);	

		

//		   for(CoolDrinksDto dd :service.readAll())
//		   {
//			   System.out.println(dd);
//		   }
		
//		System.out.println(service.readById(3));
		

//		System.out.println(service.readByBrand("Coke","Bindhu"));
		
//		service.updatePriceByName(108,"coke");

		
		service.deleteByNamePriceAndQty("Mirinda",22, "250ml");
	}

}

package com.sharath.jpaproject.Repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sharath.jpaproject.dto.CoolDrinksDto;

public class CoolDrinksRepoImpl implements CoolDrinksRepo {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("CoolDrinks");
	EntityManager em = emf.createEntityManager();

	@Override
	public boolean saveAll(CoolDrinksDto[] dtos) {

		em.getTransaction().begin();
		if (em != null) {
			for (CoolDrinksDto d : dtos) {
				em.persist(d);
			}
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Override
	public List<CoolDrinksDto> readAll() {

		em.getTransaction().begin();
		Query query = em.createNamedQuery("readAll", CoolDrinksDto.class);
		em.getTransaction().commit();
		return query.getResultList();
	}

	@Override
	public CoolDrinksDto readById(int id) {
//		em.getTransaction().begin();
		Query query = em.createNamedQuery("readById", CoolDrinksDto.class);
		query.setParameter("id", id);
//	    em.getTransaction().commit();
		return (CoolDrinksDto) query.getSingleResult();
	}

	@Override
	public List<CoolDrinksDto> readByBrand(String... names) {

		Query query = em.createNamedQuery("readByBrand", CoolDrinksDto.class);
		List<CoolDrinksDto> resultList = new ArrayList<>();

		for (String name : names) {
			CoolDrinksDto d = (CoolDrinksDto) query.setParameter("brand", name).getSingleResult();
//	        List<CoolDrinksDto> drinksList = query.setParameter("brand", name).getResultList();
//	        resultList.addAll(drinksList);
			resultList.add(d);
		}

		return resultList;
	}

	@Override
	public String updatePriceByName(int price, String name) {
		em.getTransaction().begin();
		Query query = em.createNamedQuery("updatePriceByName");
		query.setParameter("price", price);
		query.setParameter("brand", name);
		query.executeUpdate();
		em.getTransaction().commit();
		return "updated successfully";
	}
// or update like this
	// public String updatePriceByName(int price, String name) {
//	    try {
//	        em.getTransaction().begin();
//	        Query query = em.createNamedQuery("updatePriceByName");
//	        query.setParameter("newPrice", price);
//	        query.setParameter("brand", name);
//	        int updatedRows = query.executeUpdate();
//	        em.getTransaction().commit();
//	        return updatedRows + " records updated successfully";
//	    } catch (Exception e) {
//	        if (em.getTransaction().isActive()) {
//	            em.getTransaction().rollback();
//	        }
//	        e.printStackTrace();
//	        return "Error updating price for brand: " + name;
//	    }
//	}
//

	@Override
	public String deleteByNamePriceAndQty(String name, int price, String qty) {

		em.getTransaction().begin();
		Query query = em.createNamedQuery("deleteByNamePriceAndQty");
		query.setParameter("brand", name);
		query.setParameter("price", price);
		query.setParameter("qty", qty);
		int executeUpdate = query.executeUpdate();
		em.getTransaction().commit();
		return executeUpdate +"deleted successful";

	}

}

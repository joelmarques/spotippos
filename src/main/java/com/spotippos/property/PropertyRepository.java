package com.spotippos.property;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.spotippos.exception.BussinessException;
import com.spotippos.response.Response;
import com.spotippos.validatable.Validatable;

@Stateless
public class PropertyRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Property find(Long id) {
		return this.entityManager.find(Property.class, id);
	}
	
	public Response persist(Property property) {
		
		try {
			Validatable validator = new PropertyValidator(property);
			validator.validate();
			this.entityManager.persist(property);
			return Response.SUCCESS();
		} catch (BussinessException e) {
			return Response.ERROR(e.getMessage());
		}
	}
	
}
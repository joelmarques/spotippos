package com.spotippos.property;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	public Properties find(Integer ax, Integer ay, Integer bx, Integer by) {
		
		int Xmin = ax < bx ? ax : bx;
		int Xmax = ax > bx ? ax : bx;
		int Ymin = ay < by ? ay : by;
		int Ymax = ay > by ? ay : by;
		
		StringBuilder JPQL = new StringBuilder("select p from Property p");
		JPQL.append(" where p.x between "+Xmin+" and "+Xmax);
		JPQL.append(" and p.y between "+Ymin+" and "+Ymax);
		
		Query query = entityManager.createQuery(JPQL.toString(), Property.class);
		
		List<Property> properties = query.getResultList();
		
		return new Properties(properties);
	}
	
}
package org.grade.core.persistence.filter;

import org.springframework.data.jpa.domain.Specification;

public interface Filter<E> {

	public boolean isPageable();
	
	public void reset();
	
	public Specification<E> getSpecifications();
	
}

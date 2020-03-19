package org.grade.core.persistence.service;

import org.grade.core.persistence.filter.AbstractFilter;

public interface Service<E, F extends AbstractFilter<E>, T> {

	public E findById(Long id);
	
	public T findAll(F filter);
	
	public E create(E entity);
	
	public E update(E entity);
	
	public void deleteById(Long id);
	
}

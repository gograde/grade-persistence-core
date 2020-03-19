package org.grade.core.persistence.service;

import org.grade.core.persistence.AbstractEntity;
import org.grade.core.persistence.JpaTopadRepository;
import org.grade.core.persistence.filter.AbstractPageableFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.lang.NonNull;

import fr.gouv.impots.appli.topad.core.exception.NotFoundException;

public class GenericPageableService<E extends AbstractEntity, F extends AbstractPageableFilter<E>, R extends JpaTopadRepository<E, Long>>
		implements Service<E, F, Page<E>> {

	@Autowired
	private R repository;

	@Override
	public E findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Entity with Id %d was not found", id));
	}

	@Override
	public Page<E> findAll(@NonNull F filter) {
		return repository.findAll(filter.getSpecifications(), filter.getPageRequest());
	}

	@Override
	public E create(@NonNull E entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public E update(@NonNull E entity) {
		findById(entity.getId()); // Check if entity exists
		return repository.saveAndFlush(entity);
	}

	@Override
	public void deleteById(Long id) {
		findById(id); // Check if entity exists
		repository.deleteById(id);
	}

}

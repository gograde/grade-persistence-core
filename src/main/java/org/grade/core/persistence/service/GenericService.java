package org.grade.core.persistence.service;

import java.util.List;

import org.grade.core.persistence.AbstractEntity;
import org.grade.core.persistence.JpaTopadRepository;
import org.grade.core.persistence.filter.AbstractFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import fr.gouv.impots.appli.topad.core.exception.NotFoundException;

public class GenericService<E extends AbstractEntity, F extends AbstractFilter<E>, R extends JpaTopadRepository<E, Long>>
		implements Service<E, F, List<E>> {

	@Autowired
	private R repository;

	@Override
	public E findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Entity with Id %d was not found", id));
	}

	@Override
	public List<E> findAll(F filter) {
		if (filter == null) {
			return repository.findAll();
		}
		return repository.findAll(filter.getSpecifications());
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

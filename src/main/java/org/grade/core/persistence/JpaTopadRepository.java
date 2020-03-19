package org.grade.core.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import fr.gouv.impots.appli.topad.core.exception.DataCountException;

public interface JpaTopadRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {


	public default List<T> findAllThrowIfCountGreaterThan(Specification<T> specifications, long count) {
		return findAllThrowIfCountGreaterThan(specifications, count, false);
	}
	
	public default List<T> findAllThrowIfCountGreaterThan(Specification<T> specifications, long count, boolean orEqual) {
		long counted = count(specifications);
		if(orEqual) {
			if(counted >= count) {
				throw new DataCountException("Call expected to return not greater than or equal to %d elements", count);
			}
		}else {
			if(counted > count) {
				throw new DataCountException("Call expected to return not greater than %d elements", count);
			}
		}
		return findAll(specifications);
	}
	
	public default List<T> findAllThrowIfCountLessThan(Specification<T> specifications, long count){
		return findAllThrowIfCountLessThan(specifications, count, false);
	}
	
	public default List<T> findAllThrowIfCountLessThan(Specification<T> specifications, long count, boolean orEqual){
		long counted = count(specifications);
		if(orEqual) {
			if(counted <= count) {
				throw new DataCountException("Call expected to return not less than or equal to %d elements", count);
			}
		}else {
			if(counted < count) {
				throw new DataCountException("Call expected to return not less than %d elements", count);
			}
		}
		return findAll(specifications);
	}
	
	public default Page<T> findAllThrowIfCountGreaterThan(Specification<T> specifications, PageRequest pageRequest, long count) {
		return findAllThrowIfCountGreaterThan(specifications, pageRequest, count, false);
	}
	
	public default Page<T> findAllThrowIfCountGreaterThan(Specification<T> specifications, PageRequest pageRequest, long count, boolean orEqual) {
		long counted = count(specifications);
		if(orEqual) {
			if(counted >= count) {
				throw new DataCountException("Call expected to return not greater than or equal to %d elements", count);
			}
		}else {
			if(counted > count) {
				throw new DataCountException("Call expected to return not greater than %d elements", count);
			}
		}
		return findAll(specifications, pageRequest);
	}
	
	public default Page<T> findAllThrowIfCountLessThan(Specification<T> specifications, PageRequest pageRequest, long count){
		return findAllThrowIfCountLessThan(specifications, pageRequest, count, false);
	}
	
	public default Page<T> findAllThrowIfCountLessThan(Specification<T> specifications, PageRequest pageRequest, long count, boolean orEqual){
		long counted = count(specifications);
		if(orEqual) {
			if(counted <= count) {
				throw new DataCountException("Call expected to return not less than or equal to %d elements", count);
			}
		}else {
			if(counted < count) {
				throw new DataCountException("Call expected to return not less than %d elements", count);
			}
		}
		return findAll(specifications, pageRequest);
	}

}

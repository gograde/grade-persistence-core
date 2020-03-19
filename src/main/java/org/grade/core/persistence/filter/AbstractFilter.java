package org.grade.core.persistence.filter;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractFilter<E> implements Filter<E> {

	protected static final String LIKE = "%";
	protected Sort sort;
	
	public Sort getSort() {
		if(sort == null) {
			return Sort.by(new Order(Direction.ASC,"id"));
		}
		return sort;
	}
}

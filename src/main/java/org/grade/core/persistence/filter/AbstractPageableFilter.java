package org.grade.core.persistence.filter;

import org.springframework.data.domain.PageRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractPageableFilter<E> extends AbstractFilter<E> {

	private Integer pageSize = 10;
	private Integer pageNumber = 0;

	public PageRequest getPageRequest() {
		return PageRequest.of(pageNumber, pageSize, getSort());
	}

	public boolean isPageable() {
		return true;
	}

}

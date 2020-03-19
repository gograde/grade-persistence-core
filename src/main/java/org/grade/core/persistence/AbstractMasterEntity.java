package org.grade.core.persistence;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractMasterEntity extends AbstractEntity{
	
	@Column(name="code", length = 10, nullable = false)
	private String code;
	
	@Column(name="name", length = 40, nullable = false)
	private String name;
	
	@Column(name="description", length = 255, nullable = false)
	private String description;
	
	@Column(name="active")
	private Boolean active;

}

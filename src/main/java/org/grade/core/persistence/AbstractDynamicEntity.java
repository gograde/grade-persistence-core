package org.grade.core.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractDynamicEntity extends AbstractEntity{

	@Column(name="created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@Column(name="updated_at")
	@Temporal(TemporalType.DATE)
	private Date updatedAt;
	
}

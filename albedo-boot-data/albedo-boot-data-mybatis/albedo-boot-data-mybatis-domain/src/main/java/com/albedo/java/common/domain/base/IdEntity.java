package com.albedo.java.common.domain.base;

import com.albedo.java.common.data.mybatis.persistence.IdGen;
import com.albedo.java.util.PublicUtil;
import com.albedo.java.util.annotation.SearchField;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mybatis.annotations.*;
import org.springframework.data.mybatis.domains.Persistable;

@MappedSuperclass
public abstract class IdEntity extends DataEntity<String> {

	private static final long serialVersionUID = 1L;
	@SearchField
	@Id(strategy = Id.GenerationType.UUID)
	@Column(name = "id_")
	protected String id; // 编号

	@PreInssert
	public void preInssert() {
		if(PublicUtil.isEmpty(getId())){
			setId(IdGen.uuid());
		}
	}
	@PreUpdate
	public void preUpdate() {

	}

	public IdEntity() {
		super();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (PublicUtil.isNotEmpty(id))this.id = id;
	}

}

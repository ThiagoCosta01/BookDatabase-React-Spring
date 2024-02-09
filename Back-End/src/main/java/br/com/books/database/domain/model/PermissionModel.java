package br.com.books.database.domain.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;

@Entity
@Table(name = "permission")
public class PermissionModel implements Serializable, GrantedAuthority{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;

	//Constructors
	public PermissionModel() {}
	
	//GettersAndSetters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	//GrantedAuthority
	@Override
	public String getAuthority() {
		return this.description;
	}

	//HashCodeAndEquals
	@Override
	public int hashCode() {
		return Objects.hash(description, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissionModel other = (PermissionModel) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id);
	}
	
	
	
	
}


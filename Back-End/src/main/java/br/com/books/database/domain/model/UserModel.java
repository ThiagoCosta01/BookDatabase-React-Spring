package br.com.books.database.domain.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.books.database.dto.RegisterDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

	@Table(name = "users")
	@Entity
	public class UserModel implements Serializable, UserDetails{

		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;

		@Column(name = "user_name", nullable = false, length = 50, unique = true)
		private String userName;

		@Column(name = "password", nullable = false, length = 255)
		private String password;

		@Column(name="account_non_expired")
		private boolean accountNonExpired;
		
		@Column(name="account_non_locked")
		private boolean accountNonLocked;
		
		@Column(name="credentials_non_expired")
		private boolean credentialsNonExpired;

		@Column(name="enabled")
		private boolean enabled;

		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name = "user_permission", joinColumns = {@JoinColumn (name = "id_user")},
		inverseJoinColumns = {@JoinColumn (name = "id_permission")}				)
		private List<PermissionModel> permissions;
		
		//Constructors
		public UserModel() {}

		public UserModel(String userName, String password) {
			this.userName = userName;
			this.password = password;
			
			
		}
		//UserDetails
		
		public List<String> getRoles(){
			List<String> roles = new ArrayList<>();
			for(PermissionModel permission : permissions) {
				roles.add(permission.getDescription());
			}
			
			
			return roles;
			
		}
		
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return this.permissions;
		}

		@Override
		public String getPassword() {
			return this.password;
		}

		@Override
		public String getUsername() {
			return this.userName;
		}

		@Override
		public boolean isAccountNonExpired() {
			return this.credentialsNonExpired;
		}

		@Override
		public boolean isAccountNonLocked() {
			return this.accountNonLocked;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return this.credentialsNonExpired;
		}

		@Override
		public boolean isEnabled() {
			return this.enabled;
		}
		
		
		
		
		
	
		
		
}

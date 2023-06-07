package br.ufrn.imd.progdistribuida.accountmanager.model;

import br.ufrn.imd.progdistribuida.accountmanager.config.Views;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name="users")
@Document(collection = "users")
@JsonPropertyOrder({"id", "username", "password"})
public class User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	
	@Indexed(unique = true)
	private String login;
	
	private String password;

	private Person person;

	//private String role;
	
	public User() {
		
	}
	@JsonView(Views.Admin.class)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		// TODO Auto-generated method stub
		return login;
	}
	
	public void setLogin(String login) {
		// TODO Auto-generated method stub
		this.login= login;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String encryptedPassword) {
		// TODO Auto-generated method stub
		this.password = encryptedPassword;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	

	@Override
	@JsonView(Views.Admin.class)
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority("USER"));
	}

	@Override
	@JsonView({Views.Public.class, Views.Admin.class})
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	@JsonView({Views.Public.class, Views.Admin.class})
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	@JsonView(Views.Admin.class)
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonView(Views.Admin.class)
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonView(Views.Admin.class)
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonView(Views.Admin.class)
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

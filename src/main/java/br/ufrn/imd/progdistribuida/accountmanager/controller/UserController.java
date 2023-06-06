package br.ufrn.imd.progdistribuida.accountmanager.controller;

import br.ufrn.imd.progdistribuida.accountmanager.config.Views;
import br.ufrn.imd.progdistribuida.accountmanager.dto.Login;
import br.ufrn.imd.progdistribuida.accountmanager.exception.UserNotFoundException;
import br.ufrn.imd.progdistribuida.accountmanager.model.User;
import br.ufrn.imd.progdistribuida.accountmanager.repository.UserRepository;
import br.ufrn.imd.progdistribuida.accountmanager.service.UserService;
import br.ufrn.imd.progdistribuida.accountmanager.security.TokenService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

	private final UserRepository userRepository;
	private final UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	public UserController(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;

	}

	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				login.login(), login.password());
		Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		var user = (User) authenticate.getPrincipal();

		return tokenService.gerarToken(user);

	}
	
	@PostMapping("/register")
	@JsonView(Views.Public.class)
	public ResponseEntity<User> createUser(@RequestBody User user) {
	    User createdUser = userService.createUser(user);
	    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}

	// ListarTodos apenas se autenticado
	@GetMapping("/users")
	@JsonView(Views.Admin.class)
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id) {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("Usuário com ID: "+id+" não foi encontrado"));
	    return ResponseEntity.ok(user);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
	    User user = userService.updateUser(id, updatedUser);
	    return ResponseEntity.status(HttpStatus.OK).body("Usuário "+ user.getLogin() +" atualizado com sucesso");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id) {
	    userRepository.deleteById(id);
	    return ResponseEntity.status(HttpStatus.OK).body("Usuário com id "+ id +" excluído com sucesso");
	}

}

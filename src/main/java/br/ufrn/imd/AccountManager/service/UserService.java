package br.ufrn.imd.AccountManager.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ufrn.imd.AccountManager.exception.UserNotFoundException;
import br.ufrn.imd.AccountManager.model.User;
import br.ufrn.imd.AccountManager.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public User createUser(User user) {
		// Criptografar a senha antes de salvar no banco de dados
		String encryptedPassword = passwordEncoder.encode(user.getPass());
		user.setPass(encryptedPassword);

		return userRepository.save(user);
	}

	public User updateUser(String userId, User updatedUser) {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

		user.setLogin(updatedUser.getLogin());
		// Criptografar a nova senha antes de atualizar no banco de dados
		String encryptedPassword = passwordEncoder.encode(updatedUser.getPass());
		user.setPass(encryptedPassword);

		return userRepository.save(user);
	}

}

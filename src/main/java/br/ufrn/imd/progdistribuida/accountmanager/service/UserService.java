package br.ufrn.imd.progdistribuida.accountmanager.service;



import br.ufrn.imd.progdistribuida.accountmanager.exception.UserNotFoundException;
import br.ufrn.imd.progdistribuida.accountmanager.model.User;
import br.ufrn.imd.progdistribuida.accountmanager.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

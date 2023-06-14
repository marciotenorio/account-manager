package br.ufrn.imd.progdistribuida.accountmanager.service;

import br.ufrn.imd.progdistribuida.accountmanager.dto.UserAppDto;
import br.ufrn.imd.progdistribuida.accountmanager.exception.NotFoundException;
import br.ufrn.imd.progdistribuida.accountmanager.exception.UserException;
import br.ufrn.imd.progdistribuida.accountmanager.model.App;
import br.ufrn.imd.progdistribuida.accountmanager.model.User;
import br.ufrn.imd.progdistribuida.accountmanager.repository.AppRepository;
import br.ufrn.imd.progdistribuida.accountmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AppRepository appRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    public User findByCpf(String cpf){
        return userRepository.findByCpf(cpf);
    }

    public User findByCnpj(String cnpj){
        return userRepository.findByCnpj(cnpj);
    }

    public User save(User user) {
        User userExists;

        if (user.getCpf() != null && user.getCnpj() == null) {
            userExists = userRepository.findByCpf(user.getCpf());
        } else if (user.getCpf() == null && user.getCnpj() != null) {
            userExists = userRepository.findByCnpj(user.getCnpj());
        } else {
            throw new UserException("Campo CPF ou CNPJ precisa estar preenchido.");
        }

        if (userExists != null) {
            throw new UserException("Usuário já existe com este CPF/CNPJ");
        }

        return userRepository.save(user);
    }

    @Transactional
    public User save(UserAppDto userApp) {
        User userExists = null;

        if (userApp.user().getCpf() != null && userApp.user().getCnpj() == null) {
            userExists = userRepository.findByCpf(userApp.user().getCpf());
        } else if (userApp.user().getCpf() == null && userApp.user().getCnpj() != null) {
            userExists = userRepository.findByCnpj(userApp.user().getCnpj());
        } else {
            throw new UserException("Campo CPF ou CNPJ precisa estar preenchido.");
        }

        if (userExists != null) {
            throw new UserException("Usuário já existe com este CPF/CNPJ");
        }

        User savedUser = userRepository.save(userApp.user());

        App app = new App();
        app.setUserId(savedUser.getId());
        app.setName(userApp.app().name());
        app.setType(userApp.app().type());
        app.setSocialMedias(userApp.app().socialMedias());
        appRepository.save(app);

        return savedUser;
    }

    public User update(User user) {
        User userSaved = findById(user.getId());
        user.setId(userSaved.getId());
        return userRepository.save(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}

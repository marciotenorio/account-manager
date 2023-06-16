package br.ufrn.imd.progdistribuida.accountmanager.service;

import br.ufrn.imd.progdistribuida.accountmanager.model.App;
import br.ufrn.imd.progdistribuida.accountmanager.repository.AppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppService {

    private final AppRepository appRepository;

    public List<App> findAppsByUserId(String userId){
        return appRepository.findAppByUserId(userId);
    }

    public App createApp(App app) {
        return appRepository.save(app);
    }

    public App updateApp(App app) {

        if (appRepository.existsById(app.getId())) {
            return appRepository.save(app);
        } else {
            throw new IllegalArgumentException("O aplicativo não existe.");
        }
    }

    public void deleteApp(Long appId) {

        if (appRepository.existsById(appId)) {
            appRepository.deleteById(appId);
        } else {
            throw new IllegalArgumentException("O aplicativo não existe.");
        }
    }
}

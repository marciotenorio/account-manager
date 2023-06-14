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
}

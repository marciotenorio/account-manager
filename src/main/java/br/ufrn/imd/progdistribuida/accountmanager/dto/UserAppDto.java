package br.ufrn.imd.progdistribuida.accountmanager.dto;

import br.ufrn.imd.progdistribuida.accountmanager.model.User;

public record UserAppDto(User user,
                         AppDto app) {
}

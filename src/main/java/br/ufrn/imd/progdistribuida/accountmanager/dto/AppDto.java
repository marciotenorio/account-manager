package br.ufrn.imd.progdistribuida.accountmanager.dto;

import br.ufrn.imd.progdistribuida.accountmanager.model.AppType;
import br.ufrn.imd.progdistribuida.accountmanager.model.SocialMedia;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AppDto(@NotNull
                     String name,
                     AppType type,
                     @NotNull
                     List<SocialMedia> socialMedias) {
}

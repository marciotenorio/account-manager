package br.ufrn.imd.progdistribuida.accountmanager.dto;

public record PersonPostRequest(String name,
                                String cpf,
                                String cnpj) {
}

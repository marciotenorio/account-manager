package br.ufrn.imd.progdistribuida.accountmanager.model;

public class SocialMedia {

    private SocialMediaType type;
    private String token;


    public SocialMediaType getType() {
        return type;
    }

    public void setType(SocialMediaType type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

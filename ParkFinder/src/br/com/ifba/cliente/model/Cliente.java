package br.com.ifba.cliente.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Cliente")
public class Cliente extends PersistenceEntity{
    
    String nome;
    String email;
    String senha;
    Long latitude;
    Long longitude;

    public Cliente() {
    }

    
    public Cliente(String nome, String email, String senha, Long latitude, Long longitude) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }


    
}

package br.com.ifba.cliente.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "Cliente")
public class Cliente extends PersistenceEntity implements Serializable, UserDetails{
    
    private String nome;
    private String email;
    private String senha;
    private double latitude;
    private double longitude;

    
    
    public Cliente(String nome, String email, String senha, double latitude, double longitude) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Cliente(){}

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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
}


    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
           return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
           return true;
    }

    @Override
    public boolean isEnabled() {
           return true;
    }


    
}

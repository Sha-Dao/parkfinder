package br.com.ifba.vaga.model;

import br.com.ifba.infrastructure.model.PersistenceEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vaga")
public class Vaga extends PersistenceEntity {

    private double latitude;
    private double longitude;
    private Boolean ocupado;
    private String tipo;
    private Integer idArea;

    public Vaga(double latitude, double longitude, Boolean ocupado, String tipo, Integer idArea) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.ocupado = ocupado;
        this.tipo = tipo;
        this.idArea = idArea;
    }
    
    public Vaga(){
        
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

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }
}

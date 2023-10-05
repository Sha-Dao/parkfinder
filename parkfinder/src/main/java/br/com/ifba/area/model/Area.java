/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.area.model;

/**
 *
 * @author rafael
 */
import br.com.ifba.infrastructure.model.PersistenceEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Area")
public class Area extends PersistenceEntity {
    private double raio;
    private double latitude;
    private double longitude;

    public Area() {
    }

    public Area(double raio, double latitude, double longitude) {
        this.raio = raio;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    



    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
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
}

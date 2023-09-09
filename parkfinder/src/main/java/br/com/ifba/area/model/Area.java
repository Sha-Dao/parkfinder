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
    private String descricao;
    private Long latitude;
    private Long longitude;

    public Area() {
    }

    public Area(String descricao, Long latitude, Long longitude) {
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.area.service;

import br.com.ifba.area.model.Area;
import java.util.List;

public interface IAreaService {
    
    public Area saveArea(Area area);
    public void deleteArea(Area area);
    public Area updateArea(Area area);
    public List<Area> findAllArea();
    public boolean checkLoginArea(String username, String password);
    public boolean findByUsername(String username);
    
}
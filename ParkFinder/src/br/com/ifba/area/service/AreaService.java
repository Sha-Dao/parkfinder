/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.area.service;

/**
 *
 * @author rafael
 */
import br.com.ifba.area.dao.AreaDAO;
import br.com.ifba.area.model.Area;
import java.util.List;
import br.com.ifba.area.dao.IAreaDAO;


public class AreaService implements IAreaService {
    
    private final IAreaDAO areaDAO = new AreaDAO();

    @Override
    public Area saveArea(Area area) {
        return areaDAO.save(area);
    }

    @Override
    public void deleteArea(Area area) {
        areaDAO.delete(area);
    }

    @Override
    public Area updateArea(Area area) {
        return areaDAO.update(area);
    }

    @Override
    public List<Area> findAllArea() {
        return areaDAO.findAll();
    }

    
}
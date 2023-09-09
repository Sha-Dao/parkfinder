
package br.com.ifba.area.service;


/**
 *
 * @author rafael
 */

import br.com.ifba.area.model.Area;
import java.util.List;
import br.com.ifba.area.dao.IAreaDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService implements IAreaService {
    
    
 @Autowired
     private IAreaDAO areaDAO;

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
        return areaDAO.save(area);
    }

    @Override
    public List<Area> findAllArea() {
        return areaDAO.findAll();
    }

    
}
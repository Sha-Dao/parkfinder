package br.com.ifba.area.dao;
/**
 *
 * @author dani
 */
import br.com.ifba.infrastructure.dao.IBaseDao;
import br.com.ifba.area.model.Area;

public interface IAreaDAO extends IBaseDao<Area> {
    
    Area saveArea(Area area);
    Area deleteArea(Area area);
    Area updateArea(Area area);
    Area[] findAllArea();
    
}


package br.com.ifba.area.dao;
/**
 *
 * @author dani
 */
import br.com.ifba.infrastructure.dao.BaseDao;
import br.com.ifba.area.model.Area;
import javax.persistence.Query;

public class AreaDAO extends BaseDao<Area> implements IAreaDAO {

    @Override
    public Area saveArea(Area area) {
        return save(area);
    }

    @Override
    public Area deleteArea(Area area) {
        return delete(area);  
    }

    @Override
    public Area updateArea(Area area) {
        return update(area);
    }

    @Override
    public Area[] findAllArea() {
        String sql = "SELECT a FROM Area AS a";
        Query query = entityManager.createQuery(sql);
        return (Area[]) query.getResultList().toArray(new Area[0]);
    }
}


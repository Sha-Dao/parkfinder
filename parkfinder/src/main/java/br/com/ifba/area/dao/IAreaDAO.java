package br.com.ifba.area.dao;
/**
 *
 * @author dani
 */

import br.com.ifba.area.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAreaDAO extends JpaRepository<Area, Long> {
    
}
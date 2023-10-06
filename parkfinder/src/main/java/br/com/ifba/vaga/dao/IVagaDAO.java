/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vaga.dao;
import br.com.ifba.vaga.model.Vaga;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author santo
 */
@Repository
public interface IVagaDAO extends JpaRepository<Vaga, Long>{
    
        @Query("update Vaga v set v.ocupado = :ocupado where v.id = :id")
        @Modifying
        @Transactional
          void updateVaga(@Param("id") Long id, @Param("ocupado") Boolean ocupado);
}

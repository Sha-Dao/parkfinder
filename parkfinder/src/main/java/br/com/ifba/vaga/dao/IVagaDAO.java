/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifba.vaga.dao;
import br.com.ifba.vaga.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author santo
 */
@Repository
public interface IVagaDAO extends JpaRepository<Vaga, Long>{
    
}

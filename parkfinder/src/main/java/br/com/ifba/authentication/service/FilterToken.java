/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.authentication.service;

import br.com.ifba.cliente.dao.IClienteDAO;
import br.com.ifba.cliente.model.Cliente;
import br.com.ifba.infrastructure.facade.IFacade;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author j_ped
 */
@Component
public class FilterToken extends OncePerRequestFilter {
    String token;
    
    @Autowired
    private TokenService tokenService;
    
     @Autowired
    private IFacade ifacadedao;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
       
        String authorizationHeader = request.getHeader("Authorization");
        
        if (authorizationHeader != null){
            token = authorizationHeader.replace("Bearer", "");
            String subject =  this.tokenService.getSubject(token);
           
            
            Cliente cliente = this.ifacadedao.findByUsernameCliente(subject);
            
            
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(cliente, null, cliente.getAuthorities());
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            
        }
        
        filterChain.doFilter(request, response);
    }
    
    
}

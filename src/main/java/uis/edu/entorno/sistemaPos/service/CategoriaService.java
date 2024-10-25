/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entorno.sistemaPos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.entorno.sistemaPos.model.Categoria;
import uis.edu.entorno.sistemaPos.repository.CategoriaRepository;

/**
 *
 * @author Huawei PC
 */
@Service
@Transactional
public class CategoriaService implements ICategoriaService{
    
    @Autowired
    CategoriaRepository categoriaRepository;
    
    @Override
    public List<Categoria> getCategorias(){
        return categoriaRepository.findAll();
    }
    
    @Override
    public Categoria nuevaCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
    @Override
    public Categoria buscarCategoria(Long identificacion){
        Categoria categoria = null;
        categoria = categoriaRepository.findById(identificacion).orElse(null);
        if (categoria == null){
            return null;
        } 
        return categoria;
    }
    
    @Override
    public int borrarCategoria(Long identificacion){
        categoriaRepository.deleteById(identificacion);
        return 1;
    }
    
}

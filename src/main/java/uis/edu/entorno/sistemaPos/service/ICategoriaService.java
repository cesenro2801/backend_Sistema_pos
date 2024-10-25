/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entorno.sistemaPos.service;

import java.util.List;
import uis.edu.entorno.sistemaPos.model.Categoria;

/**
 *
 * @author Huawei PC
 */
public interface ICategoriaService {
     
    List<Categoria> getCategorias();
    
    Categoria nuevaCategoria(Categoria categoria);
    
    Categoria buscarCategoria(Long identificacion);
    
    int borrarCategoria(Long identificacion);
    
}

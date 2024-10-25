/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entorno.sistemaPos.service;

import java.util.List;
import uis.edu.entorno.sistemaPos.model.Producto;

/**
 *
 * @author Huawei PC
 */
public interface IProductoService {
    
    List<Producto> getProductos();
    
    Producto nuevoProducto(Producto producto);
    
    Producto buscarProducto(Long identificacion);
    
    int borrarProducto(Long identificacion);
    
}

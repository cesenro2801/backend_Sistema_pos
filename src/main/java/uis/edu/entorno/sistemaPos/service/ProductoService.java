/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entorno.sistemaPos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.entorno.sistemaPos.model.Producto;
import uis.edu.entorno.sistemaPos.repository.ProductoRepository;

/**
 *
 * @author Huawei PC
 */
@Service
@Transactional
public class ProductoService implements IProductoService{
    
    @Autowired
    ProductoRepository productoRepository;
    
    @Override
    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }
    
    @Override
    public Producto nuevoProducto(Producto producto){
        return productoRepository.save(producto);
    }
    
    @Override
    public Producto buscarProducto(Long identificacion){
        Producto producto = null;
        producto = productoRepository.findById(identificacion).orElse(null);
        if (producto == null){
            return null;
        } 
        return producto;
    }
    
    @Override
    public int borrarProducto(Long identificacion){
        productoRepository.deleteById(identificacion);
        return 1;
    }
    
}

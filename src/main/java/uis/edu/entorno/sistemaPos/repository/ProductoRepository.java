/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entorno.sistemaPos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uis.edu.entorno.sistemaPos.model.Producto;

/**
 *
 * @author Huawei PC
 */
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entorno.sistemaPos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Huawei PC
 */
@Entity
@Table(name = Categoria.TABLE_NAME)
public class Categoria {
    public static final String TABLE_NAME="categorias";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificacion;
    
    private String descripcion;
    private String color;
    
    public Categoria(){
    }
    
    public Categoria(Long identificacion, String descripcion, String color){
        this.identificacion=identificacion;
        this.descripcion=descripcion;
        this.color=color;
    }
    
    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}

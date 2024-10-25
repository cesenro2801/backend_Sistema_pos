/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entorno.sistemaPos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = Producto.TABLE_NAME)
public class Producto {
    
    public static final String TABLE_NAME = "productos";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificacion;
    private String descripcion;
    private BigDecimal existencias;
    private BigDecimal stock_minimo;
    private String codigobarras;
    private String codigo_interno;
    private BigDecimal precioventa;
    private BigDecimal preciocompra;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    
    public Producto(){
    }
    
    public Producto(Long identificacion, String descripcion, BigDecimal existencias, BigDecimal stock_minimo, String codigobarras, String codigo_interno,
            BigDecimal precioventa, BigDecimal preciocompra, Categoria categoria){
        this.identificacion= identificacion;
        this.descripcion=descripcion;
        this.existencias=existencias;
        this.stock_minimo=stock_minimo;
        this.codigobarras=codigobarras;
        this.codigo_interno=codigo_interno;
        this.precioventa=precioventa;
        this.preciocompra=preciocompra;
        this.categoria=categoria;
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

    public BigDecimal getExistencias() {
        return existencias;
    }

    public void setExistencias(BigDecimal existencias) {
        this.existencias = existencias;
    }

    public BigDecimal getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(BigDecimal stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public String getCodigo_interno() {
        return codigo_interno;
    }

    public void setCodigo_interno(String codigo_interno) {
        this.codigo_interno = codigo_interno;
    }

    public BigDecimal getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }

    public BigDecimal getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(BigDecimal preciocompra) {
        this.preciocompra = preciocompra;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entorno.sistemaPos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uis.edu.entorno.sistemaPos.model.Producto;
import uis.edu.entorno.sistemaPos.service.ProductoService;

/**
 *
 * @author Huawei PC
 */
@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")   
    @GetMapping("/list")
    public List<Producto> cargarProductos(){
        return productoService.getProductos();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")  
    @GetMapping("/list/{identificacion}")
    public Producto bucarPorIdentidicacion(@PathVariable Long identificacion){
        return productoService.buscarProducto(identificacion);
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")    
    @PostMapping("/")
    public ResponseEntity<Producto> agregar(@RequestBody Producto producto){
        Producto obj= productoService.nuevoProducto(producto);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")    
    @PutMapping("/")
    public ResponseEntity<Producto> editar(@RequestBody Producto producto){
        Producto obj= productoService.buscarProducto(producto.getIdentificacion());
        if(obj != null){
            obj.setDescripcion(producto.getDescripcion());
            obj.setExistencias(producto.getExistencias());
            obj.setStock_minimo(producto.getStock_minimo());
            obj.setCodigobarras(producto.getCodigobarras());
            obj.setCodigo_interno(producto.getCodigo_interno());
            obj.setPrecioventa(producto.getPrecioventa());
            obj.setPreciocompra(producto.getPreciocompra());
            obj.setCategoria(producto.getCategoria());
            productoService.nuevoProducto(obj);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);       
    }
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping("/{identificacion}")
     public ResponseEntity<Producto> eliminar(@PathVariable Long identificacion) {
        Producto obj = productoService.buscarProducto(identificacion);
        if(obj != null) {
            productoService.borrarProducto(identificacion);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    
}

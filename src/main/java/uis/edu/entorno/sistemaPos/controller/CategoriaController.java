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
import uis.edu.entorno.sistemaPos.model.Categoria;
import uis.edu.entorno.sistemaPos.service.CategoriaService;

/**
 *
 * @author Huawei PC
 */
@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/list")
    public List<Categoria> cargarCategorias(){
        return categoriaService.getCategorias();
    }

    @GetMapping("/list/{identificacion}")
    public Categoria bucarPorIdentidicacion(@PathVariable Long identificacion){
        return categoriaService.buscarCategoria(identificacion);
    }

    @PostMapping("/")
    public ResponseEntity<Categoria> agregar(@RequestBody Categoria categoria){
        Categoria obj= categoriaService.nuevaCategoria(categoria);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Categoria> editar(@RequestBody Categoria categoria){
        Categoria obj= categoriaService.buscarCategoria(categoria.getIdentificacion());
        if(obj != null){
            obj.setDescripcion(categoria.getDescripcion());
            obj.setColor(categoria.getColor());
            categoriaService.nuevaCategoria(obj);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);       
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<Categoria> eliminar(@PathVariable Long identificacion) {
        Categoria obj = categoriaService.buscarCategoria(identificacion);
        if(obj != null) {
            categoriaService.borrarCategoria(identificacion);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
   
}

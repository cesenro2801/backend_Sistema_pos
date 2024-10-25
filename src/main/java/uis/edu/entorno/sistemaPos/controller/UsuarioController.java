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
import uis.edu.entorno.sistemaPos.model.LoginDto;
import uis.edu.entorno.sistemaPos.model.Usuario;
import uis.edu.entorno.sistemaPos.service.UsuarioService;

/**
 *
 * @author Huawei PC
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/list")
    public List<Usuario> cargarUsuarios() {
        return usuarioService.getUsuarios();
    }
    
    @GetMapping("/list/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario) {
        Usuario obj = usuarioService.nuevoUsuario(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario) {
        Usuario obj = usuarioService.buscarUsuario(usuario.getId());
        if(obj != null) {
            obj.setUsername(usuario.getUsername());
            obj.setPassword(usuario.getPassword());
            usuarioService.nuevoUsuario(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Long id) {
        Usuario obj = usuarioService.buscarUsuario(id);
        if(obj != null) {
            usuarioService.borrarUsuario(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/loginclient") // ruta del servicio desde el front deben direccionar a esta ruta
    public int login(@RequestBody LoginDto usuario) {
        int responseLogin = usuarioService.login(usuario);
        return responseLogin;
    }

    @PostMapping("/login") // ruta del servicio desde el front deben direccionar a esta ruta
    public ResponseEntity<?> loginCliente(@RequestBody LoginDto usuario) {
        return usuarioService.ingresar(usuario);
    }
    
}

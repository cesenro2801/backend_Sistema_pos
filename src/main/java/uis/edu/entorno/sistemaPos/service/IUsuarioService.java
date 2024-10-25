/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entorno.sistemaPos.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import uis.edu.entorno.sistemaPos.model.LoginDto;
import uis.edu.entorno.sistemaPos.model.Usuario;

/**
 *
 * @author Huawei PC
 */
public interface IUsuarioService {
    
    List<Usuario> getUsuarios();
    
    Usuario nuevoUsuario(Usuario usuario);
    
    Usuario buscarUsuario(Long id);
    
    int borrarUsuario(Long id);
    
    int login(LoginDto usuarioDto);
    
    ResponseEntity<?> ingresar(LoginDto usuarioDto);
    
}

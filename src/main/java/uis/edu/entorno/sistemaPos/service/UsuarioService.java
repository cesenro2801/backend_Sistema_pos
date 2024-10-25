/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uis.edu.entorno.sistemaPos.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uis.edu.entorno.sistemaPos.model.LoginDto;
import uis.edu.entorno.sistemaPos.model.Usuario;
import uis.edu.entorno.sistemaPos.repository.UsuarioRepository;

/**
 *
 * @author Huawei PC
 */
@Service
@Transactional
public class UsuarioService implements IUsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario nuevoUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        Usuario usuario = null;
        usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            return null;
        }
        return usuario;
    }

    @Override
    public int borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);
        return 1;
    }
    
    @Override
    public int login(LoginDto usuarioDto){
        int u = usuarioRepository.findByNombreUsuarioAndPassword(usuarioDto.getUsername(), usuarioDto.getPassword());
        return u;
    }
    
    @Override
    public ResponseEntity<?> ingresar(LoginDto usuarioDto) {
    Map<String, Object> response = new HashMap<>();
    Usuario usuario = null;
    
    try {
        usuario = usuarioRepository.findByNameAndPassword(usuarioDto.getUsername(), usuarioDto.getPassword());
        
        if (usuario == null) {
            response.put("Usuario", null);
            response.put("Mensaje", "Alerta:Usuario o Password incorrectos");
            response.put("statusCode", HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.put("Usuario", usuario);
            response.put("Mensaje", "Datos correctos");
            response.put("statusCode", HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        
    } catch (Exception e) {
        response.put("Usuario", null);
        response.put("Mensaje", "Ha ocurrido un error");
        response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    
}

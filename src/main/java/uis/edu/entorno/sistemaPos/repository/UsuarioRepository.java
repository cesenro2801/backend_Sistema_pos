/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package uis.edu.entorno.sistemaPos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uis.edu.entorno.sistemaPos.model.Usuario;
/**
 *
 * @author Huawei PC
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    @Query("select count(*) from Usuario as p where p.username= :username and p.password=:password")
    Integer findByNombreUsuarioAndPassword(@Param("username") String username,
                                         @Param("password") String password);
    
    @Query("select p from Usuario as p where p.username= :username and p.password=:password")
    Usuario findByNameAndPassword(@Param("username") String username,
                                @Param("password") String password);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaModelador.Usuarios;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public interface UsuarioDAO {

    public boolean agregarUsuario(Usuarios usuario);

    public boolean editarUsuario(Usuarios usuario);

    public boolean eliminarUsuario(String correo);

    public boolean eliminarUsuarioIdentificacion(String identificacion);

    public Usuarios buscarUsuario(String acceso, String entrada);

    public Usuarios buscarUsuarioNickName(String nickname);

    public List<Usuarios> listaUsuarios();

    public int cantidadUsuarios();
}

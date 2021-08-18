/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.conexion.dao.UsuarioDAOImp;
import co.logitransportes.logic.capaModelador.Usuarios;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaUsuario {
    
    private Usuarios usuario;
    private UsuarioDAOImp usuarioDAOImp;

    public FachadaUsuario() {
        this.usuario = new Usuarios();
        this.usuarioDAOImp = new UsuarioDAOImp();
    }

    public boolean registrarUsuario(Usuarios usuario) {
        return usuarioDAOImp.agregarUsuario(usuario);
    }

    public boolean editarUsuario(Usuarios usuario) {
        return usuarioDAOImp.editarUsuario(usuario);
    }

    public boolean eliminarUsuario(String correo) {
        return usuarioDAOImp.eliminarUsuario(correo);
    }
    
    public boolean eliminarUsuarioIdentificacion(String identificacion) {
        return usuarioDAOImp.eliminarUsuarioIdentificacion(identificacion);
    }

    public Usuarios buscarUsuario(String acceso,String entrada) {
        return usuarioDAOImp.buscarUsuario(acceso,entrada);
    }

    public List<Usuarios> listaUsuarios() {
        return usuarioDAOImp.listaUsuarios();
    }

    public int cantidadUsuarios() {
        return usuarioDAOImp.cantidadUsuarios();
    } 
}

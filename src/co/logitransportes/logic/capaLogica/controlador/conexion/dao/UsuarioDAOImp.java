/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaLogica.controlador.conexion.ConexionMySQL;
import co.logitransportes.logic.capaModelador.Usuarios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo y Roberth
 */
public class UsuarioDAOImp implements UsuarioDAO {

    private final ConexionMySQL conexion;
    private final PersonaDAO personaDAO;

    public UsuarioDAOImp() {
        this.conexion = new ConexionMySQL("localhost", 3300, "logicdb", "root", "root");
        this.personaDAO = new PersonaDAOImp();
    }

    @Override
    public boolean agregarUsuario(Usuarios usuario) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO usuarios VALUES ("
                    + "'" + usuario.getCorreo() + "', "
                    + "'" + usuario.getNickname() + "', "
                    + "'" + usuario.getContrasenia() + "', "
                    + "'" + usuario.getIdentificacion().getIdentificacion() + "');";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar el usuario.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean editarUsuario(Usuarios usuario) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE usuarios SET "
                    + "nickname= '" + usuario.getNickname() + "',"
                    + "correo = '" + usuario.getCorreo() + "', "
                    + "contrasenia = '" + usuario.getContrasenia() + "', "
                    + "persona = '" + usuario.getIdentificacion().getIdentificacion()+ "'); ";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar al usuario.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean eliminarUsuario(String correo) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM usuarios WHERE correo = '" + correo + "';";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar al usuario.");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public boolean eliminarUsuarioIdentificacion(String identificacion) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM usuarios WHERE persona = '" + identificacion + "';";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar al usuario.");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public Usuarios buscarUsuario(String acceso, String entrada) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM usuarios WHERE " + entrada + " = '" + acceso + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Usuarios usuario = new Usuarios(
                    resultSet.getString("correo"),
                    resultSet.getString("nickname"),
                    resultSet.getString("contrasenia"),
                    personaDAO.buscarPersona(resultSet.getString("identificacion"))
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return usuario;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla usuario.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Usuarios buscarUsuarioNickName(String nickname) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM usuarios WHERE nickname = '" + nickname + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Usuarios usuario = new Usuarios(
                    resultSet.getString("correo"),
                    resultSet.getString("nickname"),
                    resultSet.getString("contrasenia"),
                    personaDAO.buscarPersona(resultSet.getString("identificacion"))
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return usuario;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla usuario.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<Usuarios> listaUsuarios() {
        List<Usuarios> usuarios = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM personas;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Usuarios usuario = new Usuarios(
                        resultSet.getString("correo"),
                        resultSet.getString("nickname"),
                        resultSet.getString("contrasenia"),
                    personaDAO.buscarPersona(resultSet.getString("identificacion"))
                );
                usuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla usuario.");

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public int cantidadUsuarios() {
        return listaUsuarios().size();
    }

}

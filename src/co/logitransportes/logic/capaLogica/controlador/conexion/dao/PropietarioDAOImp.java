/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaLogica.controlador.conexion.ConexionMySQL;
import co.logitransportes.logic.capaModelador.Personas;
import co.logitransportes.logic.capaModelador.Propietarios;
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
public class PropietarioDAOImp implements PropietarioDAO {

    private final ConexionMySQL conexion;
    private PersonaDAOImp personaDAOImp;

    public PropietarioDAOImp() {
        this.conexion = new ConexionMySQL("localhost", 3300, "logicdb", "root", "root");
        this.personaDAOImp = new PersonaDAOImp();
    }

    @Override
    public boolean agregarPropietario(Propietarios propietario) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO propietarios VALUES ("
                    + propietario.getPersonas().getIdentificacion() + ", "
                    + "'" + propietario.getNit() + "', "
                    + "'" + propietario.getCuentaBancaria() + "'); ";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar el propietario.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar el propietario.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean editarPropietario(Propietarios propietario) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE propietarios SET "
                    + "identificacion = " + propietario.getPersonas().getIdentificacion() + ", "
                    + "nit = '" + propietario.getNit() + "', "
                    + "cuentaBancaria = " + propietario.getCuentaBancaria() + "); ";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar la propietario.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean eliminarPropietario(String identificacion) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM propietarios WHERE persona_cedula = '" + identificacion + "';";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar la propietario.");
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public boolean eliminarPropietarioNit(String nit) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM propietarios WHERE nit = '" + nit + "';";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar la propietario.");
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public Propietarios buscarPropietario(String identificacion) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM propietarios WHERE identificacion = '" + identificacion + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Propietarios propietario = new Propietarios(
                    personaDAOImp.buscarPersona(resultSet.getString("identificacion")),
                    resultSet.getString("nit"),
                    resultSet.getString("cuentaBancaria")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return propietario;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla propietario.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Propietarios buscarPropietarioNit(String nit) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM propietarios WHERE nit = '" + nit + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Propietarios propietario = new Propietarios(
                    personaDAOImp.buscarPersona(resultSet.getString("identificacion")),
                    resultSet.getString("nit"),
                    resultSet.getString("cuentaBancaria")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return propietario;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla propietario.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Propietarios> listaPropietarios() {
        List<Propietarios> propietarios = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM personas;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Propietarios propietario = new Propietarios(
                       personaDAOImp.buscarPersona(resultSet.getString("identificacion")),
                    resultSet.getString("nit"),
                    resultSet.getString("cuentaBancaria")
                );
                propietarios.add(propietario);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla propietario.");

        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return propietarios;
    }

    @Override
    public int cantidadPropietarios() {
        return listaPropietarios().size();
    }

}

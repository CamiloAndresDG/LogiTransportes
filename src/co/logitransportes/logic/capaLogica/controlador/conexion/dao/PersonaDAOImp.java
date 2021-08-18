/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaLogica.controlador.conexion.ConexionMySQL;
import co.logitransportes.logic.capaModelador.Personas;
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
public class PersonaDAOImp implements PersonaDAO {

    private final ConexionMySQL conexion;

    public PersonaDAOImp() {
        this.conexion = new ConexionMySQL("localhost", 3300, "logicdb", "root", "root");
    }

    @Override
    public boolean agregarPersona(Personas persona) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO personas VALUES ("
                    + "'" + persona.getIdentificacion() + "', "
                    + "'" + persona.getNombres() + "', "
                    + "'" + persona.getApellidos() + "', "
                    + persona.getCelularContacto() + ", "
                    + persona.getTelefonoContacto() + ", "
                    + persona.getEstadoIntegridad() + "); ";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar la persona");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar la persona.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean editarPersona(Personas persona) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE personas SET "
                    + "identificacion = " + persona.getIdentificacion() + ", "
                    + "nombres = '" + persona.getNombres() + "', "
                    + "apellidos = '" + persona.getApellidos() + "', "
                    + "celularContacto= " + persona.getCelularContacto() + ", "
                    + "telefonoContacto= " + persona.getTelefonoContacto() + ", "
                    + "estadoIntegridad = " + persona.getEstadoIntegridad() + "); ";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar la persona.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean eliminarPersona(String identificacion) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM personas WHERE identificacion = '" + identificacion + "';";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar la persona.");
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public Personas buscarPersona(String identificacion) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM personas WHERE identificacion = '" + identificacion + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Personas persona = new Personas(
                    resultSet.getString("identificacion"),
                    resultSet.getString("nombres"),
                    resultSet.getString("apellidos"),
                    resultSet.getLong("celularContacto"),
                    resultSet.getLong("telefonoContacto"),
                    resultSet.getBoolean("estadoIntegridad")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return persona;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla persona.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<Personas> listaPersonas() {
        List<Personas> personas = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM personas;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Personas persona = new Personas(
                        resultSet.getString("identificacion"),
                        resultSet.getString("nombres"),
                        resultSet.getString("apellidos"),
                        resultSet.getLong("celularContacto"),
                        resultSet.getLong("telefonoContacto"),
                        resultSet.getBoolean("estadoIntegridad")
                );
                personas.add(persona);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla persona.");

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personas;
    }

    @Override
    public int cantidadPersonas() {
        return listaPersonas().size();
    }
}

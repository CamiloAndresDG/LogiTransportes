/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaLogica.controlador.conexion.ConexionMySQL;
import co.logitransportes.logic.capaModelador.Satelites;
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
public class SateliteDAOImp implements SateliteDAO {

    private final ConexionMySQL conexion;

    public SateliteDAOImp() {
        this.conexion = new ConexionMySQL("localhost", 3300, "logicdb", "root", "root");
    }

    @Override
    public boolean agregarSatelite(Satelites satelite) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO satelites VALUES ('"
                    + satelite.getProovedor() + "', "
                    + "'" + satelite.getUsuario() + "', "
                    + "'" + satelite.getClave() + "', "
                    + satelite.getEstadoIntegridad() + "); ";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar el satelite.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar el satelite.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean editarSatelite(Satelites satelite) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE satelites SET "
                    + "proovedor = '" + satelite.getProovedor() + "', "
                    + "usuario = '" + satelite.getUsuario() + "', "
                    + "clave = '" + satelite.getClave() + "', "
                    + "estadoIntegridad = " + satelite.getEstadoIntegridad() + "; ";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar el satelite.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean eliminarSatelite(String proovedor, String correo) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM satelites WHERE proovedor = '" + proovedor + "' AND correo= '" + correo + ";";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar el satelite.");
        } catch (SQLException ex) {
            Logger.getLogger(SateliteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public Satelites buscarSatelite(String proovedor, String correo) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM empresa WHERE proovedor = '" + proovedor + "' AND correo= '" + correo + ";";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Satelites satelite = new Satelites(
                    resultSet.getString("proovedor"),
                    resultSet.getString("usuario"),
                    resultSet.getString("clave"),
                    resultSet.getBoolean("estadoIntegridad")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return satelite;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla satelite.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SateliteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<Satelites> listaSatelites() {
        List<Satelites> satelites = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM persona;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Satelites satelite = new Satelites(
                        resultSet.getString("proovedor"),
                        resultSet.getString("usuario"),
                        resultSet.getString("clave"),
                        resultSet.getBoolean("estadoIntegridad")
                );
                satelites.add(satelite);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla satelite.");

        } catch (SQLException ex) {
            Logger.getLogger(SateliteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return satelites;
    }

    @Override
    public int cantidadSatelites() {
        return listaSatelites().size();
    }

}

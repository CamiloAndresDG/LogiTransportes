/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaLogica.controlador.conexion.ConexionMySQL;
import co.logitransportes.logic.capaModelador.Satelites;
import co.logitransportes.logic.capaModelador.Vehiculos;

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
public class VehiculoDAOImp implements VehiculoDAO {

    private final ConexionMySQL conexion;

    public VehiculoDAOImp() {
        this.conexion = new ConexionMySQL("localhost", 3300, "logicdb", "root", "root");
    }

    @Override
    public boolean agregarVehiculo(Vehiculos vehiculo) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO vehiculos VALUES ("
                    + "'" + vehiculo.getPlacas() + "', "
                    + "'" + vehiculo.getMarca() + "', "
                    + "'" + vehiculo.getModelo() + "', "
                    + "'" + vehiculo.getTipo() + "', "
                    + vehiculo.getEjes() + ", "
                    + "'" + vehiculo.getChasis() + "', "
                    + "'" + vehiculo.getLinea() + "', "
                    + "'" + vehiculo.getColor() + "', "
                    + "'" + vehiculo.getMotor() + "', "
                    + vehiculo.getCapacidad() + ", "
                    + vehiculo.getPesoVacio() + ", "
                    + vehiculo.getEstadoIntegridad() + ", "
                    + "'" + vehiculo.getSatelite().getUsuario() + "');";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar el vehiculo.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar el vehiculo.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean editarVehiculo(Vehiculos vehiculo) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE vehiculos SET "
                    + "placa = '" + vehiculo.getPlacas() + "', "
                    + "marca = '" + vehiculo.getMarca() + "', "
                    + "modelo = '" + vehiculo.getModelo() + "', "
                    + "tipo = '" + vehiculo.getTipo() + "', "
                    + "ejes = " + vehiculo.getEjes() + ", "
                    + "chasis = '" + vehiculo.getChasis() + "', "
                    + "linea = '" + vehiculo.getLinea() + "', "
                    + "color = '" + vehiculo.getColor() + "', "
                    + "motor = '" + vehiculo.getMotor() + "', "
                    + "capacidad = " + vehiculo.getCapacidad() + ", "
                    + "pesoVacio = " + vehiculo.getPesoVacio() + ", "
                    + "estadoIntegridad = " + vehiculo.getEstadoIntegridad() + ", "
                    + "satelite = '" + vehiculo.getSatelite().getUsuario() + "'); ";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar el vehiculo");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean eliminarVehiculo(String placas) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM vehiculos WHERE placa = '" + placas + "';";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar al vehiculo.");
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public boolean eliminarVehiculo(Integer cedula) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM vehiculos WHERE propietarioCedula = " + cedula + ";";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar al vehiculo.");
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public Vehiculos buscarVehiculo(String placas) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM vehiculos WHERE correo = '" + placas + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Vehiculos vehiculo = new Vehiculos(
                    resultSet.getString("placa"),
                    resultSet.getString("marca"),
                    resultSet.getString("modelo"),
                    resultSet.getString("tipo"),
                    resultSet.getShort("ejes"),
                    resultSet.getString("chasis"),
                    resultSet.getString("linea"),
                    resultSet.getString("color"),
                    resultSet.getString("motor"),
                    resultSet.getDouble("capacidad"),
                    resultSet.getDouble("pesoVacio"),
                    resultSet.getBoolean("estadoIntegridad"),
                    (Satelites) resultSet.getObject("satelite")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return vehiculo;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla vehiculos.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Vehiculos buscarVehiculo(Integer cedula) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM vehiculos WHERE propietarioCedula = " + cedula + ";";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Vehiculos vehiculo = new Vehiculos(
                    resultSet.getString("placa"),
                    resultSet.getString("marca"),
                    resultSet.getString("modelo"),
                    resultSet.getString("tipo"),
                    resultSet.getShort("ejes"),
                    resultSet.getString("chasis"),
                    resultSet.getString("linea"),
                    resultSet.getString("color"),
                    resultSet.getString("motor"),
                    resultSet.getDouble("capacidad"),
                    resultSet.getDouble("pesoVacio"),
                    resultSet.getBoolean("estadoIntegridad"),
                    (Satelites) resultSet.getObject("satelite")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return vehiculo;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla vehiculos.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<Vehiculos> listaVehiculos() {
        List<Vehiculos> vehiculos = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM vehiculos;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Vehiculos vehiculo = new Vehiculos(
                        resultSet.getString("placa"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("tipo"),
                        resultSet.getShort("ejes"),
                        resultSet.getString("chasis"),
                        resultSet.getString("linea"),
                        resultSet.getString("color"),
                        resultSet.getString("motor"),
                        resultSet.getDouble("capacidad"),
                        resultSet.getDouble("pesoVacio"),
                        resultSet.getBoolean("estadoIntegridad"),
                        (Satelites) resultSet.getObject("satelite")
                );
                vehiculos.add(vehiculo);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla vehiculos.");

        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos;
    }

    @Override
    public int cantidadVehiculos() {
        return listaVehiculos().size();
    }

}

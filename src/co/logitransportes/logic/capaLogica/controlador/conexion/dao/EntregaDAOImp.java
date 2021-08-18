/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaLogica.controlador.conexion.ConexionMySQL;
import co.logitransportes.logic.capaModelador.Entregas;
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
public class EntregaDAOImp implements EntregaDAO {

    private final ConexionMySQL conexion;
    private EmpresaDAOImp empresaDAOImp;
    private TrabajadorDAOImp trabajadorDAOImp;
    private VehiculoDAOImp vehiculoDAOImp;

    public EntregaDAOImp() {
        this.conexion = new ConexionMySQL("localhost", 3300, "logicdb", "root", "root");
        this.empresaDAOImp = new EmpresaDAOImp();
        this.trabajadorDAOImp = new TrabajadorDAOImp();
        this.vehiculoDAOImp = new VehiculoDAOImp();
    }

    @Override
    public boolean agregarEntrega(Entregas entrega) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO entregas VALUES ("
                    + "'" + entrega.getIdEntrega() + "', "
                    + "'" + entrega.getFecha() + "', "
                    + "'" + entrega.getEstado() + "', "
                    + entrega.getEstadoIntegridad() + ", "
                    + "'" + entrega.getEmpresa().getNit() + "', "
                    + "'" + entrega.getTrabajadorIdentificacion().getIdentificacion() + "', "
                    + "'" + entrega.getVehiculoPlacas().getPlacas() + "'); ";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar la entrega.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar la entrega.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean editarEntrega(Entregas entrega) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE entrega SET "
//                    + "fecha = '" + entrega.getFecha() + "', "
//                    + "estado = " + entrega.getEstado() + ", "
//                    + "estadoIntegridad = " + entrega.getEstadoIntegridad() + ","
//                    + "trabajador_cedula = " + entrega.getTrabajadorCedula().getCedula() + ", "
                    + "empresa_nit = '" + entrega.getIdEntrega() + "';";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar la entrega.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean eliminarEntrega(String id) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM entregas WHERE idEntrega = '" + id + "';";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar la entrega.");
        } catch (SQLException ex) {
            Logger.getLogger(EntregaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public Entregas buscarEntrega(String id) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM entregas WHERE idEntrega = '" + id + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Entregas entrega = new Entregas(
                    resultSet.getString("idEntrega"),
                    resultSet.getDate("fecha"),
                    resultSet.getString("estado"),
                    resultSet.getBoolean("estadoIntegridad"),
                    empresaDAOImp.buscarEmpresa(resultSet.getString("empresa")),
                    trabajadorDAOImp.buscarTrabajador(resultSet.getString("trabajadorIdentificacion")),
                    vehiculoDAOImp.buscarVehiculo(resultSet.getString("vehiculo_placas"))
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return entrega;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla entrega.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(EntregaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Entregas> listaEntregas() {
        List<Entregas> entregas = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM entregas;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Entregas entrega = new Entregas(
                        resultSet.getString("idEntrega"),
                        resultSet.getDate("fecha"),
                        resultSet.getString("estado"),
                        resultSet.getBoolean("estadoIntegridad"),
                        empresaDAOImp.buscarEmpresa(resultSet.getString("empresa")),
                        trabajadorDAOImp.buscarTrabajador(resultSet.getString("trabajadorIdentificacion")),
                        vehiculoDAOImp.buscarVehiculo(resultSet.getString("vehiculo_placas"))
                );
                entregas.add(entrega);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla entrega.");

        } catch (SQLException ex) {
            Logger.getLogger(EntregaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entregas;
    }

    @Override
    public int cantidadEntregas() {
        return listaEntregas().size();

    }

}

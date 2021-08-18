/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaLogica.controlador.conexion.ConexionMySQL;
import co.logitransportes.logic.capaModelador.Empresas;
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
public class EmpresaDAOImp implements EmpresaDAO {

    private final ConexionMySQL conexion;

    public EmpresaDAOImp() {
        this.conexion = new ConexionMySQL("localhost", 3300, "logicdb", "root", "root");
    }

    @Override
    public boolean agregarEmpresa(Empresas empresa) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO empresas VALUES ("
                    + "'" + empresa.getNit() + "', "
                    + "'" + empresa.getNombre() + "', "
                    + empresa.getNumeroContactoCel() + ", "
                    + empresa.getNumeroContactoTel() + ", "
                    + "'" + empresa.getCiudadUbicacion() + "', "
                    + "'" + empresa.getMercanciaTransporta() + "', "
                    + empresa.getEstadoIntegridad() + "); ";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar la empresa.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar la empresa.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean editarEmpresa(Empresas empresa) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE empresas SET "
                    + "nit = '" + empresa.getNit() + "', "
                    + "nombre = '" + empresa.getNombre() + "', "
                    + "numeroContactoCel = " + empresa.getNumeroContactoCel() + ", "
                    + "numeroContactoTel = " + empresa.getNumeroContactoTel() + " ,"
                    + "ciudadUbicacion = '" + empresa.getCiudadUbicacion() + "', "
                    + "mercanciaTransporta = '" + empresa.getMercanciaTransporta() + "', "
                    + "estadoIntegridad = " + empresa.getEstadoIntegridad() + ";";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar la empresa.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }
        return actualizado;
    }

    @Override
    public boolean eliminarEmpresa(String nit) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM empresas WHERE nit = '" + nit + "';";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar la empresa.");
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public Empresas buscarEmpresa(String nit) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM empresas WHERE nit = '" + nit + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Empresas empresa = new Empresas(
                    resultSet.getString("nit"),
                    resultSet.getString("nombre"),
                    resultSet.getLong("numeroContactoCel"),
                    resultSet.getLong("numeroContacoTel"),
                    resultSet.getString("ciudadUbicacion"),
                    resultSet.getString("mercanciaTransporta"),
                    resultSet.getBoolean("estadoIntegridad")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return empresa;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla empresa.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<Empresas> listaEmpresas() {
        List<Empresas> empresas = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM personas;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Empresas empresa = new Empresas(
                        resultSet.getString("nit"),
                        resultSet.getString("nombre"),
                        resultSet.getLong("numeroContactoCel"),
                        resultSet.getLong("numeroContacoTel"),
                        resultSet.getString("ciudadUbicacion"),
                        resultSet.getString("mercanciaTransporta"),
                        resultSet.getBoolean("estadoIntegridad")
                );
                empresas.add(empresa);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla empresa.");

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;
    }

    @Override
    public int cantidadEmpresas() {
        return listaEmpresas().size();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaLogica.controlador.conexion.ConexionMySQL;
import co.logitransportes.logic.capaModelador.Licencias;
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
public class LicenciaDAOImp implements LicenciaDAO {

    private final ConexionMySQL conexion;

    public LicenciaDAOImp() {
        this.conexion = new ConexionMySQL("localhost", 3300, "logicdb", "root", "root");
    }

    @Override
    public boolean agregarLicencia(Licencias licencia) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO licencias VALUES ("
                    + licencia.getNumeroLicencia() + ", "
                    + "'" + licencia.getCategorias() + "', "
                    + "'" + licencia.getVigencia() +  "); ";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar la licencia.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar la licencia.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean editarLicencia(Licencias licencia) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE licencias SET "
                    + "numeroLicencia = " + licencia.getNumeroLicencia() + ", "
                    + "categorias = '" + licencia.getCategorias() + "', "
                    + "vigencia = " + licencia.getVigencia() +"); ";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar la licencia.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean eliminarLicencia(Long numeroLicencia) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM licencias WHERE numeroLicencia = " + numeroLicencia + ";";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar la licencia.");
        } catch (SQLException ex) {
            Logger.getLogger(LicenciaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public Licencias buscarLicencia(Long numeroLicencia) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM licencias WHERE numeroLicencia = " + numeroLicencia + ";";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Licencias licencia = new Licencias(
                    (Long) resultSet.getLong("numeroLicencia"),
                    resultSet.getString("categorias"),
                    resultSet.getDate("vigencia")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return licencia;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla licencia.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(LicenciaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<Licencias> listaLicencias() {
        List<Licencias> licencias = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM licencias;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Licencias licencia = new Licencias(
                        resultSet.getLong("numeroLicencia"),
                        resultSet.getString("categorias"),
                        resultSet.getDate("vigencia")
                );
                licencias.add(licencia);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla licencia.");

        } catch (SQLException ex) {
            Logger.getLogger(LicenciaDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return licencias;
    }

    @Override
    public int cantidadLicencias() {
        return listaLicencias().size();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaLogica.controlador.conexion.ConexionMySQL;
import co.logitransportes.logic.capaModelador.Administrativos;
import co.logitransportes.logic.capaModelador.Conductores;
import co.logitransportes.logic.capaModelador.Trabajadores;
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
public class TrabajadorDAOImp implements TrabajadorDAO {

    private final ConexionMySQL conexion;
    private PersonaDAOImp personaDAOImp;
    private LicenciaDAOImp licenciaDAOImp;

    public TrabajadorDAOImp() {
        this.conexion = new ConexionMySQL("localhost", 3300, "logicdb", "root", "root");
        this.personaDAOImp = new PersonaDAOImp();
        this.licenciaDAOImp = new LicenciaDAOImp();
    }

    @Override
    public boolean agregarTrabajador(Trabajadores trabajador) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO trabajadores VALUES ('"
                    + trabajador.getIdentificacion().getIdentificacion() + "', "
                    + "'" + trabajador.getFechaDeExpedicion() + "', "
                    + "'" + trabajador.getLugarExpedicion() + "', "
                    + "'" + trabajador.getDireccionResidencia() + "', "
                    + "'" + trabajador.getNombreReferenciaFamiliar() + "', "
                    + "'" + trabajador.getNumeroReferenciaFamiliar() + "', "
                    + "'" + trabajador.getCiudadContacto() + "', "
                    + "'" + trabajador.getEstado() + "');";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar el trabajador.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar el trabajador.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean agregarAdministrativo(Administrativos administrativo) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO administrativos VALUES ("
                    + "'" + administrativo.getIdentificacion().getIdentificacion() + "', "
                    + "'" + administrativo.getCargo() + "');";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar el trabajador.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar el trabajador.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean agregarConductor(Conductores conductor) {
        boolean creado = false;
        try {
            this.conexion.conectar();
            String insert = "INSERT INTO conductores VALUES ("
                    + "'" + conductor.getIdentificacion().getIdentificacion() + "', "
                    + "'" + conductor.getTipoDeSangre() + "', "
                    + conductor.getEstatura() + ", "
                    + conductor.getRecordViajes() + ", "
                    + "'" + conductor.getFechaUltimoViaje() + "', "
                    + conductor.getNumeroLicencia().getNumeroLicencia() + ");";
            System.out.println(insert);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(insert);
            statement.close();
            this.conexion.disconnect();
            creado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al insertar el trabajador.");
            creado = false;
        } catch (SQLException e) {
            System.out.println("Error al insertar el trabajador.");
            creado = false;
        }
        return creado;
    }

    @Override
    public boolean editarTrabajador(Trabajadores trabajador) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE trabajadores SET "
                    + "identificacion = " + trabajador.getPersonas().getIdentificacion() + ", "
                    + "fechaExpedicion = '" + trabajador.getFechaDeExpedicion() + "', "
                    + "lugarExpedicion = '" + trabajador.getLugarExpedicion() + "', "
                    + "direccionResidencia = '" + trabajador.getDireccionResidencia() + "', "
                    + "nombreReferenciaFamiliar = '" + trabajador.getNombreReferenciaFamiliar() + "', "
                    + "numeroReferenciaFamiliar = '" + trabajador.getNumeroReferenciaFamiliar() + "', "
                    + "ciudadContacto = '" + trabajador.getCiudadContacto() + "', "
                    + "estado = '" + trabajador.getEstado() + "');";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar al trabajador.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean editarAdministrativo(Administrativos administrativo) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE administrativos SET "
                    + "identificacion = '" + administrativo.getIdentificacion().getIdentificacion() + "', "
                    + "cargo = '" + administrativo.getCargo() + "');";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar al trabajador.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean editarConductor(Conductores conductor) {
        boolean actualizado = false;
        try {
            this.conexion.conectar();
            String update = "UPDATE conductores SET "
                    + "identificacion = '" + conductor.getIdentificacion().getIdentificacion() + "', "
                    + "tipoDeSangre = '" + conductor.getIdentificacion().getIdentificacion() + "', "
                    + "estatura = " + conductor.getEstatura() + ", "
                    + "recordViajes = " + conductor.getRecordViajes() + ", "
                    + "fechaUltimoViaje = '" + conductor.getFechaUltimoViaje() + "', "
                    + "numeroLicencia = " + conductor.getNumeroLicencia().getNumeroLicencia() + ");";
            System.out.println(update);
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(update);
            statement.close();
            this.conexion.disconnect();
            actualizado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al actualizar al trabajador.");
            actualizado = false;
        } catch (SQLException e) {
            actualizado = false;
        }

        return actualizado;
    }

    @Override
    public boolean eliminarTrabajador(String identificacion) {
        boolean eliminado = false;
        try {
            this.conexion.conectar();
            String delete = "DELETE FROM trabajadores WHERE identificacion = '" + identificacion + "';";
            Statement statement = this.conexion.getCon().createStatement();
            statement.executeUpdate(delete);
            statement.close();
            this.conexion.disconnect();
            eliminado = true;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al eliminar al trabajador.");
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }

    @Override
    public Trabajadores buscarTrabajador(String identificacion) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM trabajadores WHERE identificacion = '" + identificacion + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Trabajadores trabajador = new Trabajadores(
                    personaDAOImp.buscarPersona(resultSet.getString("identificacion")),
                    resultSet.getDate("fechaDeExpedicion"),
                    resultSet.getString("lugarExpedicion"),
                    resultSet.getString("direccionResidencia"),
                    resultSet.getString("nombreReferenciaFamiliar"),
                    resultSet.getLong("numeroReferenciaFamiliar"),
                    resultSet.getString("ciudadContacto"),
                    resultSet.getString("estado")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return trabajador;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla trabajadores.");
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Administrativos buscarAdministrativo(String identificacion) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM administrativos WHERE identificacion = '" + identificacion + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Administrativos administrativo = new Administrativos(
                    personaDAOImp.buscarPersona(resultSet.getString("identificacion")),
                    resultSet.getString("cargo")
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return administrativo;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla administradores.");
            return null;
        } catch (SQLException ex) {
            System.out.println("No se encontro el dato solicitado en la tabla administradores.");
            return null;
        }
    }

    @Override
    public Conductores buscarConductor(String identificacion) {
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM conductores WHERE identificacion = '" + identificacion + "';";
            System.out.println(select);
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            resultSet.first();
            Conductores conductor = new Conductores(
                    personaDAOImp.buscarPersona(resultSet.getString("identificacion")),
                    resultSet.getString("tipoDeSangre"),
                    resultSet.getDouble("estatura"),
                    resultSet.getDouble("recordViajes"),
                    resultSet.getDate("fechaUltimoViaje"),
                    licenciaDAOImp.buscarLicencia(resultSet.getLong("numeroLicencia"))
            );
            System.out.println(select);
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
            return conductor;
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar el dato solicitado de la tabla conductores.");
            return null;
        } catch (SQLException ex) {
            System.out.println("No se encontro el dato solicitado en la tabla conductores.");
            //   Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Trabajadores> listaTrabajadores() {
        List<Trabajadores> trabajadores = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM trabajadores;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Trabajadores trabajador = new Trabajadores(
                        personaDAOImp.buscarPersona(resultSet.getString("identificacion")),
                        resultSet.getDate("fechaDeExpedicion"),
                        resultSet.getString("lugarExpedicion"),
                        resultSet.getString("direccionResidencia"),
                        resultSet.getString("nombreReferenciaFamiliar"),
                        resultSet.getLong("numeroReferenciaFamiliar"),
                        resultSet.getString("ciudadContacto"),
                        resultSet.getString("estado")
                );
                trabajadores.add(trabajador);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla trabajadores.");

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trabajadores;
    }

    @Override
    public List<Administrativos> listaAdministrativos() {
        List<Administrativos> administrativos = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM administrativos;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Administrativos administrativo = new Administrativos(
                        personaDAOImp.buscarPersona(resultSet.getString("identificacion")),
                        resultSet.getString("cargo")
                );
                administrativos.add(administrativo);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla trabajadores.");

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return administrativos;
    }

    @Override
    public List<Conductores> listaConductores() {
        List<Conductores> conductores = new ArrayList<>();
        try {
            this.conexion.conectar();
            String select = "SELECT * FROM conductores;";
            Statement statement = this.conexion.getCon().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                Conductores conductor = new Conductores(
                        personaDAOImp.buscarPersona(resultSet.getString("identificacion")),
                        resultSet.getString("tipoDeSangre"),
                        resultSet.getDouble("estatura"),
                        resultSet.getDouble("recordViajes"),
                        resultSet.getDate("fechaUltimoViaje"),
                        licenciaDAOImp.buscarLicencia(resultSet.getLong("numeroLicencia"))
                );
                conductores.add(conductor);
            }
            resultSet.close();
            statement.close();
            this.conexion.disconnect();
        } catch (SQLTimeoutException e) {
            System.out.println("Error al encontrar los datos de la tabla trabajadores.");

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conductores;
    }

    @Override
    public int cantidadTrabajadores() {
        return listaTrabajadores().size();
    }

}

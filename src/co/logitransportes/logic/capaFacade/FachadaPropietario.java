/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.conexion.dao.PropietarioDAOImp;
import co.logitransportes.logic.capaModelador.Propietarios;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaPropietario {

    private Propietarios propietario;
    private PropietarioDAOImp propietarioDAOImp;

    public FachadaPropietario() {
        this.propietario = new Propietarios();
        this.propietarioDAOImp = new PropietarioDAOImp();
    }

    public boolean registrarPropietario(Propietarios propietario) {
        return propietarioDAOImp.agregarPropietario(propietario);
    }

    public boolean editarPropietario(Propietarios propietario) {
        return propietarioDAOImp.editarPropietario(propietario);
    }

    public boolean eliminarPropietario(String identificacion) {
        return propietarioDAOImp.eliminarPropietario(identificacion);
    }
    
    public boolean eliminarPropietarioNit(String nit) {
        return propietarioDAOImp.eliminarPropietarioNit(nit);
    }

    public Propietarios buscarPropietario(String cedula) {
        return propietarioDAOImp.buscarPropietario(cedula);
    }
    
    public Propietarios buscarPropietarioNit(String nit) {
        return propietarioDAOImp.buscarPropietarioNit(nit);
    }

    public List<Propietarios> listaPropietarios() {
        return propietarioDAOImp.listaPropietarios();
    }

    public int cantidadPropietarios() {
        return propietarioDAOImp.cantidadPropietarios();
    }
}

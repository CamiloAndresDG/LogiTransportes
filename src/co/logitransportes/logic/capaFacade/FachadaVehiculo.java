/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.conexion.dao.VehiculoDAOImp;
import co.logitransportes.logic.capaModelador.Vehiculos;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaVehiculo {

    private Vehiculos vehiculo;
    private VehiculoDAOImp vehiculoDAOImp;

    public FachadaVehiculo() {
        this.vehiculo = new Vehiculos();
        this.vehiculoDAOImp = new VehiculoDAOImp();
    }

    public boolean agregarVehiculo(Vehiculos vehiculo) {
        return vehiculoDAOImp.agregarVehiculo(vehiculo);
    }

    public boolean editarVehiculo(Vehiculos vehiculo) {
        return vehiculoDAOImp.editarVehiculo(vehiculo);
    }

    public boolean eliminarVehiculo(String placas) {
        return vehiculoDAOImp.eliminarVehiculo(placas);
    }

    public boolean eliminarVehiculo(Integer cedula) {
        return vehiculoDAOImp.eliminarVehiculo(cedula);
    }

    public Vehiculos buscarVehiculo(String placas) {
        return vehiculoDAOImp.buscarVehiculo(placas);
    }

    public Vehiculos buscarVehiculo(Integer cedula) {
        return vehiculoDAOImp.buscarVehiculo(cedula);
    }

    public List<Vehiculos> listaVehiculos() {
        return vehiculoDAOImp.listaVehiculos();
    }

    public int cantidadVehiculos() {
        return vehiculoDAOImp.cantidadVehiculos();
    }

}

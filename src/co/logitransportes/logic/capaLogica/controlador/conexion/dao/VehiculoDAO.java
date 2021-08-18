/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaModelador.Vehiculos;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public interface VehiculoDAO {

    public boolean agregarVehiculo(Vehiculos vehiculo);

    public boolean editarVehiculo(Vehiculos vehiculo);

    public boolean eliminarVehiculo(String placas);

    public boolean eliminarVehiculo(Integer cedula);

    public Vehiculos buscarVehiculo(String placas);

    public Vehiculos buscarVehiculo(Integer cedula);

    public List<Vehiculos> listaVehiculos();

//    public List<Vehiculos> listaVehiculosPropietarios();

    public int cantidadVehiculos();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaModelador.Propietarios;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public interface PropietarioDAO {

    public boolean agregarPropietario(Propietarios persona);

    public boolean editarPropietario(Propietarios persona);

    public boolean eliminarPropietario(String identificacion);

    public boolean eliminarPropietarioNit(String nit);

    public Propietarios buscarPropietario(String identificacion);

    public Propietarios buscarPropietarioNit(String nit);

    public List<Propietarios> listaPropietarios();

    public int cantidadPropietarios();
}

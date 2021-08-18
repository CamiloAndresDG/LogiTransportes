/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaModelador.Administrativos;
import co.logitransportes.logic.capaModelador.Conductores;
import co.logitransportes.logic.capaModelador.Trabajadores;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public interface TrabajadorDAO {

    public boolean agregarTrabajador(Trabajadores trabajador);

    public boolean agregarAdministrativo(Administrativos administrativo);

    public boolean agregarConductor(Conductores conductor);

    public boolean editarTrabajador(Trabajadores trabajador);

    public boolean editarAdministrativo(Administrativos dministrativo);

    public boolean editarConductor(Conductores conductor);

    public boolean eliminarTrabajador(String identificacion);

    public Trabajadores buscarTrabajador(String identificacion);

    public Administrativos buscarAdministrativo(String identificacion);

    public Conductores buscarConductor(String identificacion);

    public List<Trabajadores> listaTrabajadores();

    public List<Administrativos> listaAdministrativos();

    public List<Conductores> listaConductores();

    public int cantidadTrabajadores();
}

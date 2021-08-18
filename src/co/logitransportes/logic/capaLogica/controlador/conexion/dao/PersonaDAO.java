/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaModelador.Personas;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public interface PersonaDAO {

    public boolean agregarPersona(Personas persona);

    public boolean editarPersona(Personas persona);

    public boolean eliminarPersona(String identificacion);

    public Personas buscarPersona(String identificacion);

    public List<Personas> listaPersonas();

    public int cantidadPersonas();
}

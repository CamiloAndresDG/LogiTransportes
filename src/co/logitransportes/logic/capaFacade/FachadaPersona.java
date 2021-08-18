/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.conexion.dao.PersonaDAOImp;
import co.logitransportes.logic.capaModelador.Personas;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaPersona {
    
    private Personas persona;
    private PersonaDAOImp personaDAOImp;

    public FachadaPersona() {
        this.persona = new Personas();
        this.personaDAOImp = new PersonaDAOImp();
    }

    public boolean registrarPersona(Personas persona) {
        return personaDAOImp.agregarPersona(persona);
    }

    public boolean editarPersona(Personas persona) {
        return personaDAOImp.editarPersona(persona);
    }

    public boolean eliminarPersona(String identificacion) {
        return personaDAOImp.eliminarPersona(identificacion);
    }

    public Personas buscarPersona(String identificacion) {
        return personaDAOImp.buscarPersona(identificacion);
    }

    public List<Personas> listaPersonas() {
        return personaDAOImp.listaPersonas();
    }

    public int cantidadPersonas() {
        return personaDAOImp.cantidadPersonas();
    }
}

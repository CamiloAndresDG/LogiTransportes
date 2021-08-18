/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.conexion.dao.EntregaDAOImp;
import co.logitransportes.logic.capaLogica.controlador.conexion.dao.LicenciaDAOImp;
import co.logitransportes.logic.capaModelador.Entregas;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaEntrega {
    
    private Entregas entrega;
    private EntregaDAOImp entregaDAOImp;

    public FachadaEntrega() {
        this.entrega = new Entregas();
        this.entregaDAOImp = new EntregaDAOImp();
    }

    public boolean registrarEntregas(Entregas entrega) {
        return entregaDAOImp.agregarEntrega(entrega);
    }

    public boolean editarEntregas(Entregas entrega) {
        return entregaDAOImp.editarEntrega(entrega);
    }

    public boolean eliminarEntregas(String idEntrega) {
        return entregaDAOImp.eliminarEntrega(idEntrega);
    }

    public Entregas buscarEntrega(String idEntrega) {
        return entregaDAOImp.buscarEntrega(idEntrega);
    }

    public List<Entregas> listaEntregas() {
        return entregaDAOImp.listaEntregas();
    }

    public int cantidadEntregas() {
        return entregaDAOImp.cantidadEntregas();
    }
}

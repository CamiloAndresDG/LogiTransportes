/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.conexion.dao.SateliteDAOImp;
import co.logitransportes.logic.capaModelador.Satelites;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaSatelite {
    
    private Satelites satelite;
    private SateliteDAOImp sateliteDAOImp;

    public FachadaSatelite() {
        this.satelite = new Satelites();
        this.sateliteDAOImp = new SateliteDAOImp();
    }

    public boolean registrarSatelite(Satelites satelite) {
        return sateliteDAOImp.agregarSatelite(satelite);
    }

    public boolean editarSatelite(Satelites satelite) {
        return sateliteDAOImp.editarSatelite(satelite);
    }

    public boolean eliminarSatelite(String proovedor, String correo) {
        return sateliteDAOImp.eliminarSatelite(proovedor, correo);
    }

    public Satelites buscarSatelite(String proovedor, String correo) {
        return sateliteDAOImp.buscarSatelite(proovedor, correo);
    }

    public List<Satelites> listaSatelites() {
        return sateliteDAOImp.listaSatelites();
    }

    public int cantidadSatelites() {
        return sateliteDAOImp.cantidadSatelites();
    }
}

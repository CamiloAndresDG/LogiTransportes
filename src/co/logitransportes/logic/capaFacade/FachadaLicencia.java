/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.conexion.dao.LicenciaDAOImp;
import co.logitransportes.logic.capaModelador.Licencias;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaLicencia {

    private Licencias licencia;
    private LicenciaDAOImp licenciaDAOImp;

    public FachadaLicencia() {
        this.licencia = new Licencias();
        this.licenciaDAOImp = new LicenciaDAOImp();
    }

    public boolean registrarLicencia(Licencias licencia) {
        return licenciaDAOImp.agregarLicencia(licencia);
    }

    public boolean editarLicencia(Licencias licencia) {
        return licenciaDAOImp.editarLicencia(licencia);
    }

    public boolean eliminarLicencia(Long numeroLicencia) {
        return licenciaDAOImp.eliminarLicencia(numeroLicencia);
    }

    public Licencias buscarLicencia(Long numeroLicencia) {
        return licenciaDAOImp.buscarLicencia(numeroLicencia);
    }

    public List<Licencias> listaLicencias() {
        return licenciaDAOImp.listaLicencias();
    }

    public int cantidadLicencias() {
        return licenciaDAOImp.cantidadLicencias();
    }
}

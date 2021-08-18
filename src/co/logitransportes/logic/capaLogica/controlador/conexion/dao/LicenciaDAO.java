/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaModelador.Licencias;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public interface LicenciaDAO {

    public boolean agregarLicencia(Licencias licencia);

    public boolean editarLicencia(Licencias licencia);

    public boolean eliminarLicencia(Long numeroLicencia);

    public Licencias buscarLicencia(Long numeroLicencia);

    public List<Licencias> listaLicencias();

    public int cantidadLicencias();
}

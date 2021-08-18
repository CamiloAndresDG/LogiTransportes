/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.conexion.dao.EmpresaDAOImp;
import co.logitransportes.logic.capaModelador.Empresas;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaEmpresa {

    private Empresas empresa;
    private EmpresaDAOImp empresaDAOImp;

    public FachadaEmpresa() {
        this.empresa = new Empresas();
        this.empresaDAOImp = new EmpresaDAOImp();
    }

    public boolean registrarEmpresa(Empresas empresa) {
        return empresaDAOImp.agregarEmpresa(empresa);
    }

    public boolean editarEmpresa(Empresas empresa) {
        return empresaDAOImp.editarEmpresa(empresa);
    }

    public boolean eliminarEmpresa(String nit) {
        return empresaDAOImp.eliminarEmpresa(nit);
    }

    public Empresas buscarEmpresa(String nit) {
        return empresaDAOImp.buscarEmpresa(nit);
    }

    public List<Empresas> listaEmpresas() {
        return empresaDAOImp.listaEmpresas();
    }

    public int cantidadEmpresas() {
        return empresaDAOImp.cantidadEmpresas();
    }
}

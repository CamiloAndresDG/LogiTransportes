/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaModelador.Empresas;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public interface EmpresaDAO {

    public boolean agregarEmpresa(Empresas empresa);

    public boolean editarEmpresa(Empresas persona);

    public boolean eliminarEmpresa(String nit);

    public Empresas buscarEmpresa(String nit);

    public List<Empresas> listaEmpresas();

    public int cantidadEmpresas();
}

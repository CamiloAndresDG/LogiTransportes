/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaModelador.Entregas;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public interface EntregaDAO  {
    
    public boolean agregarEntrega(Entregas entrega);

    public boolean editarEntrega(Entregas entrega);

    public boolean eliminarEntrega(String id);

    public Entregas buscarEntrega(String id);

    public List<Entregas> listaEntregas();

    public int cantidadEntregas();
}

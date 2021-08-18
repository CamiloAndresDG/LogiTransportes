/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.conexion.dao;

import co.logitransportes.logic.capaModelador.Satelites;
import java.util.List;

/**
 *
 * @author Camilo y Roberth
 */
public interface SateliteDAO {

    public boolean agregarSatelite(Satelites satelite);

    public boolean editarSatelite(Satelites satelite);

    public boolean eliminarSatelite(String proovedor, String correo);

    public Satelites buscarSatelite(String proovedor, String correo);

    public List<Satelites> listaSatelites();

    public int cantidadSatelites();
}

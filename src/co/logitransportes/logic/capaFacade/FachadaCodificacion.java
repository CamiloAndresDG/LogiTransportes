/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.codificacion.ControladorCifrado;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaCodificacion {

    private ControladorCifrado controladorCifrado;

    public FachadaCodificacion() {
        this.controladorCifrado = new ControladorCifrado();
    }

    public String codificacion(String mensajeACodificar) throws UnsupportedEncodingException {
        return controladorCifrado.codificar(mensajeACodificar);
    }

}

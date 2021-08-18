/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaLogica.controlador.codificacion;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import static org.apache.commons.codec.digest.DigestUtils.md5;


/*
Modulo Vigenere para RiCrypt

Cifrado por sustitucion usando sumas y restas modulares en el alfabeto
normal pero altercadas con una semilla como palabra.

Phicar
project-ric.org
phicar@yashira.org
 */
public class ControladorCifrado {

    /**
     * Metodo para codificar la cadena ingresada
     *
     * @param cadena que sera cifrada
     * @return cadena cifrada
     */
    public String codificar(String cadena) throws UnsupportedEncodingException {
        String encript = "";
        try {
            encript = DigestUtils.md5Hex(Base64.getEncoder().encodeToString(cadena.getBytes("utf-8")));
//            encript = DigestUtils.md5Hex(cadena);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Salio mal" + ex);
        }
        return encript;
    }

    //TERMINAR
    private static String desencriptar(String s) throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.logitransportes.logic.capaFacade;

import co.logitransportes.logic.capaLogica.controlador.conexion.dao.TrabajadorDAOImp;
import co.logitransportes.logic.capaModelador.Administrativos;
import co.logitransportes.logic.capaModelador.Conductores;
import co.logitransportes.logic.capaModelador.Trabajadores;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo y Roberth
 */
public class FachadaTrabajador {

    private Trabajadores trabajador;
    private TrabajadorDAOImp trabajadorDAOImp;

    public FachadaTrabajador() {
        this.trabajador = new Trabajadores();
        this.trabajadorDAOImp = new TrabajadorDAOImp();
    }

    public boolean registrarTrabajador(Trabajadores trabajador, Object objeto) {
        if (trabajadorDAOImp.agregarTrabajador(trabajador)) {
            System.out.println(objeto.getClass());
            if (objeto.getClass() == Administrativos.class) {
                trabajadorDAOImp.agregarAdministrativo((Administrativos) objeto);
            } else if (objeto.getClass() == Conductores.class) {
                trabajadorDAOImp.agregarConductor((Conductores) objeto);
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el nuevo trabajador.");
            return false;
        }
    }

    public boolean editarTrabajador(Trabajadores trabajador) {
        return trabajadorDAOImp.editarTrabajador(trabajador);
    }

    public boolean editarAdministrativo(Administrativos administrativo) {
        return trabajadorDAOImp.editarAdministrativo(administrativo);
    }

    public boolean editarConductor(Conductores conductor) {
        return trabajadorDAOImp.editarConductor(conductor);
    }

    public boolean eliminarTrabajador(String identificacion) {
        return trabajadorDAOImp.eliminarTrabajador(identificacion);
    }

    public Trabajadores buscarTrabajador(String identificacion) {
        return trabajadorDAOImp.buscarTrabajador(identificacion);
    }

    public Administrativos buscarAdministrativo(String identificacion) {
        return trabajadorDAOImp.buscarAdministrativo(identificacion);
    }

    public Conductores buscarConductor(String identificacion) {
        return trabajadorDAOImp.buscarConductor(identificacion);
    }

    public List<Trabajadores> listaTrabajadores() {
        return trabajadorDAOImp.listaTrabajadores();
    }

    public List<Administrativos> listaAdministrativos() {
        return trabajadorDAOImp.listaAdministrativos();
    }

    public List<Conductores> listaConductores() {
        return trabajadorDAOImp.listaConductores();
    }

    public int cantidadTrabajadors() {
        return trabajadorDAOImp.cantidadTrabajadores();
    }
}

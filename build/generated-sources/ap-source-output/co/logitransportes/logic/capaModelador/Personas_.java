package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Clientes;
import co.logitransportes.logic.capaModelador.Propietarios;
import co.logitransportes.logic.capaModelador.Trabajadores;
import co.logitransportes.logic.capaModelador.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Personas.class)
public class Personas_ { 

    public static volatile SingularAttribute<Personas, String> apellidos;
    public static volatile SingularAttribute<Personas, Propietarios> propietarios;
    public static volatile ListAttribute<Personas, Usuarios> usuariosList;
    public static volatile SingularAttribute<Personas, Trabajadores> trabajadores;
    public static volatile SingularAttribute<Personas, Long> celularContacto;
    public static volatile SingularAttribute<Personas, Boolean> estadoIntegridad;
    public static volatile SingularAttribute<Personas, String> identificacion;
    public static volatile SingularAttribute<Personas, Long> telefonoContacto;
    public static volatile SingularAttribute<Personas, Clientes> clientes;
    public static volatile SingularAttribute<Personas, String> nombres;

}
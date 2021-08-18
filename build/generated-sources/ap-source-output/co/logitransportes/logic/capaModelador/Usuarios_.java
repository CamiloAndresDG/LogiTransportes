package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Cambios;
import co.logitransportes.logic.capaModelador.Personas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile ListAttribute<Usuarios, Cambios> cambiosList;
    public static volatile SingularAttribute<Usuarios, String> correo;
    public static volatile SingularAttribute<Usuarios, String> nickname;
    public static volatile SingularAttribute<Usuarios, String> contrasenia;
    public static volatile SingularAttribute<Usuarios, Personas> identificacion;

}
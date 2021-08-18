package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Personas;
import co.logitransportes.logic.capaModelador.Trabajadores;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Administrativos.class)
public class Administrativos_ { 

    public static volatile SingularAttribute<Administrativos, Trabajadores> trabajadores;
    public static volatile SingularAttribute<Administrativos, Personas> identificacion;
    public static volatile SingularAttribute<Administrativos, String> cargo;

}
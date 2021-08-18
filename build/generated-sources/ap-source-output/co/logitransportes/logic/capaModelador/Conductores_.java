package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Licencias;
import co.logitransportes.logic.capaModelador.Personas;
import co.logitransportes.logic.capaModelador.Trabajadores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Conductores.class)
public class Conductores_ { 

    public static volatile SingularAttribute<Conductores, Trabajadores> trabajadores;
    public static volatile SingularAttribute<Conductores, String> tipoDeSangre;
    public static volatile SingularAttribute<Conductores, Double> estatura;
    public static volatile SingularAttribute<Conductores, Personas> identificacion;
    public static volatile SingularAttribute<Conductores, Date> fechaUltimoViaje;
    public static volatile SingularAttribute<Conductores, Double> recordViajes;
    public static volatile SingularAttribute<Conductores, Licencias> numeroLicencia;

}
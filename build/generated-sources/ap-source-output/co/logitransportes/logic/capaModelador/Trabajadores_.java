package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Administrativos;
import co.logitransportes.logic.capaModelador.Conductores;
import co.logitransportes.logic.capaModelador.Entregas;
import co.logitransportes.logic.capaModelador.Personas;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Trabajadores.class)
public class Trabajadores_ { 

    public static volatile SingularAttribute<Trabajadores, String> lugarExpedicion;
    public static volatile SingularAttribute<Trabajadores, Long> numeroReferenciaFamiliar;
    public static volatile SingularAttribute<Trabajadores, Date> fechaDeExpedicion;
    public static volatile SingularAttribute<Trabajadores, String> estado;
    public static volatile SingularAttribute<Trabajadores, Conductores> conductores;
    public static volatile SingularAttribute<Trabajadores, String> nombreReferenciaFamiliar;
    public static volatile SingularAttribute<Trabajadores, String> direccionResidencia;
    public static volatile SingularAttribute<Trabajadores, String> ciudadContacto;
    public static volatile SingularAttribute<Trabajadores, Personas> identificacion;
    public static volatile ListAttribute<Trabajadores, Entregas> entregasList;
    public static volatile SingularAttribute<Trabajadores, Administrativos> administrativos;
    public static volatile SingularAttribute<Trabajadores, Personas> personas;

}
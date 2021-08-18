package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Conductores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Licencias.class)
public class Licencias_ { 

    public static volatile SingularAttribute<Licencias, Date> vigencia;
    public static volatile SingularAttribute<Licencias, String> categorias;
    public static volatile ListAttribute<Licencias, Conductores> conductoresList;
    public static volatile SingularAttribute<Licencias, Long> numeroLicencia;

}
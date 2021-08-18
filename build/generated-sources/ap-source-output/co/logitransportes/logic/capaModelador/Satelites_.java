package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Vehiculos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Satelites.class)
public class Satelites_ { 

    public static volatile SingularAttribute<Satelites, String> clave;
    public static volatile SingularAttribute<Satelites, String> proovedor;
    public static volatile SingularAttribute<Satelites, Boolean> estadoIntegridad;
    public static volatile SingularAttribute<Satelites, String> usuario;
    public static volatile ListAttribute<Satelites, Vehiculos> vehiculosList;

}
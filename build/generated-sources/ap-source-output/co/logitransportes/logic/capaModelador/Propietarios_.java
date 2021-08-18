package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Personas;
import co.logitransportes.logic.capaModelador.Vehiculos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Propietarios.class)
public class Propietarios_ { 

    public static volatile SingularAttribute<Propietarios, String> cuentaBancaria;
    public static volatile SingularAttribute<Propietarios, String> nit;
    public static volatile SingularAttribute<Propietarios, Personas> identificacion;
    public static volatile ListAttribute<Propietarios, Vehiculos> vehiculosList;
    public static volatile SingularAttribute<Propietarios, Personas> personas;

}
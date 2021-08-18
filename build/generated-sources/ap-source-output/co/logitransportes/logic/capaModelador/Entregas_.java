package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Empresas;
import co.logitransportes.logic.capaModelador.Trabajadores;
import co.logitransportes.logic.capaModelador.Vehiculos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Entregas.class)
public class Entregas_ { 

    public static volatile SingularAttribute<Entregas, Date> fecha;
    public static volatile SingularAttribute<Entregas, String> estado;
    public static volatile SingularAttribute<Entregas, Boolean> estadoIntegridad;
    public static volatile SingularAttribute<Entregas, Trabajadores> trabajadorIdentificacion;
    public static volatile SingularAttribute<Entregas, Empresas> empresa;
    public static volatile SingularAttribute<Entregas, Vehiculos> vehiculoPlacas;
    public static volatile SingularAttribute<Entregas, String> idEntrega;

}
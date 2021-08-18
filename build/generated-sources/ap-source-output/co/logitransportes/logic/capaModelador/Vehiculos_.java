package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Entregas;
import co.logitransportes.logic.capaModelador.Propietarios;
import co.logitransportes.logic.capaModelador.Satelites;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Vehiculos.class)
public class Vehiculos_ { 

    public static volatile SingularAttribute<Vehiculos, String> motor;
    public static volatile SingularAttribute<Vehiculos, String> tipo;
    public static volatile ListAttribute<Vehiculos, Propietarios> propietariosList;
    public static volatile SingularAttribute<Vehiculos, String> color;
    public static volatile SingularAttribute<Vehiculos, Boolean> estadoIntegridad;
    public static volatile SingularAttribute<Vehiculos, Double> pesoVacio;
    public static volatile ListAttribute<Vehiculos, Entregas> entregasList;
    public static volatile SingularAttribute<Vehiculos, String> modelo;
    public static volatile SingularAttribute<Vehiculos, String> placas;
    public static volatile SingularAttribute<Vehiculos, String> linea;
    public static volatile SingularAttribute<Vehiculos, String> marca;
    public static volatile SingularAttribute<Vehiculos, String> chasis;
    public static volatile SingularAttribute<Vehiculos, Satelites> satelite;
    public static volatile SingularAttribute<Vehiculos, Short> ejes;
    public static volatile SingularAttribute<Vehiculos, Double> capacidad;

}
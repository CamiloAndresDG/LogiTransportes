package co.logitransportes.logic.capaModelador;

import co.logitransportes.logic.capaModelador.Clientes;
import co.logitransportes.logic.capaModelador.Entregas;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-04T23:20:55")
@StaticMetamodel(Empresas.class)
public class Empresas_ { 

    public static volatile SingularAttribute<Empresas, Boolean> estadoIntegridad;
    public static volatile ListAttribute<Empresas, Clientes> clientesList;
    public static volatile SingularAttribute<Empresas, Long> numeroContactoCel;
    public static volatile SingularAttribute<Empresas, String> nit;
    public static volatile SingularAttribute<Empresas, String> ciudadUbicacion;
    public static volatile SingularAttribute<Empresas, String> mercanciaTransporta;
    public static volatile SingularAttribute<Empresas, Long> numeroContactoTel;
    public static volatile ListAttribute<Empresas, Entregas> entregasList;
    public static volatile SingularAttribute<Empresas, String> nombre;

}
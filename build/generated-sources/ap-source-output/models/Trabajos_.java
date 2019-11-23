package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Actulisaciones;
import models.Clientes;
import models.Producto;
import models.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-17T09:54:29")
@StaticMetamodel(Trabajos.class)
public class Trabajos_ { 

    public static volatile SingularAttribute<Trabajos, Long> total;
    public static volatile CollectionAttribute<Trabajos, Actulisaciones> actulisacionesCollection;
    public static volatile SingularAttribute<Trabajos, Integer> estatus;
    public static volatile SingularAttribute<Trabajos, Usuarios> idusuarios;
    public static volatile SingularAttribute<Trabajos, Date> fechaEntrega;
    public static volatile SingularAttribute<Trabajos, Integer> idTrabajos;
    public static volatile SingularAttribute<Trabajos, Date> fechaEstimada;
    public static volatile SingularAttribute<Trabajos, Producto> idProducto;
    public static volatile SingularAttribute<Trabajos, Clientes> idClientes;
    public static volatile SingularAttribute<Trabajos, Date> fechaRecepcion;

}
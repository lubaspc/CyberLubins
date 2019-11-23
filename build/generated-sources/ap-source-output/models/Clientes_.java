package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Trabajos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-17T09:54:29")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> direccion;
    public static volatile SingularAttribute<Clientes, String> telefono;
    public static volatile SingularAttribute<Clientes, String> nombre;
    public static volatile CollectionAttribute<Clientes, Trabajos> trabajosCollection;
    public static volatile SingularAttribute<Clientes, Integer> idClientes;

}
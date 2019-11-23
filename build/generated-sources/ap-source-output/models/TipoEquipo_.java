package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-17T09:54:29")
@StaticMetamodel(TipoEquipo.class)
public class TipoEquipo_ { 

    public static volatile SingularAttribute<TipoEquipo, String> tipo;
    public static volatile CollectionAttribute<TipoEquipo, Producto> productoCollection;
    public static volatile SingularAttribute<TipoEquipo, Integer> idtipoEquipo;

}
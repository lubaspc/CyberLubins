package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Actulisaciones;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-17T09:54:29")
@StaticMetamodel(Reparaciones.class)
public class Reparaciones_ { 

    public static volatile SingularAttribute<Reparaciones, String> descripcion;
    public static volatile CollectionAttribute<Reparaciones, Actulisaciones> actulisacionesCollection;
    public static volatile SingularAttribute<Reparaciones, Integer> idReparaciones;
    public static volatile SingularAttribute<Reparaciones, Long> costo;
    public static volatile SingularAttribute<Reparaciones, String> duracion;

}
package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Reparaciones;
import models.Trabajos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-17T09:54:29")
@StaticMetamodel(Actulisaciones.class)
public class Actulisaciones_ { 

    public static volatile SingularAttribute<Actulisaciones, String> descripcion;
    public static volatile SingularAttribute<Actulisaciones, Long> presupuesto;
    public static volatile SingularAttribute<Actulisaciones, Integer> idactulisaciones;
    public static volatile SingularAttribute<Actulisaciones, Reparaciones> idreparaciones;
    public static volatile SingularAttribute<Actulisaciones, Trabajos> idTrabajos;

}
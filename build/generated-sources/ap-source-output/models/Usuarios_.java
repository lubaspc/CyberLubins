package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Trabajos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-17T09:54:29")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, Integer> idusuarios;
    public static volatile SingularAttribute<Usuarios, String> correo;
    public static volatile SingularAttribute<Usuarios, String> tipoUsr;
    public static volatile SingularAttribute<Usuarios, Integer> nombre;
    public static volatile CollectionAttribute<Usuarios, Trabajos> trabajosCollection;

}
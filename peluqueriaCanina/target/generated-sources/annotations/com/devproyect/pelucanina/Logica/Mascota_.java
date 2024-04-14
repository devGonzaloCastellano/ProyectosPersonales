package com.devproyect.pelucanina.Logica;

import com.devproyect.pelucanina.Logica.Amo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-14T13:14:58", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Mascota.class)
public class Mascota_ { 

    public static volatile SingularAttribute<Mascota, String> raza;
    public static volatile SingularAttribute<Mascota, String> color;
    public static volatile SingularAttribute<Mascota, String> alergico;
    public static volatile SingularAttribute<Mascota, String> atEspecial;
    public static volatile SingularAttribute<Mascota, String> Observaciones;
    public static volatile SingularAttribute<Mascota, Amo> unAmo;
    public static volatile SingularAttribute<Mascota, Integer> numCliente;
    public static volatile SingularAttribute<Mascota, String> nombre;

}
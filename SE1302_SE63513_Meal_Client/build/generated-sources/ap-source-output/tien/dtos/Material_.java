package tien.dtos;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tien.dtos.FoodMaterial;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-16T02:25:16")
@StaticMetamodel(Material.class)
public class Material_ { 

    public static volatile SingularAttribute<Material, Double> carbonhydrate;
    public static volatile SingularAttribute<Material, Double> fiber;
    public static volatile SingularAttribute<Material, String> foodname;
    public static volatile CollectionAttribute<Material, FoodMaterial> foodMaterialCollection;
    public static volatile SingularAttribute<Material, Double> protein;
    public static volatile SingularAttribute<Material, Double> fat;
    public static volatile SingularAttribute<Material, Integer> id;
    public static volatile SingularAttribute<Material, Double> calories;

}
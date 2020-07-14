package tien.webservice;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tien.webservice.Food;
import tien.webservice.Material;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T13:07:37")
@StaticMetamodel(FoodMaterial.class)
public class FoodMaterial_ { 

    public static volatile SingularAttribute<FoodMaterial, Food> foodID;
    public static volatile SingularAttribute<FoodMaterial, Integer> id;
    public static volatile SingularAttribute<FoodMaterial, Material> materialID;

}
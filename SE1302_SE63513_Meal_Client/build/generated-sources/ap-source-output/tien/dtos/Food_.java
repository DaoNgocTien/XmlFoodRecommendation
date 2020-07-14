package tien.dtos;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tien.dtos.CustomerRecommendationFood;
import tien.dtos.FoodMaterial;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T13:07:55")
@StaticMetamodel(Food.class)
public class Food_ { 

    public static volatile SingularAttribute<Food, String> image;
    public static volatile SingularAttribute<Food, Double> fiber;
    public static volatile SingularAttribute<Food, String> src;
    public static volatile SingularAttribute<Food, Double> calories;
    public static volatile SingularAttribute<Food, String> title;
    public static volatile SingularAttribute<Food, String> materialDescription;
    public static volatile SingularAttribute<Food, Double> carbonhydrate;
    public static volatile CollectionAttribute<Food, CustomerRecommendationFood> customerRecommendationFoodCollection;
    public static volatile CollectionAttribute<Food, FoodMaterial> foodMaterialCollection;
    public static volatile SingularAttribute<Food, String> cookingMethod;
    public static volatile SingularAttribute<Food, Double> protein;
    public static volatile SingularAttribute<Food, Double> fat;
    public static volatile SingularAttribute<Food, Integer> id;
    public static volatile SingularAttribute<Food, String> href;

}
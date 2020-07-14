package tien.dtos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tien.dtos.Customer;
import tien.dtos.Food;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T13:07:55")
@StaticMetamodel(CustomerRecommendationFood.class)
public class CustomerRecommendationFood_ { 

    public static volatile SingularAttribute<CustomerRecommendationFood, String> mealTime;
    public static volatile SingularAttribute<CustomerRecommendationFood, Food> foodID;
    public static volatile SingularAttribute<CustomerRecommendationFood, Customer> customerID;
    public static volatile SingularAttribute<CustomerRecommendationFood, Integer> id;

}
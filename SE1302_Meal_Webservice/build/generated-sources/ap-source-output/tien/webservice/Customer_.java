package tien.webservice;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tien.webservice.CustomerComment;
import tien.webservice.CustomerRecommendationFood;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-14T13:07:37")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile CollectionAttribute<Customer, CustomerRecommendationFood> customerRecommendationFoodCollection;
    public static volatile CollectionAttribute<Customer, CustomerComment> customerCommentCollection;
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, Integer> subscription;
    public static volatile SingularAttribute<Customer, String> fullname;
    public static volatile SingularAttribute<Customer, String> email;

}
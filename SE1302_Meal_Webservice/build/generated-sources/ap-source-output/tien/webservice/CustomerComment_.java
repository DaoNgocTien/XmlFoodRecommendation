package tien.webservice;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tien.webservice.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-16T10:43:01")
@StaticMetamodel(CustomerComment.class)
public class CustomerComment_ { 

    public static volatile SingularAttribute<CustomerComment, Customer> customerID;
    public static volatile SingularAttribute<CustomerComment, String> comment;
    public static volatile SingularAttribute<CustomerComment, Integer> id;
    public static volatile SingularAttribute<CustomerComment, Date> createDate;

}
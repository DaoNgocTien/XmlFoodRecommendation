/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.utils;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class ConstantsWebServiceWareHouse implements Serializable {

    public final String WEB_SERVICE_BASE_URI = "http://localhost:8080/SE1302_Meal_Webservice/webresources";
    public final String GET_ALL_FOOD = "tien.webservice.food";
    public final String CALCULATE_FOOD = "tien.webservice.food/calculateFood";
    public final String GET_ALL_MATERIAL = "tien.webservice.material";
    public final String SEARCH_MATERIAL = "tien.webservice.material/searchFoodByLikeName";
    public final String SUBSCRIPTION = "/tien.webservice.customer/createNewCustomer";

    public ConstantsWebServiceWareHouse() {
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.controllers;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import tien.daos.FoodDAO;
import tien.service.kitchenart.MaterialComparation;
import tien.webservice.Food;
import tien.webservice.Material;

/**
 *
 * @author Admin
 */
public class CalculateFoodController implements Serializable {

    public static void calculateFoodEnergy(List<Material> listMaterial, List<String> listMaterialForCooking, Food food) throws ClassNotFoundException, SQLException {
        try {
            Food newFood = null;
            //  compare with material in database, than insert material for food, than return new food with calculated energy
            for (String string : listMaterialForCooking) {
                newFood = MaterialComparation.compareMaterial(listMaterial, string, food);
            }
            
            //  update new Food
            FoodDAO dao = new FoodDAO();
            dao.updateFood(newFood);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.dtos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "CustomerRecommendationFood", catalog = "MealRecommendation", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerRecommendationFood.findAll", query = "SELECT c FROM CustomerRecommendationFood c")
    , @NamedQuery(name = "CustomerRecommendationFood.findById", query = "SELECT c FROM CustomerRecommendationFood c WHERE c.id = :id")
    , @NamedQuery(name = "CustomerRecommendationFood.findByMealTime", query = "SELECT c FROM CustomerRecommendationFood c WHERE c.mealTime = :mealTime")})
public class CustomerRecommendationFood implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "mealTime", length = 50)
    private String mealTime;
    @JoinColumn(name = "customerID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerID;
    @JoinColumn(name = "foodID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Food foodID;

    public CustomerRecommendationFood() {
    }

    public CustomerRecommendationFood(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Food getFoodID() {
        return foodID;
    }

    public void setFoodID(Food foodID) {
        this.foodID = foodID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerRecommendationFood)) {
            return false;
        }
        CustomerRecommendationFood other = (CustomerRecommendationFood) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tien.dtos.CustomerRecommendationFood[ id=" + id + " ]";
    }
    
}

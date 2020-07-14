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
@Table(name = "FoodMaterial", catalog = "MealRecommendation", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FoodMaterial.findAll", query = "SELECT f FROM FoodMaterial f")
    , @NamedQuery(name = "FoodMaterial.findById", query = "SELECT f FROM FoodMaterial f WHERE f.id = :id")})
public class FoodMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JoinColumn(name = "foodID", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Food foodID;
    @JoinColumn(name = "materialID", referencedColumnName = "id")
    @ManyToOne
    private Material materialID;

    public FoodMaterial() {
    }

    public FoodMaterial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Food getFoodID() {
        return foodID;
    }

    public void setFoodID(Food foodID) {
        this.foodID = foodID;
    }

    public Material getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Material materialID) {
        this.materialID = materialID;
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
        if (!(object instanceof FoodMaterial)) {
            return false;
        }
        FoodMaterial other = (FoodMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tien.dtos.FoodMaterial[ id=" + id + " ]";
    }
    
}

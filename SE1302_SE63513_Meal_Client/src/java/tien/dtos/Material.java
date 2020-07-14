/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.dtos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Material", catalog = "MealRecommendation", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.findById", query = "SELECT m FROM Material m WHERE m.id = :id")
    , @NamedQuery(name = "Material.findByFoodname", query = "SELECT m FROM Material m WHERE m.foodname = :foodname")
    , @NamedQuery(name = "Material.findByCarbonhydrate", query = "SELECT m FROM Material m WHERE m.carbonhydrate = :carbonhydrate")
    , @NamedQuery(name = "Material.findByFiber", query = "SELECT m FROM Material m WHERE m.fiber = :fiber")
    , @NamedQuery(name = "Material.findByFat", query = "SELECT m FROM Material m WHERE m.fat = :fat")
    , @NamedQuery(name = "Material.findByProtein", query = "SELECT m FROM Material m WHERE m.protein = :protein")
    , @NamedQuery(name = "Material.findByCalories", query = "SELECT m FROM Material m WHERE m.calories = :calories")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "foodname", length = 2147483647)
    private String foodname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "carbonhydrate", precision = 53)
    private Double carbonhydrate;
    @Column(name = "fiber", precision = 53)
    private Double fiber;
    @Column(name = "fat", precision = 53)
    private Double fat;
    @Column(name = "protein", precision = 53)
    private Double protein;
    @Column(name = "calories", precision = 53)
    private Double calories;
    @OneToMany(mappedBy = "materialID")
    private Collection<FoodMaterial> foodMaterialCollection;

    public Material() {
    }

    public Material(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Double getCarbonhydrate() {
        return carbonhydrate;
    }

    public void setCarbonhydrate(Double carbonhydrate) {
        this.carbonhydrate = carbonhydrate;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @XmlTransient
    public Collection<FoodMaterial> getFoodMaterialCollection() {
        return foodMaterialCollection;
    }

    public void setFoodMaterialCollection(Collection<FoodMaterial> foodMaterialCollection) {
        this.foodMaterialCollection = foodMaterialCollection;
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
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tien.dtos.Material[ id=" + id + " ]";
    }
    
}

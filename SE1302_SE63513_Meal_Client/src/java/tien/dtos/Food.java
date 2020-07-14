/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.dtos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Food", catalog = "MealRecommendation", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Food.findAll", query = "SELECT f FROM Food f")
    , @NamedQuery(name = "Food.findById", query = "SELECT f FROM Food f WHERE f.id = :id")
    , @NamedQuery(name = "Food.findByHref", query = "SELECT f FROM Food f WHERE f.href = :href")
    , @NamedQuery(name = "Food.findBySrc", query = "SELECT f FROM Food f WHERE f.src = :src")
    , @NamedQuery(name = "Food.findByImage", query = "SELECT f FROM Food f WHERE f.image = :image")
    , @NamedQuery(name = "Food.findByTitle", query = "SELECT f FROM Food f WHERE f.title = :title")
    , @NamedQuery(name = "Food.findByCookingMethod", query = "SELECT f FROM Food f WHERE f.cookingMethod = :cookingMethod")
    , @NamedQuery(name = "Food.findByMaterialDescription", query = "SELECT f FROM Food f WHERE f.materialDescription = :materialDescription")
    , @NamedQuery(name = "Food.findByCarbonhydrate", query = "SELECT f FROM Food f WHERE f.carbonhydrate = :carbonhydrate")
    , @NamedQuery(name = "Food.findByFiber", query = "SELECT f FROM Food f WHERE f.fiber = :fiber")
    , @NamedQuery(name = "Food.findByFat", query = "SELECT f FROM Food f WHERE f.fat = :fat")
    , @NamedQuery(name = "Food.findByProtein", query = "SELECT f FROM Food f WHERE f.protein = :protein")
    , @NamedQuery(name = "Food.findByCalories", query = "SELECT f FROM Food f WHERE f.calories = :calories")})
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "href", length = 2147483647)
    private String href;
    @Column(name = "src", length = 2147483647)
    private String src;
    @Column(name = "image", length = 2147483647)
    private String image;
    @Column(name = "title", length = 2147483647)
    private String title;
    @Column(name = "cookingMethod", length = 2147483647)
    private String cookingMethod;
    @Column(name = "materialDescription", length = 2147483647)
    private String materialDescription;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodID")
    private Collection<CustomerRecommendationFood> customerRecommendationFoodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodID")
    private Collection<FoodMaterial> foodMaterialCollection;

    public Food() {
    }

    public Food(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCookingMethod() {
        return cookingMethod;
    }

    public void setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
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
    public Collection<CustomerRecommendationFood> getCustomerRecommendationFoodCollection() {
        return customerRecommendationFoodCollection;
    }

    public void setCustomerRecommendationFoodCollection(Collection<CustomerRecommendationFood> customerRecommendationFoodCollection) {
        this.customerRecommendationFoodCollection = customerRecommendationFoodCollection;
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
        if (!(object instanceof Food)) {
            return false;
        }
        Food other = (Food) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tien.dtos.Food[ id=" + id + " ]";
    }
    
}

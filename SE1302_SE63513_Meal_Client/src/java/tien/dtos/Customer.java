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
@Table(name = "Customer", catalog = "MealRecommendation", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.id = :id")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
    , @NamedQuery(name = "Customer.findBySubscription", query = "SELECT c FROM Customer c WHERE c.subscription = :subscription")
    , @NamedQuery(name = "Customer.findByFullname", query = "SELECT c FROM Customer c WHERE c.fullname = :fullname")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "email", length = 2147483647)
    private String email;
    @Column(name = "subscription")
    private Integer subscription;
    @Column(name = "fullname", length = 2147483647)
    private String fullname;
    @OneToMany(mappedBy = "customerID")
    private Collection<CustomerComment> customerCommentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private Collection<CustomerRecommendationFood> customerRecommendationFoodCollection;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSubscription() {
        return subscription;
    }

    public void setSubscription(Integer subscription) {
        this.subscription = subscription;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @XmlTransient
    public Collection<CustomerComment> getCustomerCommentCollection() {
        return customerCommentCollection;
    }

    public void setCustomerCommentCollection(Collection<CustomerComment> customerCommentCollection) {
        this.customerCommentCollection = customerCommentCollection;
    }

    @XmlTransient
    public Collection<CustomerRecommendationFood> getCustomerRecommendationFoodCollection() {
        return customerRecommendationFoodCollection;
    }

    public void setCustomerRecommendationFoodCollection(Collection<CustomerRecommendationFood> customerRecommendationFoodCollection) {
        this.customerRecommendationFoodCollection = customerRecommendationFoodCollection;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tien.dtos.Customer[ id=" + id + " ]";
    }
    
}

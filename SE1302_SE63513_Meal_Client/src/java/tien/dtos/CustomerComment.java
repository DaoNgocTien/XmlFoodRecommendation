/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "CustomerComment", catalog = "MealRecommendation", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerComment.findAll", query = "SELECT c FROM CustomerComment c")
    , @NamedQuery(name = "CustomerComment.findById", query = "SELECT c FROM CustomerComment c WHERE c.id = :id")
    , @NamedQuery(name = "CustomerComment.findByComment", query = "SELECT c FROM CustomerComment c WHERE c.comment = :comment")
    , @NamedQuery(name = "CustomerComment.findByCreateDate", query = "SELECT c FROM CustomerComment c WHERE c.createDate = :createDate")})
public class CustomerComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "comment", length = 2147483647)
    private String comment;
    @Column(name = "createDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @JoinColumn(name = "customerID", referencedColumnName = "id")
    @ManyToOne
    private Customer customerID;

    public CustomerComment() {
    }

    public CustomerComment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
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
        if (!(object instanceof CustomerComment)) {
            return false;
        }
        CustomerComment other = (CustomerComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tien.dtos.CustomerComment[ id=" + id + " ]";
    }
    
}

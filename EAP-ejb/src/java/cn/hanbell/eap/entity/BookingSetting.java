/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.hanbell.eap.entity;

import com.lightshell.comm.SuperDetailEntity;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author C0160
 */
@Entity
@Table(name = "bookingsetting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookingSetting.findAll", query = "SELECT b FROM BookingSetting b"),
    @NamedQuery(name = "BookingSetting.findById", query = "SELECT b FROM BookingSetting b WHERE b.id = :id"),
    @NamedQuery(name = "BookingSetting.findByPId", query = "SELECT b FROM BookingSetting b WHERE b.pid = :pid ORDER BY b.seq")})
public class BookingSetting extends SuperDetailEntity {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;

    public BookingSetting() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof BookingSetting)) {
            return false;
        }
        BookingSetting other = (BookingSetting) object;
        if (this.id != null && other.id != null && !this.id.equals(other.id)) {
            return false;
        }
        return Objects.equals(this.id, other.id) && this.seq == other.seq;
    }

    @Override
    public String toString() {
        return "cn.hanbell.eap.entity.BookingSetting[ id=" + id + " ]";
    }

}

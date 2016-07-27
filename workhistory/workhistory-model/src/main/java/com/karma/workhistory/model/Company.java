package com.karma.workhistory.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "company")
public class Company implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1786402057740422490L;

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE )
    private Long id;

    @Column(name = "reg_no")
    private String regNo;

    @Column(name = "reg_company_name")
    private String regCompanyName;

    @Column(name = "alias")
    private String alias;

    @Column(name = "sign_up_date")
    private Date signUpDate;

    @Column(name = "logo")
    private Blob logo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", targetEntity = Address.class)
    private List<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", targetEntity = User.class)
    private List<User> users;
    

    /**<
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the logo
     */
    public Blob getLogo() {
        return logo;
    }

    /**
     * @return the regCompanyName
     */
    public String getRegCompanyName() {
        return regCompanyName;
    }

    /**
     * @return the regNo
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * @return the signUpDate
     */
    public Date getSignUpDate() {
        return signUpDate;
    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param addresses
     *            the addresses to set
     */
    public void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @param alias
     *            the alias to set
     */
    public void setAlias(final String alias) {
        this.alias = alias;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @param logo
     *            the logo to set
     */
    public void setLogo(final Blob logo) {
        this.logo = logo;
    }

    /**
     * @param regCompanyName
     *            the regCompanyName to set
     */
    public void setRegCompanyName(final String regCompanyName) {
        this.regCompanyName = regCompanyName;
    }

    /**
     * @param regNo
     *            the regNo to set
     */
    public void setRegNo(final String regNo) {
        this.regNo = regNo;
    }

    /**
     * @param signUpDate
     *            the signUpDate to set
     */
    public void setSignUpDate(final Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    /**
     * @param users
     *            the users to set
     */
    public void setUsers(final List<User> users) {
        this.users = users;
    }
}

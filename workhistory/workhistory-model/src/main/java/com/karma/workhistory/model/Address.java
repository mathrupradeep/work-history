/**
 *
 */
package com.karma.workhistory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author pradeep
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8356769713957395161L;

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_line")
    private String firstLine;

    @Column(name = "second_line")
    private String second_line;

    @Column(name = "thrid_line")
    private String thridLine;

    @Column(name = "land_mark")
    private String landMark;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the firstLine
     */
    public String getFirstLine() {
        return firstLine;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the landMark
     */
    public String getLandMark() {
        return landMark;
    }

    /**
     * @return the pinCode
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * @return the second_line
     */
    public String getSecond_line() {
        return second_line;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * @param firstLine
     *            the firstLine to set
     */
    public void setFirstLine(final String firstLine) {
        this.firstLine = firstLine;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @param landMark
     *            the landMark to set
     */
    public void setLandMark(final String landMark) {
        this.landMark = landMark;
    }

    /**
     * @param pinCode
     *            the pinCode to set
     */
    public void setPinCode(final String pinCode) {
        this.pinCode = pinCode;
    }

    /**
     * @param second_line
     *            the second_line to set
     */
    public void setSecond_line(final String second_line) {
        this.second_line = second_line;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(final String state) {
        this.state = state;
    }

}

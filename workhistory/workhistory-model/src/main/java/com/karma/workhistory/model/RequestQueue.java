package com.karma.workhistory.model;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requestQueue")
public class RequestQueue implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6487295389126882806L;

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
   // private User user;

    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE )
    private Long id;
    
    @Column(name = "joining_date")
    private Date joiningDate;
    
    @Column(name = "relieving_date")
    private Date relievingDate;
    
    @Column(name = "relieving_letter_PDF")
    private File relievingLetterPDF;

    @Column(name = "most_recent_employer")
    private String mostRecentEmployer;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "designation")
    private String designation;

    @OneToOne(mappedBy = "informationSeeker")
    private Company informationSeeker;

    @OneToOne(mappedBy = "informationProvider")
    private Company informationProvider;

    @OneToOne
    private RequestStatus requestStatus;

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the informationSeeker
     */
    public Company getInformationSeeker() {
        return informationSeeker;
    }

    /**
     * @return the informatioProvider
     */
    public Company getInformationProvider() {
        return informationProvider;
    }

    /**
     * @return the relivingDate
     */
    public Date getRelivingDate() {
        return relievingDate;
    }

    /**
     * @return the requestStatus
     */
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * @return the salary
     */
    public Long getSalary() {
        return salary;
    }

    /**
     * @param designation
     *            the designation to set
     */
    public void setDesignation(final String designation) {
        this.designation = designation;
    }

    /**
     * @param employeeId
     *            the employeeId to set
     */
    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * @param informationSeeker
     *            the informationSeeker to set
     */
    public void setInformationSeeker(final Company informationSeeker) {
        this.informationSeeker = informationSeeker;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getRelievingDate() {
        return relievingDate;
    }

    public void setRelievingDate(Date relievingDate) {
        this.relievingDate = relievingDate;
    }

    public File getRelievingLetterPDF() {
        return relievingLetterPDF;
    }

    public void setRelievingLetterPDF(File relievingLetterPDF) {
        this.relievingLetterPDF = relievingLetterPDF;
    }

    public String getMostRecentEmployer() {
        return mostRecentEmployer;
    }

    public void setMostRecentEmployer(String mostRecentEmployer) {
        this.mostRecentEmployer = mostRecentEmployer;
    }

    public void setInformationProvider(Company informationProvider) {
        this.informationProvider = informationProvider;
    }

    /**
     * @param informationProvider
     *            the informationProvider to set
     */
    public void setInformatioProvider(final Company informationProvider) {
        this.informationProvider = informationProvider;
    }

    /**
     * @param relievingDate
     *            the relievingDate to set
     */
    public void setRelivingDate(final Date relievingDate) {
        this.relievingDate = relievingDate;
    }

    /**
     * @param requestStatus
     *            the requestStatus to set
     */
    public void setRequestStatus(final RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * @param salary
     *            the salary to set
     */
    public void setSalary(final Long salary) {
        this.salary = salary;
    }

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    } */
}

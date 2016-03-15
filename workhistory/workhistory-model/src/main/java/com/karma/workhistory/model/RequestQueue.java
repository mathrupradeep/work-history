package com.karma.workhistory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "reliving_date")
    private Date relivingDate;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "salary")
    private Long salary;

    @Column(name = "designation")
    private String designation;

    @OneToOne(mappedBy = "informationSeeker")
    private Company informationSeeker;

    @OneToOne(mappedBy = "informatioProvider")
    private Company informatioProvider;

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
    public Company getInformatioProvider() {
        return informatioProvider;
    }

    /**
     * @return the relivingDate
     */
    public Date getRelivingDate() {
        return relivingDate;
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
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
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

    /**
     * @param informatioProvider
     *            the informatioProvider to set
     */
    public void setInformatioProvider(final Company informatioProvider) {
        this.informatioProvider = informatioProvider;
    }

    /**
     * @param relivingDate
     *            the relivingDate to set
     */
    public void setRelivingDate(final Date relivingDate) {
        this.relivingDate = relivingDate;
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

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

}

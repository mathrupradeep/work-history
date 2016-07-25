package com.karma.workhistory.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request_Initiator")
public class RequestInitiator implements Serializable{
    

    /**
     * 
     */
    private static final long serialVersionUID = -5563011310690475913L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company")
    private Company company;
    
    //maybe useful in the future
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "hr_id")
    private User hrId;
    
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private User candidateId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getHrId() {
        return hrId;
    }

    public void setHrId(User hrId) {
        this.hrId = hrId;
    }
    public User getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(User candidateId) {
        this.candidateId = candidateId;
    }
    
}

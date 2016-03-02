package karma.workhistory.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Company implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1786402057740422490L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "reg_no")
    private String regNo;

    @Column(name = "reg_company_name")
    private String regCompanyName;

    @Column(name = "alias")
    private String alias;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private List<Address> addresses;

}

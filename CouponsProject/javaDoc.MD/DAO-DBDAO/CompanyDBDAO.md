

## Class CompanyDBDAO



*   java.lang.Object
*   *   DAO.CompanyDBDAO

<div>

*   <dl>

    <dt>All Implemented Interfaces:</dt>

    <dd>DAO.CompanyDAO<javaBeans.Company></dd>

    </dl>

    * * *

    <pre>public class CompanyDBDAO
    extends java.lang.Object
    implements DAO.CompanyDAO<javaBeans.Company></pre>

</div>

<div>



        ### Method Summary

       

        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait`

</div>

<div>

*   *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="CompanyDBDAO--"></a>
        *   #### CompanyDBDAO

            <pre>public CompanyDBDAO()</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="isCompanyExists-java.lang.String-java.lang.String-"></a>
        *   #### isCompanyExists

            <pre>public boolean isCompanyExists(java.lang.String email,
                                           java.lang.String password)
                                    throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>`isCompanyExists` in interface `DAO.CompanyDAO<javaBeans.Company>`</dd>

            <dt>Parameters:</dt>

            <dd>`email` - will be the costumer Email.</dd>

            <dd>`password` - customer password</dd>

            <dt>Returns:</dt>

            <dd>void</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="addCompany-javaBeans.Company-"></a>
        *   #### addCompany

            <pre>public void addCompany(javaBeans.Company company)
                            throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>`addCompany` in interface `DAO.CompanyDAO<javaBeans.Company>`</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="updateCompany-javaBeans.Company-"></a>
        *   #### updateCompany

            <pre>public void updateCompany(javaBeans.Company company)
                               throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>`updateCompany` in interface `DAO.CompanyDAO<javaBeans.Company>`</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCompany-int-"></a>
        *   #### deleteCompany

            <pre>public void deleteCompany(int companyID)
                               throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>`deleteCompany` in interface `DAO.CompanyDAO<javaBeans.Company>`</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getAllCompanies--"></a>
        *   #### getAllCompanies

            <pre>public java.util.ArrayList<javaBeans.Company> getAllCompanies()
                                                                   throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>`getAllCompanies` in interface `DAO.CompanyDAO<javaBeans.Company>`</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getOneCompany-int-"></a>
        *   #### getOneCompany

            <pre>public javaBeans.Company getOneCompany(int companyID)
                                            throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>`getOneCompany` in interface `DAO.CompanyDAO<javaBeans.Company>`</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>


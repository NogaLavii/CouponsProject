

## Interface CompanyDAO<T>

</div>

<div>

<div>

*   <dl>

    <dt>All Known Implementing Classes:</dt>

    <dd>CompanyDBDAO()</dd>

    </dl>

    * * *

    <pre>public interface CompanyDAO<T></pre>

</div>

<div>

*   *   <a name="method.summary"></a>

        ### Method Summary


</div>

<div>

*   *   <a name="method.detail"></a>

        ### Method Detail

        <a name="isCompanyExists-java.lang.String-java.lang.String-"></a>
        *   #### isCompanyExists

            <pre>boolean isCompanyExists(java.lang.String email,
                                    java.lang.String password)
                             throws java.lang.Exception</pre>

            <dl>

            <dt>Parameters:</dt>

            <dd>`email` - will be the costumer Email.</dd>

            <dd>`password` - customer password</dd>

            <dt>Returns:</dt>

            <dd>void</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception` - general exception</dd>

            </dl>

            <a name="addCompany-javaBeans.Company-"></a>
        *   #### addCompany

            <pre>void addCompany([Company](../javaBeans/Company.html "class in javaBeans") company)
                     throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="updateCompany-javaBeans.Company-"></a>
        *   #### updateCompany

            <pre>void updateCompany([Company](../javaBeans/Company.html "class in javaBeans") company)
                        throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCompany-int-"></a>
        *   #### deleteCompany

            <pre>void deleteCompany(int companyID)
                        throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getAllCompanies--"></a>
        *   #### getAllCompanies

            <pre>java.util.ArrayList<[Company](../javaBeans/Company.html "class in javaBeans")> getAllCompanies()
                                                  throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getOneCompany-int-"></a>
        *   #### getOneCompany

            <pre>[Company](../javaBeans/Company.html "class in javaBeans") getOneCompany(int companyID)
                           throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>


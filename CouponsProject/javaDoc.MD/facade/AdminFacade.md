
## Class AdminFacade

</div>

<div class="contentContainer">

*   java.lang.Object
*   *   [facade.ClientFacade](../facade/ClientFacade.html "class in facade")
    *   *   facade.AdminFacade

<div class="description">

*   * * *

   
</div>

<div class="summary">

*   *   <a name="constructor.summary"></a>

        ### Constructor Summary

       

        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait`

</div>

<div class="details">

*   *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="AdminFacade--"></a>
        *   #### AdminFacade

            <pre>public AdminFacade()</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="login-java.lang.String-java.lang.String-"></a>
        *   #### login

            <pre>public boolean login(java.lang.String email,
                                 java.lang.String password)</pre>

            <dl>

            <dt><span class="overrideSpecifyLabel">Overrides:</span></dt>

            <dd>`[login](../facade/ClientFacade.html#login-java.lang.String-java.lang.String-)` in class `[ClientFacade](../facade/ClientFacade.html "class in facade")`</dd>

            </dl>

            <a name="addCompany-javaBeans.Company-"></a>
        *   #### addCompany

            <pre>public void addCompany([Company](../javaBeans/Company.html "class in javaBeans") company)
                            throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="updateCompany-javaBeans.Company-"></a>
        *   #### updateCompany

            <pre>public void updateCompany([Company](../javaBeans/Company.html "class in javaBeans") company)
                               throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCompany-int-"></a>
        *   #### deleteCompany

            <pre>public void deleteCompany(int id)
                               throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getAllCompaniesF--"></a>
        *   #### getAllCompaniesF

            <pre>public java.util.ArrayList<[Company](../javaBeans/Company.html "class in javaBeans")> getAllCompaniesF()
                                                          throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getOneCompany-int-"></a>
        *   #### getOneCompany

            <pre>public [Company](../javaBeans/Company.html "class in javaBeans") getOneCompany(int id)
                                  throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="addCustomer-javaBeans.Customer-"></a>
        *   #### addCustomer

            <pre>public void addCustomer([Customer](../javaBeans/Customer.html "class in javaBeans") customer)
                             throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="updateCustomer-javaBeans.Customer-"></a>
        *   #### updateCustomer

            <pre>public void updateCustomer([Customer](../javaBeans/Customer.html "class in javaBeans") customer)
                                throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCustomer-int-"></a>
        *   #### deleteCustomer

            <pre>public void deleteCustomer(int id)
                                throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getAllCustomersF--"></a>
        *   #### getAllCustomersF

            <pre>public java.util.ArrayList<[Customer](../javaBeans/Customer.html "class in javaBeans")> getAllCustomersF()
                                                           throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getOneCustomer-int-"></a>
        *   #### getOneCustomer

            <pre>public [Customer](../javaBeans/Customer.html "class in javaBeans") getOneCustomer(int id)
                                    throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

</div>

</div>

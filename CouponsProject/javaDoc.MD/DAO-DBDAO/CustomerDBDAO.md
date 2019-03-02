

## Class CustomerDBDAO

</div>

<div>

*   java.lang.Object
*   *   DAO.CustomerDBDAO

<div>

*   <dl>

    <dt>All Implemented Interfaces:</dt>

    <dd>CustomerDAO()</dd>

    </dl>

    * * *

    <pre>public class CustomerDBDAO
    extends java.lang.Object
    implements CustomerDAO()</pre>

</div>

<div>

*   *   <a name="constructor.summary"></a>

       

        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait`

</div>

<div>

*   *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="CustomerDBDAO--"></a>
        *   #### CustomerDBDAO

            <pre>public CustomerDBDAO()</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="isCustomerExists-java.lang.String-java.lang.String-"></a>
        *   #### isCustomerExists

            <pre>public boolean isCustomerExists(java.lang.String email,
                                            java.lang.String password)
                                     throws java.lang.Exception</pre>

            <div>Description copied from interface: CustomerDAO()</div>

            <div>customer will let me manipulate data on the CUSTOMER table's data members on the DB</div>

            <dl>

            <dt>Specified by:</dt>

            <dd>isCustomerExists()</dd>

            <dt>Parameters:</dt>

            <dd>`email` - is the customer email address</dd>

            <dd>`password` - is the customer password</dd>

            <dt>Returns:</dt>

            <dd>void</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception` - , SQLException SQL exception is java's built in exception. used to validate data manipulation on the data base</dd>

            </dl>

            <a name="addCustomer-javaBeans.Customer-"></a>
        *   #### addCustomer

            <pre>public void addCustomer([Customer](../javaBeans/Customer.html "class in javaBeans") customer)
                             throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>addCustomer()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="updateCustomer-javaBeans.Customer-"></a>
        *   #### updateCustomer

            <pre>public void updateCustomer([Customer](../javaBeans/Customer.html "class in javaBeans") customer)
                                throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>updateCustomer)</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCustomer-int-"></a>
        *   #### deleteCustomer

            <pre>public void deleteCustomer(int customerID)
                                throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>deleteCustomer()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getAllCustomers--"></a>
        *   #### getAllCustomers

            <pre>public java.util.ArrayList<[Customer](../javaBeans/Customer.html "class in javaBeans")> getAllCustomers()
                                                          throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>getAllCustomers()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getOneCustomer-int-"></a>
        *   #### getOneCustomer

            <pre>public [Customer](../javaBeans/Customer.html "class in javaBeans") getOneCustomer(int customerID)
                                    throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>getOneCustomer()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

</div>

</div>


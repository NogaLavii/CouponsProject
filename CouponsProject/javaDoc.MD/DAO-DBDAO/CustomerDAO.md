## Interface CustomerDAO<T>

</div>

<div>

<div>

*   <dl>

    <dt>All Known Implementing Classes:</dt>

    <dd>CustomerDBDAO()</dd>

    </dl>

    * * *

    <pre>public interface CustomerDAO<T></pre>

</div>


<div>

*   *   <a name="method.detail"></a>

        ### Method Detail

        <a name="isCustomerExists-java.lang.String-java.lang.String-"></a>
        *   #### isCustomerExists

            <pre>boolean isCustomerExists(java.lang.String email,
                                     java.lang.String password)
                              throws java.lang.Exception</pre>

            <div>customer will let me manipulate data on the CUSTOMER table's data members on the DB</div>

            <dl>

            <dt>Parameters:</dt>

            <dd>`password` - is the customer password</dd>

            <dd>`email` - is the customer email address</dd>

            <dt>Returns:</dt>

            <dd>void</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception` - , SQLException SQL exception is java's built in exception.
            used to validate data manipulation on the data base</dd>

            </dl>

            <a name="addCustomer-javaBeans.Customer-"></a>
        *   #### addCustomer

            <pre>void addCustomer([Customer](../javaBeans/Customer.html "class in javaBeans") customer)
                      throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="updateCustomer-javaBeans.Customer-"></a>
        *   #### updateCustomer

            <pre>void updateCustomer([Customer](../javaBeans/Customer.html "class in javaBeans") customer)
                         throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCustomer-int-"></a>
        *   #### deleteCustomer

            <pre>void deleteCustomer(int customerID)
                         throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getAllCustomers--"></a>
        *   #### getAllCustomers

            <pre>java.util.ArrayList<[Customer](../javaBeans/Customer.html "class in javaBeans")> getAllCustomers()
                                                   throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getOneCustomer-int-"></a>
        *   #### getOneCustomer

            <pre>[Customer](../javaBeans/Customer.html "class in javaBeans") getOneCustomer(int customerID)
                             throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

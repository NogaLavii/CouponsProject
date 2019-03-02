

## Class Customer

</div>

<div>

 *  java.lang.Object
   *   javaBeans.Customer


<div>

   *   <a name="field.summary"></a>

       

        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `equals, getClass, hashCode, notify, notifyAll, wait, wait, wait`

</div>

<div>

*   *   <a name="field.detail"></a>

        ### Field Detail

        <a name="VALID_EMAIL_ADDRESS_REGEX"></a>
        *   #### VALID_EMAIL_ADDRESS_REGEX

            <pre>public static final java.util.regex.Pattern VALID_EMAIL_ADDRESS_REGEX</pre>

    *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="Customer-int-java.lang.String-java.lang.String-java.lang.String-java.lang.String-"></a>
        *   #### Customer

            <pre>public Customer(int id,
                            java.lang.String first_name,
                            java.lang.String last_name,
                            java.lang.String email,
                            java.lang.String password)
                     throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="getId--"></a>
        *   #### getId

            <pre>public int getId()</pre>

            <a name="setId-int-"></a>
        *   #### setId

            <pre>public void setId(int id)
                       throws [InvalidIDException](../exceptionHandling/InvalidIDException.html "class in exceptionHandling")</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`[InvalidIDException](../exceptionHandling/InvalidIDException.html "class in exceptionHandling")`</dd>

            </dl>

            <a name="getFirst_name--"></a>
        *   #### getFirst_name

            <pre>public java.lang.String getFirst_name()</pre>

            <a name="setFirst_name-java.lang.String-"></a>
        *   #### setFirst_name

            <pre>public void setFirst_name(java.lang.String first_name)
                               throws [ShortStringException](../exceptionHandling/ShortStringException.html "class in exceptionHandling")</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`[ShortStringException](../exceptionHandling/ShortStringException.html "class in exceptionHandling")`</dd>

            </dl>

            <a name="getLast_name--"></a>
        *   #### getLast_name

            <pre>public java.lang.String getLast_name()</pre>

            <a name="setLast_name-java.lang.String-"></a>
        *   #### setLast_name

            <pre>public void setLast_name(java.lang.String last_name)
                              throws [ShortStringException](../exceptionHandling/ShortStringException.html "class in exceptionHandling")</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`[ShortStringException](../exceptionHandling/ShortStringException.html "class in exceptionHandling")`</dd>

            </dl>

            <a name="getEmail--"></a>
        *   #### getEmail

            <pre>public java.lang.String getEmail()</pre>

            <a name="setEmail-java.lang.String-"></a>
        *   #### setEmail

            <pre>public void setEmail(java.lang.String email)
                          throws [EmailException](../exceptionHandling/EmailException.html "class in exceptionHandling")</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`[EmailException](../exceptionHandling/EmailException.html "class in exceptionHandling")`</dd>

            </dl>

            <a name="getPassword--"></a>
        *   #### getPassword

            <pre>public java.lang.String getPassword()</pre>

            <a name="setPassword-java.lang.String-"></a>
        *   #### setPassword

            <pre>public void setPassword(java.lang.String password)
                             throws [ShortStringException](../exceptionHandling/ShortStringException.html "class in exceptionHandling")</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`[ShortStringException](../exceptionHandling/ShortStringException.html "class in exceptionHandling")`</dd>

            </dl>

            <a name="toString--"></a>
        *   #### toString

            <pre>public java.lang.String toString()</pre>

            <dl>

            <dt>Overrides:</dt>

            <dd>`toString` in class `java.lang.Object`</dd>

            </dl>

            <a name="validate-java.lang.String-"></a>
        *   #### validate

            <pre>public static boolean validate(java.lang.String emailStr)</pre>

</div>


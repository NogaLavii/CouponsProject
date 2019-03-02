
## Class CustomerFacde

</div>

<div class="contentContainer">

*   java.lang.Object
*   *   [facade.ClientFacade](../facade/ClientFacade.html "class in facade")
    *   *   facade.CustomerFacde

<div class="description">

*   * * *

    <pre>public class <span class="typeNameLabel">CustomerFacde</span>
    extends [ClientFacade](../facade/ClientFacade.html "class in facade")</pre>


        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait`

</div>

<div class="details">

*   *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="CustomerFacde--"></a>
        *   #### CustomerFacde

            <pre>public CustomerFacde()</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="login-java.lang.String-java.lang.String-"></a>
        *   #### login

            <pre>public boolean login(java.lang.String email,
                                 java.lang.String password)
                          throws java.lang.Exception</pre>

            <dl>

            <dt><span class="overrideSpecifyLabel">Overrides:</span></dt>

            <dd>`[login](../facade/ClientFacade.html#login-java.lang.String-java.lang.String-)` in class `[ClientFacade](../facade/ClientFacade.html "class in facade")`</dd>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="isCouponPurchaseExists-int-int-"></a>
        *   #### isCouponPurchaseExists

            <pre>public boolean isCouponPurchaseExists(int customerID,
                                                  int couponID)
                                           throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getCouponsByCstmr-int-"></a>
        *   #### getCouponsByCstmr

            <pre>public java.util.ArrayList<[Coupon](../javaBeans/Coupon.html "class in javaBeans")> getCouponsByCstmr(int customerID)
                                                          throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

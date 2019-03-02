## Class CouponDBDAO

</div>

<div>

*   java.lang.Object
*   *   DAO.CouponDBDAO

<div>

*   <dl>

    <dt>All Implemented Interfaces:</dt>

    <dd>CouponDAO()</dd>

    </dl>

    * * *

    <pre>public class CouponDBDAO
    extends java.lang.Object
    implements [CouponDAO](../DAO/CouponDAO.html "interface in DAO")<[Coupon](../javaBeans/Coupon.html "class in javaBeans")></pre>

</div>

<div>

*   *   <a name="constructor.summary"></a>

        ### Constructor Summary

      

        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait`

</div>

<div>

*   *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="CouponDBDAO--"></a>
        *   #### CouponDBDAO

            <pre>public CouponDBDAO()</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="isCouponExists-java.lang.String-"></a>
        *   #### isCouponExists

            <pre>public boolean isCouponExists(java.lang.String title)
                                   throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>isCouponExists(), in interface CouponDAO()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="addCoupon-javaBeans.Coupon-"></a>
        *   #### addCoupon

            <pre>public void addCoupon([Coupon](../javaBeans/Coupon.html "class in javaBeans") coupon)
                           throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>addCoupon(), in interface CouponDAO()</dd>

            <dt>Parameters:</dt>

            <dd>`coupon` - will let me manipulate data on the COUPON table's data members on the DB</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception` - , SQLException</dd>

            </dl>

            <a name="updateCoupon-javaBeans.Coupon-"></a>
        *   #### updateCoupon

            <pre>public void updateCoupon([Coupon](../javaBeans/Coupon.html "class in javaBeans") coupon)
                              throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>updateCoupon(), in interface CouponDAO()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getAllCoupons--"></a>
        *   #### getAllCoupons

            <pre>public java.util.ArrayList<[Coupon](../javaBeans/Coupon.html "class in javaBeans")> getAllCoupons()
                                                      throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>getAllCoupons(), in interface CouponDAO()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getOneCoupon-int-"></a>
        *   #### getOneCoupon

            <pre>public [Coupon](../javaBeans/Coupon.html "class in javaBeans") getOneCoupon(int couponID)
                                throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>getOneCoupon()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCoupon-int-"></a>
        *   #### deleteCoupon

            <pre>public void deleteCoupon(int couponID)
                              throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>deleteCoupon()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="addCouponPurchase-int-int-"></a>
        *   #### addCouponPurchase

            <pre>public void addCouponPurchase(int customerID,
                                          int couponID)
                                   throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>addCouponPurchase()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCouponPurchase-int-int-"></a>
        *   #### deleteCouponPurchase

            <pre>public void deleteCouponPurchase(int customerID,
                                             int couponID)
                                      throws java.lang.Exception</pre>

            <dl>

            <dt>Specified by:</dt>

            <dd>deleteCouponPurchase(), in interface CouponDAO()</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

</div>

</div>

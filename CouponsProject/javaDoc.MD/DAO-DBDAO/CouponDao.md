

## Interface CouponDAO<T>

</div>

<div>

<div>

*   <dl>

    <dt>All Known Implementing Classes:</dt>

    <dd>CouponDBDAO</dd>

    </dl>

    * * *

    <pre>public interface CouponDAO<T></pre>


</div>

<div>

*   *   <a name="method.detail"></a>

        ### Method Detail

        <a name="addCoupon-javaBeans.Coupon-"></a>
        *   #### addCoupon

            <pre>void addCoupon([Coupon](../javaBeans/Coupon.html "class in javaBeans") coupon)
                    throws java.lang.Exception</pre>

            <dl>

            <dt>Parameters:</dt>

            <dd>`coupon` - will let me manipulate data on the COUPON table's data members on the DB</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception` - , SQLException</dd>

            </dl>

            <a name="updateCoupon-javaBeans.Coupon-"></a>
        *   #### updateCoupon

            <pre>void updateCoupon([Coupon](../javaBeans/Coupon.html "class in javaBeans") coupon)
                       throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getAllCoupons--"></a>
        *   #### getAllCoupons

            <pre>java.util.ArrayList<[Coupon](../javaBeans/Coupon.html "class in javaBeans")> getAllCoupons()
                                               throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getOneCoupon-int-"></a>
        *   #### getOneCoupon

            <pre>[Coupon](../javaBeans/Coupon.html "class in javaBeans") getOneCoupon(int couponID)
                         throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="isCouponExists-java.lang.String-"></a>
        *   #### isCouponExists

            <pre>boolean isCouponExists(java.lang.String title)
                            throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCoupon-int-"></a>
        *   #### deleteCoupon

            <pre>void deleteCoupon(int couponID)
                       throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="addCouponPurchase-int-int-"></a>
        *   #### addCouponPurchase

            <pre>void addCouponPurchase(int customerID,
                                   int couponID)
                            throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCouponPurchase-int-int-"></a>
        *   #### deleteCouponPurchase

            <pre>void deleteCouponPurchase(int customerID,
                                      int couponID)
                               throws java.lang.Exception</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception`</dd>

            </dl>


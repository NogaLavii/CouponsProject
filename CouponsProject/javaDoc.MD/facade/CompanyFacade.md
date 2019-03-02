
## Class CompanyFacade

</div>

<div class="contentContainer">

*   java.lang.Object
*   *   facade.ClientFacade
    *   *   facade.CompanyFacade

<div class="description">

*   * * *

    <pre>public class <span class="typeNameLabel">CompanyFacade</span>
    extends facade.ClientFacade</pre>

</div>

<div class="summary">

*   *   <a name="constructor.summary"></a>

        ### Constructor Summary

        <table class="memberSummary" summary="Constructor Summary table, listing constructors, and an explanation"><caption><span>Constructors</span><span class="tabEnd"> </span></caption>

        <tbody>

        <tr>

        <th class="colFirst" scope="col">Constructor</th>

        <th class="colLast" scope="col">Description</th>

        </tr>

        <tr class="altColor">

        <th class="colConstructorName" scope="row">`<span class="memberNameLink">[CompanyFacade](../facade/CompanyFacade.html#CompanyFacade--)</span>()`</th>

        <td class="colLast"> </td>

        </tr>

        </tbody>

        </table>

    *   <a name="method.summary"></a>

        ### Method Summary

        <table class="memberSummary" summary="Method Summary table, listing methods, and an explanation"><caption><span id="t0" class="activeTableTab"><span>All Methods</span><span class="tabEnd"> </span></span><span id="t2" class="tableTab"><span>[Instance Methods](javascript:show(2);)</span><span class="tabEnd"> </span></span><span id="t4" class="tableTab"><span>[Concrete Methods](javascript:show(8);)</span><span class="tabEnd"> </span></span></caption>

        <tbody>

        <tr>

        <th class="colFirst" scope="col">Modifier and Type</th>

        <th class="colSecond" scope="col">Method</th>

        <th class="colLast" scope="col">Description</th>

        </tr>

        <tr id="i0" class="altColor">

        <td class="colFirst">`void`</td>

        <th class="colSecond" scope="row">`<span class="memberNameLink">[addCoupon](../facade/CompanyFacade.html#addCoupon-javaBeans.Coupon-)</span>​(javaBeans.Coupon coupon)`</th>

        <td class="colLast"> </td>

        </tr>

        <tr id="i1" class="rowColor">

        <td class="colFirst">`void`</td>

        <th class="colSecond" scope="row">`<span class="memberNameLink">[deleteCoupon](../facade/CompanyFacade.html#deleteCoupon-int-)</span>​(int couponID)`</th>

        <td class="colLast"> </td>

        </tr>

        <tr id="i2" class="altColor">

        <td class="colFirst">`java.util.ArrayList<javaBeans.Coupon>`</td>

        <th class="colSecond" scope="row">`<span class="memberNameLink">[getAllCoupons](../facade/CompanyFacade.html#getAllCoupons-int-)</span>​(int companyId)`</th>

        <td class="colLast"> </td>

        </tr>

        <tr id="i3" class="rowColor">

        <td class="colFirst">`boolean`</td>

        <th class="colSecond" scope="row">`<span class="memberNameLink">[login](../facade/CompanyFacade.html#login-java.lang.String-java.lang.String-)</span>​(java.lang.String email, java.lang.String password)`</th>

        <td class="colLast"> </td>

        </tr>

        <tr id="i4" class="altColor">

        <td class="colFirst">`void`</td>

        <th class="colSecond" scope="row">`<span class="memberNameLink">[updateCoupon](../facade/CompanyFacade.html#updateCoupon-javaBeans.Coupon-)</span>​(javaBeans.Coupon coupon)`</th>

        <td class="colLast"> </td>

        </tr>

        </tbody>

        </table>

        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait`

</div>

<div class="details">

*   *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="CompanyFacade--"></a>
        *   #### CompanyFacade

            <pre>public CompanyFacade()</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="login-java.lang.String-java.lang.String-"></a>
        *   #### login

            <pre>public boolean login​(java.lang.String email,
                                 java.lang.String password)
                          throws java.lang.Exception</pre>

            <dl>

            <dt><span class="overrideSpecifyLabel">Overrides:</span></dt>

            <dd>`login` in class `facade.ClientFacade`</dd>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="addCoupon-javaBeans.Coupon-"></a>
        *   #### addCoupon

            <pre>public void addCoupon​(javaBeans.Coupon coupon)
                           throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="updateCoupon-javaBeans.Coupon-"></a>
        *   #### updateCoupon

            <pre>public void updateCoupon​(javaBeans.Coupon coupon)
                              throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="deleteCoupon-int-"></a>
        *   #### deleteCoupon

            <pre>public void deleteCoupon​(int couponID)
                              throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

            <a name="getAllCoupons-int-"></a>
        *   #### getAllCoupons

            <pre>public java.util.ArrayList<javaBeans.Coupon> getAllCoupons​(int companyId)
                                                                throws java.lang.Exception</pre>

            <dl>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.Exception`</dd>

            </dl>

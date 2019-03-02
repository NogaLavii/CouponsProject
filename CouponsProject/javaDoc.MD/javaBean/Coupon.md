

## Class Coupon

</div>

<div>

*   java.lang.Object
*   javaBeans.Coupon


<div>

*   *   <a name="constructor.summary"></a>

       

        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `equals, getClass, hashCode, notify, notifyAll, wait, wait, wait`

</div>

<div>

*   *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="Coupon-int-int-int-java.lang.String-java.lang.String-java.lang.String-java.util.Date-java.util.Date-double-javaBeans.CategoriesEnum-"></a>
        *   #### Coupon

            <pre>public Coupon(int id,
                          int company_id,
                          int amount,
                          java.lang.String title,
                          java.lang.String description,
                          java.lang.String image,
                          java.util.Date start_date,
                          java.util.Date end_date,
                          double price,
                          javaBeans.CategoriesEnum category)
                   throws java.lang.Exception</pre>

            <div>Creates new coupon with the following parameters</div>

            <dl>

            <dt>Parameters:</dt>

            <dd>`id` - the coupon's id</dd>

            <dd>`company_id` - the company's id</dd>

            <dd>`amount` - the amount of coupons</dd>

            <dd>`title` - the coupon title</dd>

            <dd>`description` - the coupon description</dd>

            <dd>`image` - the url for an image of the coupon</dd>

            <dd>`start_date` - the start date of the coupon</dd>

            <dd>`end_date` - the end date of the coupon</dd>

            <dd>`price` - the coupon's price</dd>

            <dd>`category` - the enum category of the coupon</dd>

            <dt>Throws:</dt>

            <dd>`java.lang.Exception` - general exception</dd>

            <dt>See Also:</dt>

            <dd>`package.`</dd>

            </dl>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="getCategory--"></a>
        *   #### getCategory

            <pre>public javaBeans.CategoriesEnum getCategory()</pre>

            <a name="setCategory-javaBeans.CategoriesEnum-"></a>
        *   #### setCategory

            <pre>public void setCategory(javaBeans.CategoriesEnum category)</pre>

            <a name="getId--"></a>
        *   #### getId

            <pre>public int getId()</pre>

            <a name="setId-int-"></a>
        *   #### setId

            <pre>public void setId(int id)
                       throws exceptionHandling.InvalidIDException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`exceptionHandling.InvalidIDException`</dd>

            </dl>

            <a name="getCompany_id--"></a>
        *   #### getCompany_id

            <pre>public int getCompany_id()</pre>

            <a name="setCompany_id-int-"></a>
        *   #### setCompany_id

            <pre>public void setCompany_id(int company_id)
                               throws exceptionHandling.InvalidIDException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`exceptionHandling.InvalidIDException`</dd>

            </dl>

            <a name="getAmount--"></a>
        *   #### getAmount

            <pre>public int getAmount()</pre>

            <a name="setAmount-int-"></a>
        *   #### setAmount

            <pre>public void setAmount(int amount)
                           throws exceptionHandling.NegativeException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`exceptionHandling.NegativeException`</dd>

            </dl>

            <a name="getTitle--"></a>
        *   #### getTitle

            <pre>public java.lang.String getTitle()</pre>

            <a name="setTitle-java.lang.String-"></a>
        *   #### setTitle

            <pre>public void setTitle(java.lang.String title)
                          throws exceptionHandling.ShortStringException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`exceptionHandling.ShortStringException`</dd>

            </dl>

            <a name="getDescription--"></a>
        *   #### getDescription

            <pre>public java.lang.String getDescription()</pre>

            <a name="setDescription-java.lang.String-"></a>
        *   #### setDescription

            <pre>public void setDescription(java.lang.String description)
                                throws exceptionHandling.ShortStringException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`exceptionHandling.ShortStringException`</dd>

            </dl>

            <a name="getImage--"></a>
        *   #### getImage

            <pre>public java.lang.String getImage()</pre>

            <a name="setImage-java.lang.String-"></a>
        *   #### setImage

            <pre>public void setImage(java.lang.String image)
                          throws exceptionHandling.URLException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`exceptionHandling.URLException`</dd>

            </dl>

            <a name="getStart_date--"></a>
        *   #### getStart_date

            <pre>public java.util.Date getStart_date()</pre>

            <a name="setStart_date-java.util.Date-java.util.Date-"></a>
        *   #### setStart_date

            <pre>public void setStart_date(java.util.Date start_date,
                                      java.util.Date end_date)
                               throws exceptionHandling.DateException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`exceptionHandling.DateException`</dd>

            </dl>

            <a name="getEnd_date--"></a>
        *   #### getEnd_date

            <pre>public java.util.Date getEnd_date()</pre>

            <a name="setEnd_date-java.util.Date-"></a>
        *   #### setEnd_date

            <pre>public void setEnd_date(java.util.Date end_date)
                             throws exceptionHandling.DateException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`exceptionHandling.DateException`</dd>

            </dl>

            <a name="getPrice--"></a>
        *   #### getPrice

            <pre>public double getPrice()</pre>

            <a name="setPrice-double-"></a>
        *   #### setPrice

            <pre>public void setPrice(double price)
                          throws exceptionHandling.NegativeException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`exceptionHandling.NegativeException`</dd>

            </dl>

            <a name="toString--"></a>
        *   #### toString

            <pre>public java.lang.String toString()</pre>

            <dl>

            <dt>Overrides:</dt>

            <dd>`toString` in class `java.lang.Object`</dd>

            </dl>

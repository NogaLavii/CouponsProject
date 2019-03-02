## Class CouponsJDBC

</div>

<div>

*   java.lang.Object
*   *   jdbc.CouponsJDBC


        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait`

</div>

<div>

*   *   <a name="field.detail"></a>

        ### Field Detail

        <a name="USERNAME"></a>
        *   #### USERNAME

            <pre>public static java.lang.String USERNAME</pre>

            <div>the jdbc coupons file. contains connections and sql statements so that i can manipulate data on the db</div>

            <a name="PASSWORD"></a>
        *   #### PASSWORD

            <pre>public static java.lang.String PASSWORD</pre>

            <a name="URL"></a>
        *   #### URL

            <pre>public static java.lang.String URL</pre>

    *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="CouponsJDBC--"></a>
        *   #### CouponsJDBC

            <pre>public CouponsJDBC()</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="builtDB--"></a>
        *   #### builtDB

            <pre>public static void builtDB()</pre>

            <a name="insert-int-int-int-java.lang.String-java.lang.String-java.sql.Date-java.sql.Date-int-double-java.lang.String-"></a>
        *   #### insert

            <pre>public static void insert(int id,
                                      int company_id,
                                      int category_id,
                                      java.lang.String title,
                                      java.lang.String description,
                                      java.sql.Date start_date,
                                      java.sql.Date end_date,
                                      int amount,
                                      double price,
                                      java.lang.String image)</pre>

            <a name="readAll--"></a>
        *   #### readAll

            <pre>public static void readAll()</pre>

            <a name="update-int-int-int-java.lang.String-java.lang.String-java.sql.Date-java.sql.Date-int-double-java.lang.String-"></a>
        *   #### update

            <pre>public static void update(int id,
                                      int company_id,
                                      int category_id,
                                      java.lang.String title,
                                      java.lang.String description,
                                      java.sql.Date start_date,
                                      java.sql.Date end_date,
                                      int amount,
                                      double price,
                                      java.lang.String image)
                               throws java.sql.SQLException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.sql.SQLException`</dd>

            </dl>

            <a name="delete-int-"></a>
        *   #### delete

            <pre>public static void delete(int id)
                               throws java.sql.SQLException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.sql.SQLException`</dd>

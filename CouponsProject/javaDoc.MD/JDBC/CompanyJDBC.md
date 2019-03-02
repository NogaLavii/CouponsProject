## Class companiesJDBC

</div>

<div>

*   java.lang.Object
*   *   jdbc.companiesJDBC

<div>

*   * * *

    <pre>public class companiesJDBC
    extends java.lang.Object</pre>

</div>


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

            <div>the jdbc companies file. contains connections and sql statements so that i can manipulate data on the db</div>

            <a name="PASSWORD"></a>
        *   #### PASSWORD

            <pre>public static java.lang.String PASSWORD</pre>

            <a name="URL"></a>
        *   #### URL

            <pre>public static java.lang.String URL</pre>

    *   <a name="constructor.detail"></a>

        ### Constructor Detail

        <a name="companiesJDBC--"></a>
        *   #### companiesJDBC

            <pre>public companiesJDBC()</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="builtDB--"></a>
        *   #### builtDB

            <pre>public static void builtDB()</pre>

            <a name="insert-java.lang.String-java.lang.String-java.lang.String-"></a>
        *   #### insert

            <pre>public static void insert(java.lang.String name,
                                      java.lang.String email,
                                      java.lang.String password)</pre>

            <a name="readAll--"></a>
        *   #### readAll

            <pre>public static void readAll()</pre>

            <a name="update-int-java.lang.String-java.lang.String-java.lang.String-"></a>
        *   #### update

            <pre>public static void update(int id,
                                      java.lang.String name,
                                      java.lang.String email,
                                      java.lang.String password)
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

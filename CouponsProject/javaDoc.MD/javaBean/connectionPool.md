
## Class ConnectionPool

</div>

<div>

*   java.lang.Object
*   *   javaBeans.ConnectionPool



<div>

*   *   <a name="field.detail"></a>

        ### Field Detail

        <a name="instance"></a>
        *   #### instance

            <pre>public static [ConnectionPool](../javaBeans/ConnectionPool.html "class in javaBeans") instance</pre>

            <div>this is the connection pool, from here i can pull connections</div>

            <a name="connections"></a>
        *   #### connections

            <pre>public java.util.Stack<java.sql.Connection> connections</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="getConnection--"></a>
        *   #### getConnection

            <pre>public java.sql.Connection getConnection()
                                              throws java.lang.InterruptedException</pre>

            <div>get a connection from the stack (if its empty - wait, it will fill up in a sec</div>

            <dl>

            <dt>Returns:</dt>

            <dt>Throws:</dt>

            <dd>`java.lang.InterruptedException`</dd>

            </dl>

            <a name="getInstance--"></a>
        *   #### getInstance

            <pre>public static [ConnectionPool](../javaBeans/ConnectionPool.html "class in javaBeans") getInstance()</pre>

            <a name="restoreConnection-java.sql.Connection-"></a>
        *   #### restoreConnection

            <pre>public void restoreConnection(java.sql.Connection conn)</pre>

            <div>restore the connection after finish with it and notify to the fellow threads</div>

            <dl>

            <dt>Parameters:</dt>

            <dd>`conn` - is a connection instance</dd>

            </dl>

            <a name="closeAllConnections--"></a>
        *   #### closeAllConnections

            <pre>public void closeAllConnections()
                                     throws java.lang.InterruptedException</pre>

            <dl>

            <dt>Throws:</dt>

            <dd>`java.lang.InterruptedException`</dd>

            </dl>

</div>

</div>


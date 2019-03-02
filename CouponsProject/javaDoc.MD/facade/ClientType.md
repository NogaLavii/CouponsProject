## Enum ClientType

</div>

<div class="contentContainer">

*   java.lang.Object
*   *   java.lang.Enum<[ClientType](../facade/ClientType.html "enum in facade")>
    *   *   facade.ClientType

<div class="description">

*   <dl>

    <dt>All Implemented Interfaces:</dt>

    <dd>java.io.Serializable, java.lang.Comparable<[ClientType](../facade/ClientType.html "enum in facade")></dd>

    </dl>

    * * *

    <pre>public enum <span class="typeNameLabel">ClientType</span>
    extends java.lang.Enum<[ClientType](../facade/ClientType.html "enum in facade")></pre>

</div>

<div class="summary">

*   *   <a name="enum.constant.summary"></a>

        ### Enum Constant Summary

        <table class="memberSummary" border="0" cellpadding="3" cellspacing="0" summary="Enum Constant Summary table, listing enum constants, and an explanation"><caption><span>Enum Constants</span><span class="tabEnd"> </span></caption>

        <tbody>

        <tr>

        <th class="colOne" scope="col">Enum Constant and Description</th>

        </tr>

        <tr class="altColor">

        <td class="colOne">`<span class="memberNameLink">[Adminstrator](../facade/ClientType.html#Adminstrator)</span>` </td>

        </tr>

        <tr class="rowColor">

        <td class="colOne">`<span class="memberNameLink">[Company](../facade/ClientType.html#Company)</span>` </td>

        </tr>

        <tr class="altColor">

        <td class="colOne">`<span class="memberNameLink">[Customer](../facade/ClientType.html#Customer)</span>` </td>

        </tr>

        </tbody>

        </table>

    *   <a name="method.summary"></a>

        ### Method Summary

        <table class="memberSummary" border="0" cellpadding="3" cellspacing="0" summary="Method Summary table, listing methods, and an explanation"><caption><span id="t0" class="activeTableTab"><span>All Methods</span><span class="tabEnd"> </span></span><span id="t1" class="tableTab"><span>[Static Methods](javascript:show(1);)</span><span class="tabEnd"> </span></span><span id="t4" class="tableTab"><span>[Concrete Methods](javascript:show(8);)</span><span class="tabEnd"> </span></span></caption>

        <tbody>

        <tr>

        <th class="colFirst" scope="col">Modifier and Type</th>

        <th class="colLast" scope="col">Method and Description</th>

        </tr>

        <tr id="i0" class="altColor">

        <td class="colFirst">`static [ClientType](../facade/ClientType.html "enum in facade")`</td>

        <td class="colLast">`<span class="memberNameLink">[valueOf](../facade/ClientType.html#valueOf-java.lang.String-)</span>(java.lang.String name)`

        <div class="block">Returns the enum constant of this type with the specified name.</div>

        </td>

        </tr>

        <tr id="i1" class="rowColor">

        <td class="colFirst">`static [ClientType](../facade/ClientType.html "enum in facade")[]`</td>

        <td class="colLast">`<span class="memberNameLink">[values](../facade/ClientType.html#values--)</span>()`

        <div class="block">Returns an array containing the constants of this enum type, in the order they are declared.</div>

        </td>

        </tr>

        </tbody>

        </table>

        *   <a name="methods.inherited.from.class.java.lang.Enum"></a>

            ### Methods inherited from class java.lang.Enum

            `compareTo, equals, getDeclaringClass, hashCode, name, ordinal, toString, valueOf`
        *   <a name="methods.inherited.from.class.java.lang.Object"></a>

            ### Methods inherited from class java.lang.Object

            `getClass, notify, notifyAll, wait, wait, wait`

</div>

<div class="details">

*   *   <a name="enum.constant.detail"></a>

        ### Enum Constant Detail

        <a name="Adminstrator"></a>
        *   #### Adminstrator

            <pre>public static final [ClientType](../facade/ClientType.html "enum in facade") Adminstrator</pre>

            <a name="Company"></a>
        *   #### Company

            <pre>public static final [ClientType](../facade/ClientType.html "enum in facade") Company</pre>

            <a name="Customer"></a>
        *   #### Customer

            <pre>public static final [ClientType](../facade/ClientType.html "enum in facade") Customer</pre>

    *   <a name="method.detail"></a>

        ### Method Detail

        <a name="values--"></a>
        *   #### values

            <pre>public static [ClientType](../facade/ClientType.html "enum in facade")[] values()</pre>

            <div class="block">Returns an array containing the constants of this enum type, in the order they are declared. This method may be used to iterate over the constants as follows:

            <pre>for (ClientType c : ClientType.values())
                System.out.println(c);
            </pre>

            </div>

            <dl>

            <dt><span class="returnLabel">Returns:</span></dt>

            <dd>an array containing the constants of this enum type, in the order they are declared</dd>

            </dl>

            <a name="valueOf-java.lang.String-"></a>
        *   #### valueOf

            <pre>public static [ClientType](../facade/ClientType.html "enum in facade") valueOf(java.lang.String name)</pre>

            <div class="block">Returns the enum constant of this type with the specified name. The string must match _exactly_ an identifier used to declare an enum constant in this type. (Extraneous whitespace characters are not permitted.)</div>

            <dl>

            <dt><span class="paramLabel">Parameters:</span></dt>

            <dd>`name` - the name of the enum constant to be returned.</dd>

            <dt><span class="returnLabel">Returns:</span></dt>

            <dd>the enum constant with the specified name</dd>

            <dt><span class="throwsLabel">Throws:</span></dt>

            <dd>`java.lang.IllegalArgumentException` - if this enum type has no constant with the specified name</dd>

            <dd>`java.lang.NullPointerException` - if the argument is null</dd>

            </dl>

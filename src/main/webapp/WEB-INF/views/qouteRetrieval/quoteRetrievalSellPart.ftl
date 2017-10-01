<div style="text-align: center">
    <table width="100%" border="1">
        <tbody valign="top">
        <tr>
            <th style="text-align: center">цена</th>
            <th style="text-align: center">объем</th>
        </tr>
        <#list quotes as quote>
            <#if "${quote.type}" == "S">
            <tr>
                <td>${quote.price}</td>
                <td>${quote.qty}</td>
            </tr>
            </#if>
        </#list>

        </tbody>
    </table>
</div>
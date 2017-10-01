<div style="text-align: center">
    <table width="100%" border="1">
        <tbody valign="top">
        <tr>
            <th style="text-align: center">цена</th>
            <th style="text-align: center">объем</th>
        </tr>
        <#list quotes?sort_by("createMoment")?reverse?sort_by("price")?reverse as quote>
            <#if "${quote.type}" == "P">
            <tr>
                <td>${quote.price}</td>
                <td>${quote.qty}</td>
            </tr>
            </#if>
        </#list>

        </tbody>
    </table>


</div>
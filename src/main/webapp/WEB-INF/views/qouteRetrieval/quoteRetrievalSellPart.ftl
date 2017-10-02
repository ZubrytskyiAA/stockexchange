<div style="text-align: center">
    <table class="table table-fixed table-striped" width="100%" border="1">
        <thead>
        <tr>
            <th style="text-align: center">цена</th>
            <th style="text-align: center">объем</th>
        </tr>
        </thead>

        <tbody valign="top">

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
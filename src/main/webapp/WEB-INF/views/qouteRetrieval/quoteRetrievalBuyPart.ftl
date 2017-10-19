<div class="container1" style="text-align: center">
    <table class="  table-striped" width="100%" border="0">


        <tbody valign="top">

        <#list quotes?sort_by("createMoment")?reverse?sort_by("price")?reverse as quote>
            <#if "${quote.type}" == "P">
            <tr>
                <td style="width :159px">${quote.price?c}</td>
                <td style="width :159px">${quote.qty}</td>
            </tr>
            </#if>
        </#list>

        </tbody>
    </table>


</div>
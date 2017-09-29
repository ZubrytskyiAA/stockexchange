<div style="background: coral">
<form action="/addNewQuote" method="post" name="addNewQuote" class="form-group">
    <#--<p>Инструмент</p>-->
    <#--<select name="select2" onchange="document.location=this.options[this.selectedIndex].value">-->

    <#--<#if "${selectedIssueName}"  == "">-->
        <#--<option selected value=/qouteRetrieval/1></option>-->
    <#--<#else >-->
        <#--<option selected value=/qouteRetrieval/${selectedIssueId}>${selectedIssueName}</option>-->
    <#--</#if>-->

    <#--<#list listIssue as issues>-->
        <#--<#if "${selectedIssueName}"  != "${issues.name}">-->
            <#--<option value=/qouteRetrieval/${issues.id}>${issues.name}</option>-->
        <#--</#if>-->

    <#--</#list>-->
    <#--</select>-->


    <p>Цена</p>
    <input title="price" pattern="^[0-9]+$" type="number" name="price" value="0.01" required/>
        <p>Количество</p>
        <input title="qty" pattern="^[0-9]{1,8}" step="1" type="number" name="qty"  value="1"required/>
    <input type="submit" title="Отправить" value="Отправить"/>

</form>
</div>
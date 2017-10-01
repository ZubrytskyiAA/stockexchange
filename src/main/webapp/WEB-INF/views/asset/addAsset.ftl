<#if listIssueNamesActive??>
<form class="form-horizontal" action="/asset/addAsset" method="post" name="addAssetForm">
    <input name="userName" type="hidden" value="${selectUserName}">
    <label class="control-label col-sm-2" for="price"> Добавить актив </label>
    <div class="col-sm-1">
        <select name="issueName" required>
            <option selected ></option>
            <#list listIssueNamesActive as issueNames>
                <option value=${issueNames}>${issueNames}</option>
            </#list>
        </select>
    </div>
    <div class="col-sm-1.2">
        <input title="quantity" type="number" name="qtyAdd" required>
    </div>
    <div class="col-sm-1.5">
        <input type="submit" value="пополнить">
    </div>


</form>



</#if>


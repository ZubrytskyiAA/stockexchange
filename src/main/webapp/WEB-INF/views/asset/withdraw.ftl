<#if listIssueNamesActive??>
<form class="form-horizontal" action="/asset/withdrawAsset" method="post" name="withdrawAssetForm">
    <input name="userName" type="hidden" value="${selectUserName}">
    <div class="form-group">
        <label class="control-label col-sm-2" for="price"> Вывести актив </label>
        <div class="col-sm-1">
            <select name="issueName" required>
                <option selected ></option>
                <#list listIssueNamesActive as issueNames>
                    <option value=${issueNames}>${issueNames}</option>
                </#list>
            </select>
        </div>
        <div class="col-sm-1.5">
            <input title="full_name" type="quantity" name="qtyWithdraw" required>
        </div>
        <div class="col-sm-1.5">
            <input type="submit" value="Вывести">
        </div>
    </div>
</form>
</#if>
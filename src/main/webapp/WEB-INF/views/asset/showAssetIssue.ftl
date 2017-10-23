<div class="form-group col-sm-9">


<#if listIssueNamesActive??>
    <form class="form-group" action="/asset/addAsset" method="post" name="addAssetForm">
        <input name="userName" type="hidden" value="${selectUserName}">
        <label class="control-label" for="price"> Добавить актив </label>
        <select class="form-control" name="issueName" required>
            <option selected></option>
            <#list listIssueNamesActive?sort as issueNames>
                <#if issueNames != "UAH">
                    <option value=${issueNames}>${issueNames}</option>
                </#if>
            </#list>
        </select>
        <input title="quantity" type="number" name="qtyAdd" required>
        <input type="submit" value="пополнить">
    </form>
</#if>


<#if listQuantityIssues??>
    <form class="form-group" action="/asset/withdrawAsset" method="post" name="withdrawAssetForm">
        <input name="userName" type="hidden" value="${selectUserName}">
        <label class="control-label" > Вывести актив </label>
        <select class="form-control" name="issueName" required>
            <option selected></option>
            <#list listQuantityIssues?sort as assets>
                <option value=${assets.issueId.name}>${assets.issueId.name}</option>
            </#list>
        </select>
        <input title="full_name" type="number" name="qtyWithdraw" required>
        <input type="submit" value="Вывести">
    </form>
</#if>






<#if  "${selectUserName}" = "">

<#elseif listQuantityIssues??>
    <table class="table table-striped col-sm-9">
        <thead>
        <tr>
            <th>Название инструмента</th>
            <th>Доступные средства</th>
            <th>Заблокированные средства</th>
        </tr>
        </thead>
        <tbody>
            <#list listQuantityIssues as assets>
            <tr>
                <td><a href="/issue/${assets.issueId.name}">${assets.issueId.name}</a></td>
                <td>${assets.free}</td>
                <td>${assets.blocked}</td>
            </tr>
            </#list>
        </tbody>
    </table>

<#else >


    <p>
    <h3>There isn't any assets</h3>
    </p>
</#if>

</div>


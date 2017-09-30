<div>

    <form class="form-horizontal" action="/asset/changeActive" method="post" name="newQuoteForm">


        <div class="form-group">
            <label class="control-label col-sm-4" for="price"> Клиент:</label>
            <div class="col-sm-5">


                <select class="form-control  col-sm-5" name="userName"
                        onchange="document.location=this.options[this.selectedIndex].value">
                <#if "${selectUserName}" = "">
                    <option selected value=""></option>
                <#else >
                    <option selected value=/asset/${selectUserName}>${selectUserName}</option>
                </#if>


                <#list listNamesAllUsers as userNames>

                    <option value=/asset/${userNames}>${userNames}</option>

                </#list>
                </select>


            </div>
        </div>

    <#if "${selectUserName}" != "">
        <input type="hidden" value="${selectedIssueName}" name="issueName">
        <input type="hidden" value=1 name="userId">
        <div class="form-group">
            <label class="control-label col-sm-2" for="price"> Вевести актив </label>
            <div class="col-sm-1">

                <select name="withdraw">
                    <option selected value=/asset/${selectUserName}/dsd>dsds</option>
                    <#list listAssetsByUserName as assets>
                        <option value=${assets.id}>${assets.issueId.name}</option>
                    </#list>
                </select>
            </div>
            <div class="col-sm-1.5">
                <input title="full_name" type="number" name="qtyWithdraw"/>
            </div>

        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="price"> Добавить актив </label>
            <div class="col-sm-1">
                <select name="add">
                    <option selected value=/asset/${selectUserName}/dsd>dsds</option>
                    <#list listIssueNamesActive as issueNames>
                        <option value=${issueNames}>${issueNames}</option>
                    </#list>
                </select>
            </div>
            <div class="col-sm-1.2">
                <input title="full_name" type="number" name="qtyWithdraw"/>
            </div>
        </div>

    <#--<div class="form-group">-->
    <#--<label class="control-label col-sm-4" for="price"> Фильтр:</label>-->
    <#--<div class="col-sm-5">-->

    <#--<select name="selectIssue" onchange="document.location=this.options[this.selectedIndex].value">-->

    <#--<option selected value=/asset/${selectUserName}/dsd>dsds</option>-->


    <#--<#list listAssetsByUserName as assets>-->

    <#--<option value=/asset/${selectUserName}/${assets.id}>${assets.issueId.name}</option>-->


    <#--</#list>-->
    <#--</select>-->


    <#--</div>-->
    <#--</div>-->
    </#if>
    </form>


</div>


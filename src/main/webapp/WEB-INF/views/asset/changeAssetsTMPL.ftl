<div>


    <div class="form-group">

        <div class="col-sm-5">

            <label class="control-label col-sm-4" for="price"> Клиент:</label>
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

    <#include "addAsset.ftl">
    <#include "withdraw.ftl">

</#if>


</div>


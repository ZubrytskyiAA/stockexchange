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
            <label class="control-label col-sm-4" for="price"> Actions:</label>
            <div class="col-sm-5">
                <div class="radio">
                    <label><input type="radio" value="A" name="optradio" checked>Add asset</label>
                </div>
                <div class="radio">
                    <label><input type="radio" value="W" name="optradio">Withdraw asset</label>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-sm-4" for="price"> Актив:</label>
            <div class="col-sm-5">

                <select name="selectIssue" onchange="document.location=this.options[this.selectedIndex].value">

                    <option selected value=/asset/${selectUserName}/dsd>dsds</option>


                    <#list listIssue as issueName>
                        <#if "${selectedIssueName}"  != "${issueName}">
                            <option value=/asset/${selectUserName}/${selectedIssueName}>${selectedIssueName}</option>
                        </#if>

                    </#list>
                </select>


            </div>
        </div>
    <#--<#if "${selectIssueName}" != "">-->
    <#--<div class="form-group">-->
    <#--<label class="control-label col-sm-4" for="qty"> количество:</label>-->
    <#--<div class="col-sm-5">-->
    <#--<input id="qty" type="number" class="form-control col-sm-4" name="qty">-->
    <#--</div>-->

    <#--</div>-->

    <#--<div class="form-group">-->
    <#--<label class="control-label col-sm-4" for="available"> доступно:</label>-->
    <#--<div class="col-sm-5">-->
    <#--<input id="available" type="number" class="form-control col-sm-4" name="available"-->
    <#--value=${available}-->
    <#--disabled="disabled">-->
    <#--</div>-->

    <#--</div>-->


    <#--<div class="form-group">-->
    <#--<div class="col-sm-offset-4 col-sm-5">-->
    <#--<button type="submit" class="btn btn-default">Submit</button>-->
    <#--</div>-->
    <#--</div>-->

    <#--</#if>-->
    </#if>
    </form>


</div>


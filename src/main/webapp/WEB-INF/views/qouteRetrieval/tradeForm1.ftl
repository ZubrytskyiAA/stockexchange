<#--<div style="background: coral">-->
<#--<form action="/addNewQuote" method="post" name="addNewQuote" class="form-group">-->


<#--<p style="text-align: right">-->
<#--Цена:-->
<#--<input title="price" pattern="^[0-9]+$" type="number" name="price"-->
<#--value="0.01" required/>-->
<#--</p>-->

<#--<p style="text-align: right"> Количество:-->
<#--<input title="qty" pattern="^[0-9]{1,8}" step="1" type="number" name="qty"-->
<#--value="1" required/>-->
<#--</p>-->
<#--<p style="text-align: right">-->
<#--<input type="submit" title="Отправить" value="Отправить"/>-->
<#--</p>-->


<#--</form>-->
<div>

    <form class="form-horizontal" action="/quote/addNewQuote" method="post" name="newQuoteForm">
        <input type="hidden" value ="${selectedIssueName}" name="issueName">
        <input type="hidden" value=1 name="userId">
        <div class="form-group">
            <label class="control-label col-sm-4" for="price"> Type deal:</label>
            <div class="col-sm-5">
                <div class="radio">
                    <label><input type="radio" value="P" name="optradio" checked>Buy</label>
                </div>
                <div class="radio">
                    <label><input type="radio" value="S" name="optradio">Sell</label>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4" for="price"> Цена:</label>
            <div class="col-sm-5">

                <input class="form-control" id="price" pattern="^[0-9]+$" step="0.1" type="number" name="price"
                       placeholder="" required/>
            </div>
        </div>
        <div class="form-group">

            <label class="control-label col-sm-4" for="qty">Количество:</label>
            <div class="col-sm-5">
                <input class="form-control" id="qty" pattern="^[0-9]{1,8}" step="1" type="number" name="qty"
                       placeholder="" required/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-5">
                <button type="submit" class="btn btn-default">Submit</button>
            </div>
        </div>
    </form>
</div>
<#--</div>-->
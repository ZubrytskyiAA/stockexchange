<div>

    <form class="form-horizontal" action="/quote/addNewQuote" method="post" name="newQuoteForm">
        <input type="hidden" value="${selectedIssueName}" name="issueName">
        <input type="hidden" value=1 name="userId">
        <div class="form-group">
            <label class="control-label col-sm-4" for="price"> <@spring.message "DealType"/></label>
            <div class="col-sm-1">
                <div class="radio">
                    <label><input type="radio" value="P" name="optradio" checked><@spring.message "Purchase"/></label>
                </div>
                <div class="radio">
                    <label><input type="radio" value="S" name="optradio"><@spring.message "Sell"/></label>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-4" for="price"> <@spring.message "Price"/>:</label>
            <div class="col-sm-5">

                <input class="form-control" id="price" step="0.0001" type="number" name="price"
                       placeholder="" required/>
            </div>
        </div>
        <div class="form-group">

            <label class="control-label col-sm-4" for="qty"><@spring.message "Quantity"/>:</label>
            <div class="col-sm-5">
                <input class="form-control" id="qty" pattern="^[0-9]{1,8}" step="1" type="number" name="qty"
                       placeholder="" required/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-5">
                <button type="submit" class="btn btn-default"><@spring.message "Send"/></button>
            </div>
        </div>
    </form>
</div>

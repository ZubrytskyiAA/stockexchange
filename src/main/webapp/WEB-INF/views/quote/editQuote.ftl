<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

</head>
<body class="container">
<#include "*/header.ftl">

<#if quote??>
<form action="/quote/editQuote" method="post" name="user" class="form-group">
    <input type="hidden" name="id" value="${quote.id?c}">
    <label><@spring.message "editQuote.quote"/> № ${quote.id}</label><br>
    <input title="price" type="number" step="0.0001"  name="price" value="${quote.price}" required placeholder="${quote.price}"   ><br>
    <input title="qty" type="number" name="qty" value="${quote.qty}" required><br>
    <input type="submit" title=<@spring.message "Edit"/> value=<@spring.message "Edit"/>>
</form>
<#else >
<h1><@spring.message "editQuote.noQuote"/></h1>

</#if>
<a type="button" href="/quote" class="button"><@spring.message "Back"/></a>
</body>
</html>


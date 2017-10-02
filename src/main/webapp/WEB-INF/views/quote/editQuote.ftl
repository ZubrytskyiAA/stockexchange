<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QuoteData</title>
</head>
<body class="container">
<#include "*/header.ftl">

<#if quote??>
<form action="/quote/editQuote" method="post" name="user" class="form-group">
    <input type="hidden" name="id" value="${quote.id?c}">
    <label>Заявка №${quote.id}</label><br>
    <input title="price" type="number" step="0.0001"  name="price" value="${quote.price}" required placeholder="${quote.price}"   ><br>
    <input title="qty" type="number" name="qty" value="${quote.qty}" required><br>
    <input type="submit" title="Edit" value="Edit"/>
</form>
<#else >
<h1>Такой заявки нету</h1>

</#if>
<a type="button" href="/quote" class="button">Back</a>
</body>
</html>


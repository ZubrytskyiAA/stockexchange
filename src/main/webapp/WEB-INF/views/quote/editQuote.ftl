<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QuoteData</title>
</head>
<body class="container">
<#include "*/header.ftl">

<form action="/quote/editQuote" method="post" name="user" class="form-group">
    <input type="hidden" name="id" value="${quote.id}">
    <label>Заявка №${quote.id}</label><br>
    <input title="price" type="number" step="0.0001" name="price" value="${quote.price}" required><br>
    <input title="qty" type="number" name="qty" value="${quote.qty}" required><br>
    <input type="submit" title="Edit" value="Edit"/>
</form>
<a type="button" href="/quoty" class="button">Back</a>
</body>
</html>

<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<#--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->
<!-- Latest compiled JavaScript -->
<link type="text/css" rel="StyleSheet" href="http://bootstraptema.ru/plugins/2016/shieldui/style.css"/>
<script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
<script src="http://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>

<nav class="navbar navbar-default">

        <div class="navbar-header">
            <a class="navbar-brand" href="/">Trade Site</a>
        </div>
        <ul class="nav nav-tabs nav-justified">
        <@security.authorize access="hasAnyRole('ROLE_ADMIN','ROLE_TRADER')">
            <li><a href="/qouteRetrieval">Qoute Retrieval</a></li>
            <li><a href="/quote">Quotes</a></li>
            <li><a href="/report">Reports</a></li>
            <li><a href="/trade">Trades</a></li>
        </@security.authorize>
        <@security.authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/users">Users</a></li>
            <li><a href="/issue">Issues</a></li>
        </@security.authorize>
        <@security.authorize access="hasAnyRole('ROLE_BOOKKEEPER','ROLE_TRADER')">
            <li><a href="/asset">Assets</a></li>
        </@security.authorize>
        <@security.authorize access="isAuthenticated()">
            <li><a href="/logout">Log out [<@security.authentication property="principal.username"/>]</a></li>
        </@security.authorize>

        </ul>

</nav>


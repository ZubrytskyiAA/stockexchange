<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Trade Site</a>
        </div>
        <ul class="nav nav-tabs nav-justified">
        <@security.authorize access="hasAnyRole('ROLE_ADMIN','ROLE_TRADER')">
            <li><a href="/qouteRetrieval">Qoute Retrieval</a></li>
        </@security.authorize>
        <@security.authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/users">Users</a></li>
        </@security.authorize>
            <li><a href="/quote">Quotes</a></li>
        <@security.authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/issue">Issues</a></li>
        </@security.authorize>
            <li><a href="/report">Reports</a></li>
        <@security.authorize access="hasAnyRole('ROLE_BOOKKEEPER','ROLE_TRADER')">
            <li><a href="/asset">Assets</a></li>
        </@security.authorize>
            <li><a href="/trade/alltrades">Trades</a></li>

        <@security.authorize access="isAuthenticated()">
            <li><a href="/logout">Log out [<@security.authentication property="principal.username"/>]</a></li>
        </@security.authorize>

        </ul>
    </div>
</nav>


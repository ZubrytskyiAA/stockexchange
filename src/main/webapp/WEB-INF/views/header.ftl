<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#import "/spring.ftl" as spring/>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
<script src="http://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>
<div class="container-fluid">
    <div class="row">

        <div class="col-sm-2  col-md-2" style="border: none;">
            <button class="btn" type="button" style="background-color: rgba(245, 245, 245, 0);"
                    data-toggle="dropdown"><@spring.message "header.language"/>
                <span class="caret"></span></button>
            <ul class="dropdown-menu"
            ">
            <li>
                <a href="/?mylocale=ua" title="UKRAINE">
                    <img src="/ua.gif" alt="UA" height="12" width="20" border="0"> - Українська
                </a>
            </li>
            <li>
                <a href="/?mylocale=ru" title="RUSSIAN">
                    <img src="/resources/images/flags/ru.gif" alt="RU" height="12" width="20" border="0"> - Русский
                </a>
            </li>
            <li>
                <a href="/?mylocale=en" title="ENGLISH">
                    <img src="/resources/images/flags/en.gif" alt="EN" height="12" width="20" border="0"> - English
                </a>
            </li>
            </ul>
        <@security.authentication property="principal.username"/>


        </div>
    </div>

</div>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Trade Site</a>
        </div>
        <ul class="nav navbar-nav">
        <@security.authorize access="hasAnyRole('ROLE_ADMIN','ROLE_TRADER')">
            <li><a href="/qouteRetrieval"><@spring.message "header.quoteRetrieval"/></a></li>
            <li><a href="/quote"><@spring.message "header.quote"/></a></li>
            <li><a href="/report"><@spring.message "header.reports"/></a></li>
            <li><a href="/trade"><@spring.message "header.trades"/></a></li>
        </@security.authorize>
        <@security.authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/users"><@spring.message "header.users"/></a></li>
            <li><a href="/issue"><@spring.message "header.issues"/></a></li>
        </@security.authorize>
        <@security.authorize access="hasAnyRole('ROLE_BOOKKEEPER','ROLE_TRADER')">
            <li><a href="/asset"><@spring.message "header.assets"/></a></li>
        </@security.authorize>
        <@security.authorize access="isAuthenticated()">
            <li><a href="/options"><@spring.message "header.options"/></a></li>
            <li><a href="/logout"><@spring.message "header.logout"/> </a></li>
        </@security.authorize>

        </ul>
    </div>
</nav>


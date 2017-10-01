<form action="/issue/setActivities" method="post" name="setActive" class="form-group">
    <input title="id" type="hidden" name="id" value="${issue.id}">
    <input title="active" type="hidden" name="active" value=${issue.active?then("0","1")}>
    <input type="submit" value=${issue.active?then("Деактивировать","Активировать")}>
</form>
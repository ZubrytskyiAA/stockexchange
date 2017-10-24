<form action="/users/setActivities" method="post" name="setActive" class="form-group">
    <input title="id" type="hidden" name="id" value="${user.id}">
    <input title="active" type="hidden" name="active" value=${user.active?then("0","1")}>
    <input type="submit" value=${user.active?then("Off","On")}>
</form>
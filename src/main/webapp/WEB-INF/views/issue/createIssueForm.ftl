<form action="/issue/newIssue" method="post" name="issue" class="form-group">

    <td><input title="name" type="text" name="name" required></td>

    <td><input title="full_name" type="text" name="fullName" required></td>
    <td>
        <select name="active">
            <option value=1>Активный</option>
            <option value=0>Деактивированый</option>
        </select>

    </td>
    <td></td>
    <td><input type="submit" title="OK" value="Добавить"/></td>
</form>

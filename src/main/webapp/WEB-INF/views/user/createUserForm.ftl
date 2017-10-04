

<form action="/newUser" method="post" name="user" class="form-group">
    <p>loginname</p>
    <input title="loginname" type="text" name="loginName" required/>
    <p>Password</p>
    <input title="password" type="password" name="password"/>
    <p>FIO</p>
    <input title="fio" type="text" name="fio"/>
    <p>Email</p>
    <input title="email" type="email" name="email"/>
    <p>Phonenumber</p>
    <input title="phonenumber" type="text" name="phoneNumber" >
    <input type="submit" title="OK" value="OK!"/>
</form>

<br>
Delete 2
<form action="/delete" method="post" class="form-group">
    Id
    <input title="id" name="id"/>
    <input type="submit" title="OK" value="Delete"/>
</form>

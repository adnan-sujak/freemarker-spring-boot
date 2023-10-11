<!DOCTYPE html>
<html>
<head>
    <title>FreeMarker with Spring Boot</title>
</head>
<body>
<h1>${message}</h1>

<form action="/addUser" method="post">
    Name: <input type="text" name="name"><br>
    Email: <input type="text" name="email"><br>
    <input type="submit" value="Add User">
</form>

<h2>Users:</h2>
<ul>
    <#list users as user>
        <li>${user.username} (${user.email})</li>
    </#list>
</ul>

</body>
</html>

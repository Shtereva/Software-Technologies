<form>
    <div>Name:</div>
    <input type="text" name="person">
    <div>Age:</div>
    <input type="text" name="age">
    <div>Town:</div>
    <select name="townID">
        <option value="10">Sofia</option>
        <option value="20">Varna</option>
        <option value="30">Plovdiv</option>
    </select>
    <div><input type="submit"></div>
</form>

<?php
var_dump($_GET); ?>
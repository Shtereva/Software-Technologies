<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
</head>
<body>
<?php
for ($rows = 1; $rows <= 9; $rows++){
    for ($col = 1; $col <= 5; $col++){
        if ($rows == 1 || $rows == 5 || $rows == 9){
            echo "<button style='background-color: blue'>1</button>";
        }
        else{
       if (($rows >= 2 && $rows <= 4 && $col == 1) || ($rows >= 6 && $rows <= 8 && $col == 5)){
            echo "<button style='background-color: blue'>1</button>";
        }
        else{
            echo "<button>0</button>";
        }
        }
    }
        echo "<br>";
}
?>
</body>
</html>
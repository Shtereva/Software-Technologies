<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
    <style>
        div {
            display: inline-block;
            margin: 5px;
            width: 20px;
            height: 20px;
        }
    </style> 
</head>
<body>
<?php
$colorOne = 0;
for ($rows = 1; $rows <= 5; $rows++){

    for ($col = 1; $col <= 10; $col++){
        echo "<div style='background-color: rgb(<?=$colorOne;?>, <?=$colorOne;?>, <?=$colorOne;?>)'></div>";
        $colorOne += 5;
    }
    $colorOne = 51 * $rows;
    echo "<br>";
}
?>
</body>
</html>
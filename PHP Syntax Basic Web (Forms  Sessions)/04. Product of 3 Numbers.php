<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
    <form>
        X: <input type="text" name="num1" />
		Y: <input type="text" name="num2" />
        Z: <input type="text" name="num3" />
		<input type="submit" />
    </form>
    <?php
    if (isset($_GET['num1']) && isset($_GET['num2']) && isset($_GET['num3'])){
        $num1 = intval($_GET['num1']);
        $num2 = intval($_GET['num2']);
        $num3 = intval($_GET['num3']);
        $arr = [$num1, $num2, $num3];
        $count = 0;
        foreach ($arr as $item) {
            if ($item === 0){
                echo "Positive";
                return;
            }
            if ($item < 0){
                $count++;
            }
        }
        echo $count % 2 == 0 ? "Positive" : "Negative";
    }
    ?>
</body>
</html>
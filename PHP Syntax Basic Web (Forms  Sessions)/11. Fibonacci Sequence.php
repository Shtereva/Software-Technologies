<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" />
    </form>
    <?php
    if (isset($_GET['num'])){
        $num = intval($_GET['num']);
        $prevNum = 1;
        $result = 1;
        $arr = [$prevNum, $result];
        while (count($arr) < $num){
            $oldNum = $result;
            $result += $prevNum;
            $prevNum = $oldNum;
            $arr[] = $result;
        }
        echo implode(" ", $arr);
    }
    ?>
</body>
</html>
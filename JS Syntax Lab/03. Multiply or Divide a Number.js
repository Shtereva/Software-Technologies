function solve(input) {
    let n = Number(input[0]);
    let x = Number(input[1]);
    let result = x >= n ? x * n : n / x;
    console.log(result);
}

solve(['144', '12']);
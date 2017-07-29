function solve(input) {
    let nums = [];
    for (let num of input){
        nums.push(Number(num));
    }

    console.log(nums
        .sort((a, b) => b - a)
        .slice(0, 3)
        .join("\r\n"));

}

solve(['10', '10', '20', '50']);
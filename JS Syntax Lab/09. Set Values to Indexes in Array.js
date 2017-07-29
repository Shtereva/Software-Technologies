function solve(input) {
    let len = Number(input[0]);
    let result = [];
    result.length = len;
    for(i = 0; i < len; i++){
        result[i] = 0;
    }


    for (i = 1; i < input.length; i++){
        let line = input[i].split(" - ").map(Number);
        result[Number(line[0])] = Number(line[1]);
    }

    console.log(result.join("\r\n"));
}

solve([ '5', '0 - 3', '3 - -1', '4 - 2' ]);
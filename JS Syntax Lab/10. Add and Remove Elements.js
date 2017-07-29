function solve(input) {
    let result = [];

    for (let line of input){
        let tokens = line.split(" ");
        let command = tokens[0];
        let argument = Number(tokens[1]);

        switch (command){
            case "add":
                result.push(argument);
                break;
            case "remove":
                result.splice(argument, 1);
                break;
        }
    }

    console.log(result.join("\r\n"));
}

solve([ 'add 3', 'add 5', 'remove 2', 'remove 0', 'add 7' ]);
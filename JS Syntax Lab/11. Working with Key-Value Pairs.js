function solve(input) {
    let result = new Map();
    let key = "";
    for(let line of input){
        let tokens = line.split(" ");

        if(tokens.length < 2){
            key = tokens[0];
            break;
        }
        if(!(tokens[0] in result)){
            result[tokens[0]] = "";
        }

        result[tokens[0]] = tokens[1];
    }

    console.log(key in result ? result[key] : "None");
}

solve([ '3 bla', '3 alb', '2' ]);
function solve(input) {
    let obj = new Map();

    for(let kvp of input){
        let line = kvp.split(" -> ");
        let key = line[0];
        let value = key === "grade" || key === "age" ? parseInt(line[1]) : line[1];

        if(!(key in obj)){
            obj[key] = "";
        }

        obj[key] = value;
    }

    console.log(JSON.stringify(obj));
}

solve([ 'name -> Angel', 'surname -> Georgiev', 'age -> 20', 'grade -> 6.00'
, 'date -> 23/05/1995', 'town -> Sofia' ]);
function solve(input) {
    let result = [];

    for(let item of input) {

        function jsonParse() {
            let line = JSON.parse(item);
            return `Name: ${line.name}\r\nAge: ${line.age}\r\nDate: ${line.date}`;
        }

        result.push(jsonParse());
    }
    console.log(result.join("\r\n"));
}

solve([ '{"name":"Gosho","age":10,"date":"19/06/2005"}',
    '{"name":"Tosho","age":11,"date":"04/04/2005"}',
    '{"name":"Maria","age":24,"date":"31/12/1996"}' ]);
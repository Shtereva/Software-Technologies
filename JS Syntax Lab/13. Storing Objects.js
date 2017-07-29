function solve(input) {
    let result = [];

    for(let line of input){
        let tokens = line.split(" -> ");
        function person() {
            this.name = tokens[0];
            this.age = tokens[1];
            this.grade = tokens[2];
            return `Name: ${this.name}\r\nAge: ${this.age}\r\nGrade: ${this.grade}`;
        }

        result.push(person());
    }

    console.log(result.join("\r\n"));
}

solve(['Pesho -> 13 -> 6.00', 'Ivan -> 12 -> 5.57', 'Toni -> 13 -> 4.90']);
function solve(input) {
    let count = input
        .map(Number)
        .filter(x => x < 0)
        .length;
    if(input.map(Number).some(x => x === 0)){
        console.log("Positive");
        return;
    }
    console.log(count % 2 !== 0 ? "Negative" : "Positive");
}

solve([ '0', '-4', '5' ]);
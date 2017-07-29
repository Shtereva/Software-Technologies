function solve(input) {
    input
        .map(Number)
        .reverse()
        .forEach(x => console.log(x));
}

solve([ '10', '15', '20' ]);
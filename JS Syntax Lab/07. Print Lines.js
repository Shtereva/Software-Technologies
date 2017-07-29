function solve(input) {
    let index = input.findIndex(x => x === "Stop");
    input
        .slice(0, index)
        .forEach(x => console.log(x));
}

solve([ 'Line 1', 'Line 2', 'Line 3', 'Stop' ]);
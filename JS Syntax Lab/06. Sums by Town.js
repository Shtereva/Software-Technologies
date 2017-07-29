function solve(input) {

    let allTowns = {};
    for (let json of input){
        let obj = JSON.parse(json);
        if(!(obj.town in allTowns)){
            allTowns[obj.town] = 0;
        }
        allTowns[obj.town] += obj.income;
    }
    for(let sortedTown of Object.keys(allTowns).sort((a, b) => a.localeCompare(b))){
        console.log(`${sortedTown} -> ${allTowns[sortedTown]}`);
    }
}

solve([ '{"town":"Sofia","income":200}',
'{"town":"Varna","income":120}',
'{"town":"Pleven","income":60}',
'{"town":"Varna","income":70}' ]);

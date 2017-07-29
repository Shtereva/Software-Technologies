function solve(input) {
    let num = Number(input[0]);

    for(i = 1; i <= num; i++){

        let str = i.toString().split('').reverse().join('');


        if(i.toString() === str){
            console.log(i + " ");
        }
    }
}

solve(['750']);
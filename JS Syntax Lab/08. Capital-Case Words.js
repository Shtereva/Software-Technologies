function solve(input) {
    let result = [];
    for(let line of input){
        let pattern = /\b[A-Z]+\b/g;
        let matches = line.match(pattern);
        result.push(matches.join(", "));
    }
    console.log(result.join(", "));

}

solve([ 'We start by HTML, CSS, JavaScript, JSON and REST.',
    'Later we touch some PHP, MySQL and SQL.',
    'Later we play with C#, EF, SQL Server and ASP.NET MVC.',
    'Finally, we touch some Java, Hibernate and Spring.MVC.' ]);
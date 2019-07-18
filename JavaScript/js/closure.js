//A closure is a function having access to the parent scope, even after the parent function has closed.
// inner function can have access to the outer function variables as well as all the global variables.
function foo(outer_arg) { 
  
    function inner(inner_arg) { 
        return outer_arg + inner_arg; 
    } 
    return inner; 
} 
var get_func_inner = foo(5); 
  
console.log(get_func_inner(4)); 
console.log(get_func_inner(3));
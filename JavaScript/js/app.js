function testingFuncAsAparam(a,b){
    a();
    b();
}

function fun1(){
    return function(){
        console.log('I am returned ');
    }
}

function fun2(){
    console.log("I am fun2");
}

testingFuncAsAparam(fun1(),fun2);
/* ---------------------------------------------------------------------------------------------------*/

 var person1={
    name : 'ABHISHEK',
    age : 22,
    sal : 290
};

/*
var abc = "name";
person1[abc];
*/
var person2 = {};

for(var key in person1){
    console.log(key);
    person2[key] = person1[key];
}

/*--------------------------------------------------------------------------------------------------------*/
var buttonElem = document.getElementById('btn');
buttonElem.addEventListener('click',handleClick);

function handleClick(){
    var n1 = document.getElementById('n1').value;
    var n2 = document.getElementById('n2').value;
    console.log(parseInt(n1) + parseInt(n2));
}

/*----------------------------------------------------------------------------------------------------*/
//prototype in javascript

function Person(name){
    this.name = name;
}

Person.prototype.getName = function(){
    return this.name;
}

var p1 = new Person('Virat');
p1.getName = funtion();

/*-----------------------------------------------------------------------------------------------------*/
//AJAX
var btn = document.querySelector("#start");
btn.addEventListener('click',function(){
     var timeElapsed = 0;

     setInterval(function(){
         timeElapsed++;
         document.querySelector('#time').innerHTML = timeElapsed;
     },1000);
}); 
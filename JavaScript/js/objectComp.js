var person1 = {
    name : "ABHISHEK",
    age : 22,
    sal : 300
};

var person2 = {
    name : "ABHISHEK",
    age : 22,
    sal : 300
};

var checkEq = true;

function objComp(person1,person2){
    for(var key in person1){
        if(person1[key] != person2[key]){
            checkEq = false;
            break;
        }
    }
}

objComp(person1,person2);

if(checkEq){
    console.log("true");
}
else{
    console.log("false");
}

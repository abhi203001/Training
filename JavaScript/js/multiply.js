function multiply(){
    var num1 = parseInt(document.getElementById("n1").value);
    var num2 = parseInt(document.getElementById("n2").value);
    console.log(num1 * num2);
    document.getElementById('output').innerHTML = " Multiplication of above numbers is" + " = " + (num1*num2);
}
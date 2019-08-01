document.getElementById('start').addEventListener('click', startTimer);
document.getElementById('stop').addEventListener('click', stopTimer);

var forStop;

function startTimer() {
    var date = new Date();
    var hr = date.getHours();
    var min = date.getMinutes();
    var sec = date.getSeconds();

    document.getElementById('show').innerHTML = check(hr) + " : " + check(min) + " : " + check(sec);
    forStop = setTimeout(startTimer, 1000);
}

function check(val) {
    if (val < 10) {
        return "0" + val;
    }
    else {
        return val;
    }
}

function stopTimer() {
    clearTimeout(forStop);
}


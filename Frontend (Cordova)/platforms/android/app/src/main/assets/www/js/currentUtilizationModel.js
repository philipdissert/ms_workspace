var request = new XMLHttpRequest();
request.open('GET', 'http://localhost:8080/layout', true);
request.onload = function() {
    var data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {
        iteratePoolElements(data);
        //iterateRooms(data);
    } else {
        console.log('error');
    }
}
request.send();

/* var request2 = new XMLHttpRequest();
request2.open('GET', 'http://localhost:8080/currentState', true);
request2.onload = function() {
    var data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {
        console.log(data.data);
        iterateCurrentStates(data);
    } else {
        console.log('error');
    }
}
request2.send();
*/
var request = new XMLHttpRequest();
request.open('GET', 'http://localhost:8080/layout', true);
request.onload = function() {
    var data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {
        iterateRooms(data);
        iteratePoolElements(data);
    } else {
        console.log('error');
    }
}
request.send();

var request2 = new XMLHttpRequest();
request2.open('GET', 'http://localhost:8080/currentState', true);
request2.onload = function() {
    var data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {
        iterateCurrentStates(data);
    } else {
        console.log('error');
    }
}
request2.send();

var request3 = new XMLHttpRequest();
request3.open('GET', 'http://localhost:8080/currentUtilization', true);
request3.onload = function() {
    var data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {
        paragraphs(data);
    } else {
        console.log('error');
    }
}
request3.send();
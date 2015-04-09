/**
 * Created by Guillaume on 4/9/2015.
 */

var lille = new google.maps.LatLng(50.62925, 3.057256000000052);
var marseille = new google.maps.LatLng(43.296482, 5.369779999999992);
var departure;
var arrival;
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var steps = new Array();

var waypts = [];
var map;

google.maps.event.addDomListener(window, 'load', initialize);

function addStepToArray(latStep, lonStep) {
    console.log("Adding step: " + latStep + " / " + lonStep);

    if(steps.length == 0) {
        steps[0] = new Array();
        steps[0][0] = latStep;
        steps[0][1] = lonStep;
    }
    else {
        steps[steps.length-1] = new Array();
        steps[steps.length-1][0] = latStep;
        steps[steps.length-1][1] = lonStep;
    }
    console.log("Added step: " + steps[steps.length-1][steps.length-1]);
}

function initialize() {
    directionsDisplay = new google.maps.DirectionsRenderer();
    var mapOptions = {
        zoom: 6,
        center: lille
    }
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    directionsDisplay.setMap(map);
    departure = new google.maps.LatLng(steps[0][0],steps[0][1]);
    arrival = new google.maps.LatLng(steps[steps.length-1][0],steps[steps.length-1][1]);
    steps.splice(steps[0], 1);
    steps.splice(steps[steps.length-1], 1);

    calcRoute(departure, arrival, steps)
}

function calcRoute(start, end, waypts) {
    console.log("steps size: " + steps.length);
    var request = {
        origin: departure,
        destination: arrival,
        waypoints: steps,
        optimizeWaypoints: true,
        travelMode: google.maps.TravelMode.DRIVING
    };
    directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
};

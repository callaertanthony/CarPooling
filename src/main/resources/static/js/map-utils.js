/**
 * Created by Guillaume on 4/9/2015.
 */
var lille = new google.maps.LatLng(50.62925, 3.057256000000052);
var departure;
var arrival;
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var steps;
var waypoints = [];
var i = 0;
var y = 0;
var total = 0;
var map;

function setTotal(size) {
    total = size;
}

function addStepToArray(latStep, lonStep) {
    console.log("Adding step: " + latStep + " / " + lonStep + " at " + i);
    if(i==0)
    {
        departure = new google.maps.LatLng(latStep,lonStep);
        console.log("Added departure");

    } else if ( i == total-1) {
        arrival = new google.maps.LatLng(latStep,lonStep);
        console.log("Added arrival");
    } else {
        var t = new google.maps.LatLng(latStep,lonStep);
        waypoints.push({
            location: t,
            stopover:true
        });
        console.log("Added waypoints at " + y);
        y++;
    }
    i++;
}

function initialize() {
    console.log("Initialisation..");
    directionsDisplay = new google.maps.DirectionsRenderer();
    var mapOptions = {
        zoom: 6,
        center: lille
    }
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    directionsDisplay.setMap(map);

    calcRoute();
}
google.maps.event.addDomListener(window, 'load', initialize);

function calcRoute() {
    console.log("In calcRoute() with " + waypoints.length + " waypoints");
    var request = {
        origin: departure,
        destination: arrival,
        waypoints: waypoints,
        optimizeWaypoints: true,
        travelMode: google.maps.TravelMode.DRIVING
    };
    directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
};

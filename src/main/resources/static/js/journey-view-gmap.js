/**
 * Created by Guillaume on 10/04/2015.
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
    if(i==0)
    {
        departure = new google.maps.LatLng(latStep,lonStep);

    } else if ( i == total-1) {
        arrival = new google.maps.LatLng(latStep,lonStep);
    } else {
        var t = new google.maps.LatLng(latStep,lonStep);
        waypoints.push({
            location: t,
            stopover:true
        });
        y++;
    }
    i++;
}

function initialize() {
    directionsDisplay = new google.maps.DirectionsRenderer();
    var mapOptions = {
        zoom: 6,
        center: lille
    }
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    directionsDisplay.setMap(map);

    calcRoute(departure, arrival, waypoints);
}
google.maps.event.addDomListener(window, 'load', initialize);
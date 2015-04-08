$("#add-new-step").click(function () {
    var canAdd = true;
    $('[id^="geocomplete"]').each(function(){
        if($(this).val() == ""){
            canAdd = false;
        }
    })
    if(canAdd){
        //get the template
        var template = $(this).attr('data-template');
        //create the element in the dom before the last in <ul>
        $("#user-journey li:last").before(template);
        //restore geocomplete and sortable
        initSortable();
        initGeocomplete();
        //disable inputs
        disableInput();
    }
});

$("#journeyForm").submit(function() {
    $('#user-journey li:not(.ui-state-disabled) .timeline-label').each(function(i){
        var re = new RegExp('__index__', 'g');
        $(this).children().each(function(){
            $(this).attr('id', $(this).attr('id').replace(re, i));
            $(this).attr('name', $(this).attr('name').replace(re, i));
        });
    });
});

function initSortable(){
    $("#user-journey").sortable({
        items: "li:not(.ui-state-disabled)",
        cursor: "move",
        create: function(event, ui){
            initGeocomplete();
            //maybe useless but do it again to be sur !
            disableInput();
        },
        update: function(event, ui){
            disableInput();
        }
    })
}

initSortable();


function initGeocomplete(){
    $(".geocomplete").each(function() {
        $(this).geocomplete({
            types: ["geocode"],
            details: $(this).parent(),
            detailsAttribute: "data-geo"
        }).bind("geocode:result", function(event, result){
            calcJourney();
        })
    });
}

function disableInput(){
    //force activate firsts inputs
    $('[id^="steps"][id$=".date"]').slice(0,0).prop("disabled", false);
    $('[id^="steps"][id$=".time"]').slice(0,0).prop("disabled", false);
    //we disable all the date input exclude the first one
    $('[id^="steps"][id$=".date"]').slice(1).prop("disabled", true);
    //we disable all the time input exclude the first one
    $('[id^="steps"][id$=".time"]').slice(1).prop("disabled", true);
}

var lille = new google.maps.LatLng(50.62925, 3.057256000000052);
var marseille = new google.maps.LatLng(43.296482, 5.369779999999992);
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;

function initialize() {
    directionsDisplay = new google.maps.DirectionsRenderer();
    var mapOptions = {
        zoom: 6,
        center: lille
    }
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    directionsDisplay.setMap(map);
}

function calcRoute(start, end, waypts) {
    waypts.push({
        location: new google.maps.LatLng(45.764043, 4.835658999999964),
        stopover:true
    });

    var request = {
        origin: start,
        destination: end,
        waypoints: waypts,
        optimizeWaypoints: true,
        travelMode: google.maps.TravelMode.DRIVING
    };
    directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
};

google.maps.event.addDomListener(window, 'load', initialize);

var distanceMatrixService = new google.maps.DistanceMatrixService();

var duration;

function calcDistance(start, dest){
    distanceMatrixService.getDistanceMatrix(
        {
            origins: [start],
            destinations: [dest],
            travelMode: google.maps.TravelMode.DRIVING
        }, callbackDistance
    );
}

function callbackDistance(response, status){
    if (status == google.maps.DistanceMatrixStatus.OK) {
        var element = response.rows[0].elements[0];
        var distance = element.distance.value;
        duration = element.duration.value;
    }
}



function calcJourney(){
    var liSteps = $("#user-journey").children().slice(0,-1);
    var start, dest, time, hours, minutes, date, year, month, day, arrivalDate, element;
    if(liSteps.length == 1){
        return;
    }
    for(i = 1; i < liSteps.length; i++){
        start = new google.maps.LatLng($('[name$=".lat"]', liSteps[i-1]).val(), $('[name$=".lng"]', liSteps[i-1]).val());
        dest = new google.maps.LatLng($('[name$=".lat"]', liSteps[i]).val(), $('[name$=".lng"]', liSteps[i]).val());
        calcDistance(start, dest);
        setTimeout(function(){
            console.log("duration : " + duration);
            time = $('[id^="steps"][id$=".time"]', liSteps[i-1]).val();
            hours = +time.substring(0,2);
            minutes = +time.substring(3,5);
            console.log("h : " + hours);
            console.log("m : " + minutes);
            date = $('[id^="steps"][id$=".date"]', liSteps[i-1]).val();
            year = +date.substring(0,4);
            month = +date.substring(5,7) - 1;
            day = +date.substring(8,10);
            console.log("year :" + year);
            console.log("month :" + month);
            console.log("day : " + day);
            arrivalDate = new Date(year, month, day, hours, minutes, duration);
            console.log(arrivalDate);
            //set the time
            hours = convert2digits(arrivalDate.getHours());
            minutes = convert2digits(arrivalDate.getMinutes());
            //set time in the li element
            $('[id^="steps"][id$=".time"]', element).attr("value", hours + ":" + minutes + ":00");
            //set the date
            year = convert2digits(arrivalDate.getFullYear());
            month = convert2digits(arrivalDate.getMonth() + 1);
            day = convert2digits(arrivalDate.getDate());
            element = liSteps[i];
            //set date in the li element
            $('[id^="steps"][id$=".date"]', element).attr("value", year + "-" + month + "-" + day);
        }, 2000);
    }
}

function convert2digits(n){
    return n > 9 ? "" + n : "0" + n;
}
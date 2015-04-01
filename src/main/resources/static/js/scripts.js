$("#add-new-step").click(function () {


    $("#user-journey article:last").before($(
        '<article class="timeline-entry">' +
        '<div class="timeline-entry-inner">' +
        '    <time class="timeline-time" datetime="2014-01-10T03:45"><span>00-00-00</span></time>' +
        '    <div class="timeline-icon bg-success">' +
        '    <i class="entypo-feather"></i>' +
        '    </div>' +
        '    <div class="timeline-label">' +
        'TEST -> INSERTION D\'UNE NOUVELLE STEP ICI'+
        '    </div>' +
        '    </div>' +
        '    </article>')
    );
});
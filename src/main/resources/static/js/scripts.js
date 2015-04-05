$("#add-new-step").click(function () {
    var template = $(this).attr('data-template');
    $("#user-journey li:last").before(template);
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

$("#user-journey").sortable({
    items: "li:not(.ui-state-disabled)",
    cursor: "move"
});
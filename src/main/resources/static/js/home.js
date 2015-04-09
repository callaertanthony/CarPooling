/**
 * Created by Guillaume on 4/9/2015.
 */
$(function(){
    $(".geocomplete").each(function() {
        $(this).geocomplete({
            types: ["geocode"],
            details: $(this).parent(),
            detailsAttribute: "data-geo"
        })
    });
});
/**
 * Created by Jim on 04.10.2017.
 */
$(document).ready(function() {
    setInterval(updateTables(), 2000) //updates quiz tables every 2 seconds
    $("#quiz1").click(function() {
        window.location.href = "livequiz.html";
    });
    updateTables();
});

function updateTables() {
    /*var quizes = $.ajax({
        url: "rest/quizes/",
        type: 'GET'
    });*/
    $("#quiz1").show();
    $("#quiz1").html("Cows");

}
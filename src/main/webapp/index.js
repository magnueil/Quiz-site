/**
 * Created by Jim on 04.10.2017.
 */

$(document).ready(function() {
    /*$.get("rest/thepath", function(data){
     $("#myid").html(data);
     });*/
    /*$("form").submit(function(event) {
        $.ajax({
            url: 'rest/users/',
            type: 'POST',
            data: JSON.stringify({
                userId: $("#userid").val(),
                nickName: $("#nickname").val()
            }),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(result) {

            }
        });

        sessionStorage.nickname=$("#nickname").val();
    });//*/
    $("button").click(function() {
        var n = Math.floor(Math.random()*1000);
        var newId = n.toString();
        console.log("User id: " + newId);
        sessionStorage.nickname=$("#nickname").val();
        sessionStorage.userId=newId;
        $.ajax({
            url: 'rest/users/',
            type: 'POST',
            data: JSON.stringify({
                userId: newId,
                nickName: $("#nickname").val()
            }),
            contentType: 'application/json; charset=utf-8',
        });
        window.location.href = "quizlist.html";
    })
});
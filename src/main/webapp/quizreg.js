/**
 * Created by Jim on 04.10.2017.
 */
$(document).ready(function() {
    var quizId = "";
    var visibleOptions = 2;
    var qCount = 1;

    $("#question").toggle();
    $(".o3,.o4,.o5,.o6,.o7,.o8").toggle();
    //$("#btnsubmit").hide();

    function clearQuestion() {
        $("#questionText,#questionId,#picURL,#questionTimer,#a1,#r1,#a2,#r2,.o3,.o4,.o5,.o6,.o7,.o8").val("");
        $(".o3,.o4,.o5,.o6,.o7,.o8").hide();
    }

    $("#createquiz").click(function() {
        var n = Math.floor(Math.random()*1000);
        var newId = n.toString();
        $.ajax({
            url: 'rest/quizes/',
            type: 'POST',
            data: JSON.stringify({
                quizId: newId,
                quizName: $("#quizname").val(),
                startTime: $("#starttime").val(),
                creatorNick: sessionStorage.nickname
            }),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            failure: function() {
                alert("Something went wrong, please try again");
            },
            success: function(data) {
                quizId = data;
                console.log("Quiz id: " + data);
                $("#quizdiv").hide();
                $("#question").show();
            }
        });
    });

    $("#addOption").click(function() {
        switch(visibleOptions) {
            case 2:
                visibleOptions++;
                $(".o3").show();
                break;
            case 3:
                visibleOptions++;
                $(".o4").show();
                break;
            case 4:
                visibleOptions++;
                $(".o5").show();
                break;
            case 5:
                visibleOptions++;
                $(".o6").show();
                break;
            case 6:
                visibleOptions++;
                $(".o7").show();
                break;
            case 7:
                visibleOptions++;
                $(".o8").show();
                break;
            case 8:
                alert("You can't have more than 8 options in this release");
                break;
        }
    });

    $("#addQuestion").click(function() {
        var n = Math.floor(Math.random()*1000);
        var newId = n.toString();
        var options = [];
        for(var i = 1; i<=visibleOptions;i++) {
            options.push($("#a"+i).val())
        }
        $.ajax({
            url: 'rest/quizes/' + quizId +'/questions/',
            type: 'POST',
            data: JSON.stringify({
                qId: newId,
                qText: $("#questionText").val(),
                qTime: $("#questionTimer").val(),
                qOptions: options,
                picURL: $("#picURL").val(),
                qAnswer: $("input[name=rightOption]:checked").val()
            }),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function(result) {
                $("#btnsubmit").show();
            }
        });
        qCount++;
        $("#questionLegend").html("Question " + qCount);
        clearQuestion();

    });
    $("#btnsubmit").click(function() {
        window.location.href = "quizlist.html";
    })
});
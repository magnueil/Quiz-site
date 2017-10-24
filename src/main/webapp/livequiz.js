/**
 * Created by Jim on 04.10.2017.
 */
$(document).ready(function() {
    var quizTitle = "Cows";
    var questionCount = 2;
    var questionIndex = 0;
    var interval = 5000;
    var optionCount = 2;
    var displayedDivs = 8;
    var question;
    var questionTime;
    var options = [];
    var rightAnswer = -1;
    var picURL;
    var timer;
    var scores = [];
    //var questions = $.get("/rest/quizes/" + sessionStorage.quizid + "/");
    /*function getParameterByName(name, url) { // function gotten from https://stackoverflow.com/questions/901115/how-can-i-get-query-string-values-in-javascript
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
            results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    } */

    function updateQuestion() {
        questionIndex++;
        switch(questionIndex) {
            case 1:
                setPremadeOne();
                break;
            case 2:
                setPremadeTwo();
                break;
            default:
                // loadQuestion(questionIndex);
        }
        timer = questionTime;
        displayDivs();
        for(var i = 1; i <= optionCount; i++) {
            $("#option"+i).html(options[i-1]);
        }
        $("#question").html(question);
        $("#quizTitle").html(quizTitle);
        if(picURL.length > 6) {
            $("#questionImage").show();
            $("#questionImage").html("<img src =\"" + picURL + "\">");
        } else {
            $("#questionImage").hide();
            $("#questionImage").html("<img src =\"" + picURL + "\">");
        }
    }

    // Preprogrammed content because I can't get REST to work. Ideally they should've been gotten
    // from the REST server or from a quiz object previously loaded from the server
    function setPremadeOne() {
        optionCount = 4;
        question = "How many stomachs does a cow have?";
        questionTime = 20;
        options = ["1","2","4","13"];
        rightAnswer = 3;
        picURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/CH_cow_2_cropped.jpg/1024px-CH_cow_2_cropped.jpg";
    }

    function setPremadeTwo() {
        optionCount = 3;
        question = "What is the scientific name for cattle?";
        questionTime = 20;
        options = ["Cowus Laticus","Bos taurus","Bos primigenus"];
        rightAnswer = 2;
        picURL = "";
    }

    function displayDivs() {
        if(displayedDivs > optionCount) {
            for(var i = displayedDivs; i > optionCount; i--) {
                $("#div"+i).hide();
            }
        } else if(displayedDivs < optionCount) {
            for(var i = displayedDivs; i < optionCount; i++) {
                $("#div"+i).show();
            }
        }
        displayedDivs = optionCount;
    }

    function clickAnswer(option) {
        //$("#answerModal").show();
        if(option == rightAnswer) {
            var pointsRewarded = timer/questionTime*1000;
            alert("That's correct, you get " + pointsRewarded + " points!");
            scores[0] += pointsRewarded;
            $("#score1").html(pointsRewarded);
            updateQuestion();
        } else {
            alert("That's wrong, you get 0 points!");
            updateQuestion();
        }
        if(optionCount == questionIndex) {
            clearInterval(timerIntervalId);
        }
    }

    $("#option1").click(function() {clickAnswer(1)});
    $("#option2").click(function() {clickAnswer(2)});
    $("#option3").click(function() {clickAnswer(3)});
    $("#option4").click(function() {clickAnswer(4)});
    $("#option5").click(function() {clickAnswer(5)});
    $("#option6").click(function() {clickAnswer(6)});
    $("#option7").click(function() {clickAnswer(7)});
    $("#option8").click(function() {clickAnswer(8)});

    /*
    $("#closeModal").click(function() {
        $("#answerModal").hide();
    });

    window.onclick = function(event) {
        if(event.target == $("#answerModal")) {
            $("#answerModal").hide();
        }
    };//*/

    updateQuestion();
    $("#user1").html(sessionStorage.nickname);
    var timerIntervalId = setInterval(function() {
        if(timer > 0) {
            $("#timerText").html(timer);
            timer--;
        } else {
            alert("Time\'s up! No points for you");
            updateQuestion();
        }
    }, 1000);
});
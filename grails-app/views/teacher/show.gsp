<html>
<head>
    <meta name="layout" content="main">
    <title>Question ${question.id}</title>
</head>
<body>



<tmpl:question_listing question="${question}"/>


<div class="answer-form-container">
    <form action="/teacher/addanswer" method="post" class="form-inline">
        <input type="hidden" name="question_id" id="question_id" value="${question.id}" class="form-control"/>
        <div class="form-group">
            <label for="text" >Answer:</label>
            <input type="text" name="text" id="text" class="form-control">
        </div>
        <div class="checkbox">
            <label for="isCorrect">
                <input type="checkbox" name="isCorrect" id="isCorrect">
                Is the correct answer
            </label>
        </div>
        <g:submitButton name="Submit" value="Add Answer"  class="form-control btn-primary" />
    </form>
    <div style="color: red">
        <g:renderErrors bean="${question}" />
    </div>
</div>

</body>
</html>
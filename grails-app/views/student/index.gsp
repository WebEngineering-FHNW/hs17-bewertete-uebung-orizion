<html>
<head>
    <meta name="layout" content="main"/>
    <title>
        Answer the Questions
    </title>
    <style>
    output { margin-left: 2em;}
    </style>
</head>

<body>
<div class="jumbotron">
    <h1>Answer the Questions</h1>
</div>
    <form action="/student/submit_answers" method="post">
    <g:each var="question" in="${questions}">
        <div class="panel panel-default">
            <div class="panel-heading">Question:</div>
            <div class="panel-body">${question.text}</div>
        </div>

        <div class="answer-list">
            <h3>Answers:</h3>
            <input type="hidden" name="question_ids" value="${question.id}" />
            <g:each var="answer" in="${question.answers}">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="q_${question.id}_answer_ids" value="${answer.id}" />
                        ${answer.text}
                    </label>
                </div>
            </g:each>
        </div>
    </g:each>
        <g:submitButton name="Submit" value="Submit Answers"  class="btn btn-primary" />
    </form>
</body>

</html>
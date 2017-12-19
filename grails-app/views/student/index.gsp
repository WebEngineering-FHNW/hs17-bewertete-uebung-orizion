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
    <g:each var="question" in="${questions}">
        <div class="panel panel-default">
            <div class="panel-heading">Question ${question.id}</div>
            <div class="panel-body">${question.text}</div>
        </div>

        <div class="answer-list">
            <h3>Answers:</h3>
            <form action="/student/submit_answers" method="post">
                <input type="hidden" name="question_id" value="${question.id}" />
                <g:each var="answer" in="${question.answers}">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="answer_ids" value="${answer.id}" />
                            ${answer.text}
                        </label>
                    </div>
                </g:each>
            </form>

        </div>
    </g:each>
    <g:submitButton name="Submit" value="Submit Answers"  class="btn btn-primary" />
</body>

</html>
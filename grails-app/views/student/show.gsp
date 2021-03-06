<html>
<head>
    <meta name="layout" content="main">
    <title>Question ${question.id}</title>
</head>
<body>

<div class="panel panel-default">
    <div class="panel-heading">Question ${question.id}</div>
    <div class="panel-body">${question.text}</div>
</div>



<div class="answer-list">
    <h3>Answers:</h3>
    <g:if test="${question.answers.size() > 0}">
        <form action="/student/submit_answer" method="post">
            <input type="hidden" name="question_id" value="${question.id}" />
            <g:each var="answer" in="${question.answers}">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="answer_ids" value="${answer.id}" />
                        ${answer.text}
                    </label>
                </div>
            </g:each>
            <g:submitButton name="Submit" value="Submit Answer"  class="btn btn-primary" />
        </form>
    </g:if>
    <g:else>
        <p>
            There are currently no answers registered for the current question
        </p>
    </g:else>
</div>


</body>
</html>
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
    <table class="table table-striped">
    <thead>
        <tr>
            <th>Answer</th>
            <th>Correct answer?</th>
        </tr>
    </thead>
        <tbody>
        <g:each var="answer" in="${question.answers}">
            <tr>
                <td>
                    ${answer.text}
                </td>
                <g:if test="${answer.isCorrect}">
                    <td class="success">
                        Yes
                    </td>
                </g:if>
                <g:else>
                    <td class="danger">
                        No
                    </td>
                </g:else>
            </tr>
        </g:each>
        </tbody>
    </table>
    <ul>

    </ul>
</div>
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
</div>

</body>
</html>
<div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <a href="/teacher/show/${question.id}">
                Question ${question.id}
            </a>
        </div>
        <div class="panel-body">${question.text}</div>
    </div>
    <div class="answer-list">
        <h3>Answers:</h3>
        <g:if test="${question.answers.size() > 0}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Answer</th>
                <th>Correct</th>
                <g:if test="${answerCount != null}">
                    <th>Times this answer was chosen</th>
                </g:if>
                <th></th>
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

                    <g:if test="${answerCount != null}">
                        <td>
                            ${answerCount[answer.id]}
                        </td>
                    </g:if>
                    <td>
                        <form action="/teacher/removeanswer/${answer.id}" method="post">
                            <input type="submit" value="Remove Answer" class="btn btn-danger"/>
                        </form>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
        </g:if>
        <g:else>
            <p>
                There are currently no answers registered for the current question
            </p>
        </g:else>
    </div>
</div>

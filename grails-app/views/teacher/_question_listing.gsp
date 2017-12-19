<div>
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
                <th>Correct</th>
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
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>

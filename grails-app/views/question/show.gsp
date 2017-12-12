<html>
<head>
    <meta name="layout" content="main">
    <title>Question ${question.id}</title>
</head>
<body>

<h3>Question ${question.id}</h3>
<p>
    ${question.text}
</p>
<g:if test="${question.isMultipleChoice}">
    multiple question
</g:if>
<g:else>
    NOT multiple choice
</g:else>
<div class="answer-list">
    <h3>Answers:</h3>
    <ul>
        <g:each var="answer" in="${answers}">
            <li>${answer.text}
            <g:if test="${answer.isCorrect}">
                right answer
            </g:if>
            <g:else>
                wrong answer
            </g:else>
            </li>
        </g:each>
    </ul>
</div>
<div class="answer-form-container">
    <form action="/question/addanswer" method="post">
        <input type="hidden" name="question_id" id="question_id" value="${question.id}" />
        <label for="text" >Answer:</label> <br>
        <input type="text" name="text" id="text"><br>
        <input type="checkbox" name="isCorrect" id="isCorrect">
        <label for="isCorrect">Is the correct answer</label><br>
        <g:submitButton name="Submit" value="Submit" />
    </form>
</div>

</body>
</html>
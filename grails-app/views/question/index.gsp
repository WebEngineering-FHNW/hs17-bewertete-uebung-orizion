<html>
<head>
    <meta name="layout" content="form"/>
    <title>
        Create Question
    </title>
    <style>
    output { margin-left: 2em;}
    </style>
</head>

<body>
<g:each var="question" in="${questions}">
    <li>${question.text}
        <g:if test="${question.isMultipleChoice}">
            multi
        </g:if>
        <g:else>
            NOT multi
        </g:else>
    </li>
</g:each>
</body>

</html>
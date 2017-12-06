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
<h3>Answers:</h3>
<ul>
    <g:each var="answer" in="${answers}">
        <li>${answer.text}</li>
    </g:each>
</ul>

</body>
</html>
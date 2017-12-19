<html>
<head>
    <meta name="layout" content="main"/>
    <title>
        List of all Questions
    </title>
    <style>
    output { margin-left: 2em;}
    </style>
</head>

<body>
<div class="jumbotron">
    <h1>List of all Questions</h1>
</div>
    <g:each var="question" in="${questions}">
        <tmpl:question_listing question="${question}"/>
    </g:each>
</body>

</html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>
        Create Question
    </title>
    <style>
    output { margin-left: 2em;}
    </style>
</head>

<body>
<g:each var="question" in="${questions}">
    <tmpl:question_listing question="${question}"/>
</g:each>
</body>

</html>
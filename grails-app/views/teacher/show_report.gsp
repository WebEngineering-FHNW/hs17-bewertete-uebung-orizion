<html>
<head>
    <meta name="layout" content="main">
    <title>Report</title>
</head>
<body>


<g:each var="question" in="${questions}">
    <tmpl:question_listing question="${question}" />
</g:each>
</body>
</html>
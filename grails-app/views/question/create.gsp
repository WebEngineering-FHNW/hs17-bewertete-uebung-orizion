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

<form action="/question/save" method="post">
    <fieldset class="form padded">
        <input type="text" name="text" />
        <label for="isMultipleChoice" >multiple choice question</label>
        <input type="checkbox" name="isMultipleChoice" id="isMultipleChoice">
        <div>
            <label>&nbsp;</label>
            <input type="submit" value="Save"/>
        </div>
    </fieldset>
</form>


</body>
</html>


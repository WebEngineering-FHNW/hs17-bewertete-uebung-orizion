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

<div class="row">
    <div class="col-md-6 col-lg-4 ">
        <form action="/teacher/save" method="post" class="form">
            <fieldset class="form padded">
                <div class="form-group">
                    <label>Text for Question</label>
                    <input type="text" name="text"  class="form-control"/>
                </div>
                <div class="form-group">
                    <g:submitButton name="Submit" value="Save Question"  class="form-control btn-primary" />
                </div>
            </fieldset>
        </form>
    </div>
</div>




</body>
</html>


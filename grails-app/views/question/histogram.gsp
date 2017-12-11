<!DOCTYPE html>
<html>
    <head>
        <title>Histogram of Question</title>
        <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
        <script>
            function getData() {
                var x = [];
                for (var i = 0; i < 500; i ++) {
                    x[i] = Math.random();
                }
                return x;
            }

            function initHisto(x) {
                var trace = {
                    x: x,
                    type: 'histogram',
                };
                var data = [trace];
                Plotly.newPlot('histogram', data);
            }

            initHisto(getData());
        </script>
    </head>
    <body>
        <div id="histogram"></div>
    </body>
</html>

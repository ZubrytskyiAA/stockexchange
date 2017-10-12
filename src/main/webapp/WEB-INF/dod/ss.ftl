<script>
    setInterval(update, 3000);


    function update() {
        var values = new Object();

        $.ajax({
            method: "GET",
            url: "http://localhost:8080/values",
            success: function (data) {
                values = JSON.parse(data);
                var html = createHtml(values);
                $("#users").html(html);
            }
        });

        function createHtml(arr) {
            result = '<table>' +
                    '<tr>' +
                    '<td>Id</td>' +
                    '<td>loginName</td>' +
                    '<td>password</td>' +
                    '</tr>';
            for (var i = 0; i < arr.length; i++) {
                result += '<tr>' +
                        '<td>' + arr[i].id + '</td>' +
                        '<td>' + arr[i].loginName + '</td>' +
                        '<td>' + arr[i].password + '</td>' +
                        '</tr>';
            }
            result += '</table>`';
            return result;
        }
    }
</script>


<script>

    function dda() {



    var ctxB = document.getElementById("barChart").getContext('2d');
    var myBarChart = new Chart(ctxB, {
        type: 'bar',
        data: {
            labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
            datasets: [{
                label: '# of Votes',
                data: [12, 19, 3, 5, 2, 3],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
        },
        optionss: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true
                    }
                }]
            }
        }
    });

    }

</script>
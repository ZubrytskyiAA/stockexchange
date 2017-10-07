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
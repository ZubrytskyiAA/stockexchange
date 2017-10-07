var values = new Object();

$.ajax({
    method: "GET",
    url: "http://localhost:8080/values",
    success: function (data) {
        values = JSON.parse(data);
        var html = createHtml(values);
        $("select").after(html);
    }
});

function createHtml(obj) {
    result = '<table>' +
        '<tr>' +
        '<td>Id</td>' +
        '<td>First name</td>' +
        '<td>Second name</td>' +
        '</tr>' +
        '<tr>' +
        '<td>' + obj.id + '</td>'+
        '<td>' + obj.firstName + '</td>'+
        '<td>' + obj.lastName + '</td>' +
        '</tr>' +
        '</table>`';
    return result;
}
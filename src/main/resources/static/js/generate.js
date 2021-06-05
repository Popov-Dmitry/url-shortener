$(document).ready(function () {
    $(".accept-btn").click(function () {
        let originalUrl = document.getElementById("input-link").value.trim();
        if (isValidUrl(originalUrl)) {
            let data = JSON.stringify({
                "url": originalUrl
            });
            $.ajax({
                url: 'http://localhost:8080/api/public/generate',
                type: 'POST',
                data: data,
                contentType: 'application/json; charset=utf-8',
                //dataType: 'json',
                async: false,
                success: function(resp) {
                    document.getElementById("input-link").value = resp.url;
                },
                error: function (data) {
                    alert(data.status + ':' + data.statusText);
                }
            });
        }
        else {
            alert("Invalid url, please try again");
        }
    })
})

function isValidUrl(url) {
    return /[-a-zA-Z0-9@:%_\+.~#?&\/=]{2,256}\.[a-z]{2,4}\b(\/[-a-zA-Z0-9@:%_\+.~#?&\/=]*)?/gi.test(url);
}
$(function () {

    document.getElementById('formUpload').querySelector('input').onchange = function () {
        document.getElementById('submit').click();
    };

    /*function readfiles(files) {
        var formData = new FormData();
        for (var i = 0; i < files.length; i++) {
            formData.append('file', files[i]);
        }
        // now post a new XHR request
        if (formData) {
            var xhr = new XMLHttpRequest();
            xhr.open('POST', '/parse/upload');
            xhr.send(formData);
        }
    };*/

});
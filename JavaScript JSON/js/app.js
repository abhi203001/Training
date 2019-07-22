var details = document.getElementById("btn");
details.addEventListener("click", getUserList);

function getUserList() {
    var url = "https://jsonplaceholder.typicode.com/photos";
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //updateUserList(JSON.parse(this.responseText));
            viewPhotos(JSON.parse(this.responseText));
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
}

/*function updateUserList(response) {
    for (var i = 0; i < response.length; i++) {
        var user = response[i];
        var userElement = document.createElement('div');
        userElement.className = 'user';
        var name = document.createElement('p');
        name.innerHTML = user.name;
        var email = document.createElement('p');
        email.innerHTML = user.email;
        var phone = document.createElement('p');
        phone.innerHTML = user.phone;
        userElement.appendChild(name);
        userElement.appendChild(email);
        userElement.appendChild(phone);

        document.getElementById('user-list').appendChild(userElement);
    }*/

    function viewPhotos(response) {
        for (var i = 0; i < response.length; i++) {
            var user = response[i];
           
            var photoElement = document.createElement('div');
            photoElement.className = 'user';
           
            var albumId = document.createElement('p');
            albumId.innerHTML = user.albumId;
           
            var id = document.createElement('p');
            id.innerHTML = user.id;
           
            var title = document.createElement('p');
            title.innerHTML = user.title;
           
            var url = document.createElement('img');
            url.src = user.url;
           
            var thumbnailUrl = document.createElement('img');
            thumbnailUrl.src = user.thumbnailUrl;

            photoElement.appendChild(albumId);
            photoElement.appendChild(id);
            photoElement.appendChild(title);
            photoElement.appendChild(url);
            photoElement.appendChild(thumbnailUrl);
    
            document.getElementById('user-list').appendChild(photoElement);
        }

}
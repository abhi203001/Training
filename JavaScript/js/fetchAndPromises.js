document.getElementById('photos').addEventListener('click',getPictures);

function getPictures(){
    fetch('https://jsonplaceholder.typicode.com/photos')
    .then((res) => res.json())
    .then((data) =>{
        let op = '<h1>Photos</h1>';
        data.forEach(function (photo){
            op+=`AlbumId : ${photo.albumId} <br> 
                 Title : ${photo.title} <br>
                 <img src = "${photo.url}" height="100px" width="100px"><br>
                 <br>
            
            `;
        });
        document.getElementById('photos').innerHTML = op;
    })
}
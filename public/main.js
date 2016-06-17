$(document).ready(function() {
    mainPage.init();

})
// api key: AIzaSyCmljv68nIytDeweNCQXnOGt7_Z3Rz9Neo
var mainPage = {
    // name: login name stuff,
    //url: server url,
    restroom: [],
    // don't forget The commas!!!!!!!!
    init(){
      mainPage.styling();
      mainPage.events();
    },
    styling(){
      mainPage.read();
    },

    //end of styling
    events(){
      $('form button').on('click', function(event){
        event.preventDefault();
        // codeAddress();
        var restroom = {
          facility:$('input[name="facility"]').val(),
          address: $('input[name="address"]').val(),
          latitude: $('input[name="lat"]').val(),
          longitude: $('input[name="lon"]').val(),
          access: $('input[name="access"]').val(),
          capacity: $('input[name="capacity"]').val(),
          cleanliness: 0,
        }
        mainPage.create(JSON.stringify(restroom));
      })
    },
    //end of events

    //crud ajax functions
    create(restroomObject){
        $.post({
            contentType: "application/json; charset=utf-8",
            url:"/flush",
            method: "POST",
            data: restroomObject,
            success(data) {
                console.log("created", data);
            },
            error(err) {
                console.error("you made nothing", err);
            },
        })
    },
    //end of create

    read() {
        $.ajax({
            url:"/flush",
            method: "GET",

            success(data) {
                console.log("we got it", data);
                data = JSON.parse(data);
                data.forEach(function(item) {
          var marker = new google.maps.Marker({
            position: {lat:  item.lat, lng: item.lon},
            map: window.map,
            title: item.facility
          });
          $('.listOfToilets').append(`<li>${item.address} ${item.lat} ${item.lon} ${item.access} ${item.capacity} ${item.cleanliness}</li>`)
        })
      },
            error(err){
                console.error("shit", err);
            },

    })
  },
// end of read

    update(){
        $.ajax({
            url:`/flush`,
            method: "PUT",

            success(data) {
                console.log("update success", data);
            },
            error(err) {
                console.error("dammit", err);
            },
        })
    },
//end of update

    destroy(deleteId) {
        $.ajax({
            url:"/flush/"+deleteId,
            method: "DELETE",

            success(data) {
                console.log("its gone", data);
            },
            error(err) {
                console.error("still there", err);
            },
          })
        }
}

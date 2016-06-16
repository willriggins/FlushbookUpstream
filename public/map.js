var map;
function initMap() {
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 32.7765, lng: -79.9311},
    zoom: 8
  });
}

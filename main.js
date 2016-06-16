$(document).ready(function() {
    mainPage.init();

})

var mainPage = {
    // name: login name stuff,
    //url: server url,
    // objects: array or objects to GET POST PUT DELETE,
    // don't forget The commas!!!!!!!!
    init() {

        mainPage.styling() {

            },
            mainPage.events() {

            },
    },
    //end of init

    styling() {

    },

    //end of styling
    events() {

    },
    //end of events

    //crud ajax functions
    create() {
        $.ajax({
            url: method: "POST"
            data: data
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
            url: method: "GET"

                success(data) {
                console.log("we got it", data);
            },
            error(err) {
                console.error("shit", err);
            },
        })
    },
    //end of read

    update() {
        $.ajax({
            url: method: "PUT"

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
            url: method: "DELETE"

                success(data) {
                console.log("its gone", data);
            },
            error(err) {
                console.error("still there", err);
            },
        })
    },
}

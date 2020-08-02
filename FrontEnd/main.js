/**
 * Server side code using the express framework running on a Node.js server.
 *
 * Load the express framework and create an app.
 */
const express = require('express');
const app = express();
/**
 * Host all files in the client folder as static resources.
 * That means: localhost:8080/someFileName.js corresponds to client/someFileName.js.
 */
app.use(express.static('client'));

/**
 * Allow express to understand json serialization.
 */
app.use(express.json());

/**
 * Our code starts here.
 */

/**
 * A route is like a method call. It has a name, some parameters and some return value.
 *
 * Name: /api/attractions
 * Parameters: the request as made by the browser
 * Return value: the list of attractions defined above as JSON
 *
 * In addition to this, it has a HTTP method: GET, POST, PUT, DELETE
 *
 * Whenever we make a request to our server,
 * the Express framework will call one of the methods defined here.
 * These are just regular functions. You can edit, expand or rewrite the code here as needed.
 */
app.get("/api/voorraad", function (request, response) {
    console.log("Api call received for /voorraad");

    response.sendStatus(200);
});

app.post("/api/placeorder", function (request, response) {
    console.log("Api call received for /placeorder");

    /**
     * Send the status code 200 back to the clients browser.
     * This means OK.
     */
    response.sendStatus(200);
});

app.get("/api/ingredient", function (request, response) {
    console.log("Api call received for /myorders");

    response.sendStatus(200);
});

app.get("/api/admin/edit", function (request, response) {
    console.log("Api call received for /admin/edit");

    response.sendStatus(200);
});


/**
 * Make our webserver available on port 8000.
 * Visit localhost:8000 in any browser to see your site!
 */
app.listen(8080, () => console.log('Example app listening on port 8080!'));

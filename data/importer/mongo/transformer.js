var connector = require('./connector').connector;


var db = connector.connect();
var data = require('../data').data;

console.log(data);

db.collection(connector.dbname, function (err, collection) {

    for (var category in data.categories) {
        collection.insert(data.categories[category])
    }

});



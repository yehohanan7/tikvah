var connector = require('connector');

var db = connector.connect();

var data = require('data');

db.collection(connector.dbname, function (err, collection) {

    for (var category in data.categories) {
        collection.insert(data.categories[category])
    }

});



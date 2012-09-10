var data = require('./data').data
console.log(data.categories )

initialize();

function initialize() {
    var mongo = require('mongodb'),
        Server = mongo.Server,
        Db = mongo.Db;

    var server = new Server('localhost', 27017, {auto_reconnect:true});
    var db = new Db('tikvah', server);

    db.open(function (err, db) {
        if (!err) {
            importData(db)
        }
    });
    return db
}

function importData(db) {
    for (category in data.categories) {
        console.log(category)
        db.collection('products', function (err, collection) {
            collection.insert(data.categories[category])
        })
    }

}

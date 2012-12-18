var mongodb = require('mongodb')
var products = require('./product/build_inventory')
var categories = require('./category/build_categorydata')

var db = new mongodb.Db('tikvah', new mongodb.Server('localhost', 27017, {auto_reconnect:true}), {safe:true});

db.open(function (error, client) {
    categories.execute(db,client)
    products.execute(db,client)
    
})



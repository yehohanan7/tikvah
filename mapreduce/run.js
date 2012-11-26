var mongodb = require('mongodb')
var products = require('./product/build_inventory')

var db = new mongodb.Db('tikvah', new mongodb.Server('localhost', 27017, {auto_reconnect:true}), {safe:true});
products.execute(db)


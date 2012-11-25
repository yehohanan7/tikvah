var mapper = function() {
    var value = {};
    value[this.type] = this.value;
    emit(this.id, value);
}


var reducer = function(key, values) {
    var name_mapping = {"created-on": "timestamp", "name-is" : "name", "price" : "price"}
    var result = {};
    for (var i = 0; i < values.length; i++) {
        var value = values[i];
        for (var attr in value) {
            if (value.hasOwnProperty(attr)) {
                result[name_mapping[attr]] = value[attr];
            }
        }
    }
    return result;
}

var clear_products = function(db) {
    console.log('clearing products collection...')
    db.collection('products', function (error, collection) {
        collection.remove({}, function(error, removed) {console.log('products cleared')})
    })
}
exports.execute = function(db) {
    clear_products(db)
    db.open(function (error, client) {
        console.log('building products from product facts....')
        client.collection('productfacts', function(error, collection) {
            collection.mapReduce(mapper, reducer, {
                out : "products",
                verbose : true
                }, 
                function (error, results, stats) {
                   console.log('products view built successfully!')
                }
           )
        })
    })
}

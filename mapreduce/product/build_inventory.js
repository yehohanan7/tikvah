var mapper = function() {
    var value = {};
    value[this.type] = this.value;
    value['code'] = this.id;
    emit(this.id, value);
}


var reducer = function(key, values) {
    var name_mapping = {"created-on": "timestamp", "name-is" : "name", "price" : "price", "category-is" : "category", "code" : "code"}
    var result = {};
    var categories = []
    for (var i = 0; i < values.length; i++) {
        var value = values[i];
        for (var attr in value) {
            if (value.hasOwnProperty(attr)) {
                if (name_mapping[attr] == 'category') { 
                    categories.push(value[attr])
                } else {
                    result[name_mapping[attr]] = value[attr];
                }
            }            
        }
    }
    result['categories']= categories
    return result;
}


exports.execute = function(db, client) {
    db.collection('products', function (error, collection) {
        collection.remove({}, function(error, removed) {
            console.log('products cleared')
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
    })
}


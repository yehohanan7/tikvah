var mapper = function() {
    var value = {};
    value['id'] = this.id
    value[this.type] = this.value
    emit(this.id, value)
}




var reducer = function(key, values) {
    var name_mapping = {"created-on": "timestamp", "id" : "code", "has-attribute": "attribute", "value":"timestamp"}
    var result = {}
    var attributes = []
    for (var i = 0; i < values.length; i++) {
        var value = values[i];
        for (var attr in value) {
            if (value.hasOwnProperty(attr)) {
                if (name_mapping[attr] == 'attribute') { 
                    attributes.push(value[attr])
                } else {
                    result[name_mapping[attr]] = value[attr];
                }
            }            
        }
    }
    result['attributes'] = attributes
    return result;
}

exports.execute = function(db, client) {
    db.collection('categories', function (error, collection) {
        collection.remove({}, function(error, removed) {
            console.log('categories cleared')
            console.log('building categories from category facts....')
            client.collection('categoryfacts', function(error, collection) {
                collection.mapReduce(mapper, reducer, {
                    out : "categories",
                    verbose : true
                    }, 
                    function (error, results, stats) {
                       console.log('category view built successfully!')
                    }
               )
            })
        })
    })
}


db.products.find({author.name : "test"})
db.products.find ({categories.product.rating : {$gt : 2}})

db.products.find ({tags : "spftware"})
db.products.find().sort({date : -1}).limit(10)


db.products.ensureIndex({author.name : 1})

db.products.find ({loc: {$near : [50, 50]}})

list of predicates
//require('nodetime').profile()
var fs = require('fs')
var async = require('async')
var Benchmark = require('benchmark')
//var suite = Benchmark.Suite
//suite.add('dataimporter', ).run();

function importData() {
    var count = 1

    var start = new Date()
    var stream = fs.createWriteStream('generated_data.js', {flags:'w'})
    stream.write("{products: [")

    while (count <= 10) {
        stream.write("{product:" + count + ", name: " + "product_name_" + count + "},\n")
        count++
    }
    stream.write("]}")

    var end = new Date();

    console.log("data generated in : " + (end - start) + " ms")
}

importData();
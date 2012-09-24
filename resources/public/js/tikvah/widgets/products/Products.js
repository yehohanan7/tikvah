define("tikvah/widgets/products/Products", ["dojo", "dijit/_Widget"], function (dojo) {

    dojo.declare("tikvah.widgets.products.Products", [dijit._Widget], {

        postCreate:function () {
            console.log("inside widget")
            alert(this.domNode)
        }
    });

    return tikvah.widgets.products.Products;
})


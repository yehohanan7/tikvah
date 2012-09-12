define("tikvah/widgets/products/Products", ["dojo"], function (dojo) {

    dojo.declare("tikvah.widgets.products.Products", [], {

        postCreate:function () {
            alert(this.domNode);
        }
    });

    return tikvah.widgets.products.Products;
})


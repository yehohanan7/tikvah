define("tikvah/widgets/products/Products", ["dojo", "dijit/_Widget", "dojox/data/JsonRestStore", "dojox/grid/DataGrid"], function (dojo) {

    dojo.declare("tikvah.widgets.products.Products", [dijit._Widget], {

        url:null,

        store:null,

        postCreate:function () {
            console.log("inside widget")
            var widget = this
            if (!widget.url) {
                widget.url = '/products'
            }
            widget.store = new dojox.data.JsonRestStore({target:widget.url});

            var gridLayout = [
                { field: 'code', name: 'Id', width: '50px' },
                { field: 'name', name: 'Name', width: '250px' },
                { field: 'price', name: 'Price', width: '250px' },
                { field: 'categories', name: 'Categories', width: '250px' }];

            var grid = new dojox.grid.DataGrid({
                store:widget.store,
                structure:gridLayout
            }, document.createElement('div'));

            widget.domNode.appendChild(grid.domNode)
            grid.startup();

            console.log("after post create")
        }
    });

    return tikvah.widgets.products.Products;
})


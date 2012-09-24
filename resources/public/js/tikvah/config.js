var dojoConfig = {
    async:true,
    waitSeconds:5,
    site:"tikvah",
    prodDebug:true,
    devDebug:false,
    styleSwitch:true,
    context:"",
    paths:{
        tikvah:'/js/tikvah'
    },
    moduleNames:["dojo", "tikvah/widgets/products/Products"],

    init:function () {

        require(["dojo/parser", "dojo/ready"], function (parser, ready) {
            ready(function () {
                require(dojoConfig.moduleNames, function (dojo) {
                    parser.parse();
                });

            });
        });
    }
}
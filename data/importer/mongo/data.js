var data = {
    categories:[
        {
            id:"cat_id1",
            name:"category 1",
            highlights:[
                {
                    code:"cat_attribute_1",
                    name:"cat attribute 1"
                }
            ],
            products:[
                {
                    id:1,
                    name:"product name",
                    image:"images/user_1.png",
                    stock:100,
                    tags:["computers", "hardware"],
                    highlights:[
                        {
                            code:"attr_14",
                            name:"attr name",
                            description:"descript attribute"
                        },
                        {
                            code:"attr_41",
                            name:"attr name",
                            description:"descript attribute"
                        }
                    ]
                }
            ]
        }
    ]
}

exports.data = data;
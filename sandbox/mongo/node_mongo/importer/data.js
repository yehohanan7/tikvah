exports.data =
{
    categories:[
        {
            _id:"headphones_highend",
            name:"high end head phones",
            description:"category of expensive head phones",

            highlights:[
                {
                    code:"gaurantee",
                    description:"garuntee available"
                }
            ],
            products:[
                {
                    _id:"boseQC15",
                    name:"Bose quite comfort 15",
                    stock:100,
                    tags:["headphone", "music", "speaker"]
                },
                {
                    _id:"boseQC3",
                    name:"Bose quite comfort 3",
                    stock:51,
                    tags:["headphone", "speaker"]
                }
            ]
        },
        {
            _id:"sleek_laptops",
            name:"category of sleek laptops",
            description:"very light weight and sleek laptops",
            highlights:[
                {
                    code:"no_discounts",
                    description:"no discounts available"
                }
            ],
            products:[
                {
                    _id:"macAir",
                    name:"mac book air",
                    stock:200,
                    tags:["computers", "laptops"]
                },
                {
                    _id:"macPro",
                    name:"mac book pro",
                    stock:21,
                    tags:["computers", "laptops", "apple"]
                }
            ]
        }
    ]
};
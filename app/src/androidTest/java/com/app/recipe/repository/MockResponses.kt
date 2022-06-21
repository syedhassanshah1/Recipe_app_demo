package com.app.recipe.repository

object MockResponses {
    val searchItems = """
        {
            "results": [
                {
                    "id": 716627,
                    "title": "Easy Homemade Rice and Beans",
                    "readyInMinutes": 35,
                    "servings": 2,
                    "sourceUrl": "http://cooking2perfection.blogspot.com/2012/11/easy-homemade-rice-and-beans.html",
                    "openLicense": 2,
                    "image": "easy-homemade-rice-and-beans-716627.jpg"
                },
                {
                    "id": 798400,
                    "title": "Spicy Black-Eyed Pea Curry with Swiss Chard and Roasted Eggplant",
                    "readyInMinutes": 45,
                    "servings": 6,
                    "sourceUrl": "http://foodandspice.blogspot.com/2016/08/spicy-black-eyed-pea-curry-with-swiss.html",
                    "openLicense": 2,
                    "image": "spicy-black-eyed-pea-curry-with-swiss-chard-and-roasted-eggplant-798400.jpg"
                },
                {
                    "id": 715421,
                    "title": "Cheesy Chicken Enchilada Quinoa Casserole",
                    "readyInMinutes": 30,
                    "servings": 4,
                    "sourceUrl": "http://www.pinkwhen.com/cheesy-chicken-enchilada-quinoa-casserole/",
                    "openLicense": 2,
                    "image": "cheesy-chicken-enchilada-quinoa-casserole-715421.jpg"
                },
                {
                    "id": 716437,
                    "title": "Chilled Cucumber Avocado Soup with Yogurt and Kefir",
                    "readyInMinutes": 45,
                    "servings": 3,
                    "sourceUrl": "http://fullbellysisters.blogspot.com/2012/06/chilled-cucumber-avocado-soup-with.html",
                    "openLicense": 2,
                    "image": "chilled-cucumber-avocado-soup-with-yogurt-and-kefir-716437.jpg"
                },
                {
                    "id": 660228,
                    "title": "Skinny Kale Basil Pesto",
                    "readyInMinutes": 45,
                    "servings": 3,
                    "sourceUrl": "https://www.foodista.com/recipe/6K5LNQ7F/skinny-kale-basil-pesto",
                    "openLicense": 2,
                    "image": "Skinny-Kale-Basil-Pesto-660228.jpg"
                },
                {
                    "id": 716195,
                    "title": "Spicy Indian-Style Hummus",
                    "readyInMinutes": 45,
                    "servings": 12,
                    "sourceUrl": "http://foodandspice.blogspot.com/2012/07/spicy-hummus-indian-style.html",
                    "openLicense": 2,
                    "image": "spicy-indian-style-hummus-716195.jpg"
                },
                {
                    "id": 637162,
                    "title": "Carrot and Cabbage Salad With Coriander+cumin Dry Rub",
                    "readyInMinutes": 25,
                    "servings": 1,
                    "sourceUrl": "http://www.foodista.com/recipe/MB7NYM87/carrot-and-cabbage-salad-with-coriandercumin-dry-rub",
                    "openLicense": 2,
                    "image": "Carrot-and-Cabbage-Salad-With-Coriander+cumin-Dry-Rub-637162.jpg"
                },
                {
                    "id": 664090,
                    "title": "Turkish Chicken Salad with Home-made Cacik Yogurt Sauce",
                    "readyInMinutes": 45,
                    "servings": 4,
                    "sourceUrl": "http://www.foodista.com/recipe/XYFWSH25/a-turkish-inspired-chicken-salad-with-tomato-cucumber-red-onion-salsa-charred-green-peppers-and-home-made-cacik-delicious-and-healthy",
                    "openLicense": 2,
                    "image": "Turkish-Chicken-Salad-with-Home-made-Cacik-Yogurt-Sauce-664090.jpg"
                },
                {
                    "id": 636602,
                    "title": "Butternut Squash Soup (In Half An Hour!)",
                    "readyInMinutes": 30,
                    "servings": 8,
                    "sourceUrl": "http://www.foodista.com/recipe/24DYGNYL/butternut-squash-soup-in-half-an-hour",
                    "openLicense": 2,
                    "image": "Butternut-Squash-Soup-(In-Half-An-Hour)-636602.jpg"
                },
                {
                    "id": 659143,
                    "title": "Salmon, Watercress, Fennel and Baby Beetroot Salad With Lemony \"Caviar\" Dressing",
                    "readyInMinutes": 45,
                    "servings": 4,
                    "sourceUrl": "http://www.foodista.com/recipe/WHSTLX2T/salmon-watercress-fennel-and-baby-beetroot-salad-with-lemony-arenkha-msc-dressing",
                    "openLicense": 2,
                    "image": "Salmon--Watercress--Fennel-and-Baby-Beetroot-Salad-With-Lemony-Caviar-Dressing-659143.jpg"
                }
            ],
            "baseUri": "https://spoonacular.com/recipeImages/",
            "offset": 0,
            "number": 10,
            "totalResults": 5078,
            "processingTimeMs": 112,
            "expires": 1627611345916,
            "isStale": false
        }
    """.trimIndent()
    val recipeItem = """
        {
            "vegetarian": false,
            "vegan": false,
            "glutenFree": false,
            "dairyFree": false,
            "veryHealthy": false,
            "cheap": false,
            "veryPopular": false,
            "sustainable": false,
            "weightWatcherSmartPoints": 5,
            "gaps": "no",
            "lowFodmap": false,
            "aggregateLikes": 41,
            "spoonacularScore": 17.0,
            "healthScore": 0.0,
            "creditsText": "Foodista.com – The Cooking Encyclopedia Everyone Can Edit",
            "license": "CC BY 3.0",
            "sourceName": "Foodista",
            "pricePerServing": 25.56,
            "extendedIngredients": [
                {
                    "id": 18137,
                    "aisle": "Baking",
                    "image": "white-cake-mix.jpg",
                    "consistency": "solid",
                    "name": "white cake mix",
                    "nameClean": "vanilla cake mix",
                    "original": "1 box white cake mix (plus what you'll need to make it: eggs, water, oil)",
                    "originalString": "1 box white cake mix (plus what you'll need to make it: eggs, water, oil)",
                    "originalName": "white cake mix (plus what you'll need to make it: eggs, water, oil)",
                    "amount": 1.0,
                    "unit": "box",
                    "meta": [
                        "white",
                        "(plus what you'll need to make it: eggs, water, oil)"
                    ],
                    "metaInformation": [
                        "white",
                        "(plus what you'll need to make it: eggs, water, oil)"
                    ],
                    "measures": {
                        "us": {
                            "amount": 1.0,
                            "unitShort": "box",
                            "unitLong": "box"
                        },
                        "metric": {
                            "amount": 1.0,
                            "unitShort": "box",
                            "unitLong": "box"
                        }
                    }
                },
                {
                    "id": 9070,
                    "aisle": "Produce",
                    "image": "cherries.jpg",
                    "consistency": "solid",
                    "name": "cherry",
                    "nameClean": "cherries",
                    "original": "1 (3 ounce) package cherry Jello",
                    "originalString": "1 (3 ounce) package cherry Jello",
                    "originalName": "package cherry Jello",
                    "amount": 3.0,
                    "unit": "ounce",
                    "meta": [],
                    "metaInformation": [],
                    "measures": {
                        "us": {
                            "amount": 3.0,
                            "unitShort": "oz",
                            "unitLong": "ounces"
                        },
                        "metric": {
                            "amount": 85.049,
                            "unitShort": "g",
                            "unitLong": "grams"
                        }
                    }
                },
                {
                    "id": 1200,
                    "aisle": "Milk, Eggs, Other Dairy",
                    "image": "whipped-cream.jpg",
                    "consistency": "solid",
                    "name": "nonfat cool whip",
                    "nameClean": "fat free whipped topping",
                    "original": "1 container of Cool Whip",
                    "originalString": "1 container of Cool Whip",
                    "originalName": "Cool Whip",
                    "amount": 1.0,
                    "unit": "container",
                    "meta": [],
                    "metaInformation": [],
                    "measures": {
                        "us": {
                            "amount": 1.0,
                            "unitShort": "container",
                            "unitLong": "container"
                        },
                        "metric": {
                            "amount": 1.0,
                            "unitShort": "container",
                            "unitLong": "container"
                        }
                    }
                }
            ],
            "id": 637767,
            "title": "Cherry Jello Poke Cake",
            "readyInMinutes": 45,
            "servings": 18,
            "sourceUrl": "https://www.foodista.com/recipe/3N5GD8Q6/cherry-jello-poke-cake",
            "image": "https://spoonacular.com/recipeImages/637767-556x370.jpg",
            "imageType": "jpg",
            "summary": "Cherry Jello Poke Cake requires around <b>approximately 45 minutes</b> from start to finish. For <b>26 cents per serving</b>, this recipe <b>covers 3%</b> of your daily requirements of vitamins and minerals. This recipe serves 18. One serving contains <b>129 calories</b>, <b>2g of protein</b>, and <b>2g of fat</b>. It is brought to you by Foodista. A mixture of cake mix, cherry jello, cool whip, and a handful of other ingredients are all it takes to make this recipe so tasty. 41 person were impressed by this recipe. Overall, this recipe earns a <b>rather bad spoonacular score of 12%</b>. If you like this recipe, take a look at these similar recipes: <a href=\"https://spoonacular.com/recipes/strawberry-jello-poke-cake-1074335\">Strawberry Jello Poke Cake</a>, <a href=\"https://spoonacular.com/recipes/1-2-3-cherry-poke-cake-266559\">1-2-3 Cherry Poke Cake</a>, and <a href=\"https://spoonacular.com/recipes/cherry-poke-cake-903129\">Cherry Poke Cake</a>.",
            "cuisines": [],
            "dishTypes": [],
            "diets": [],
            "occasions": [],
            "winePairing": {
                "pairedWines": [
                    "cream sherry",
                    "moscato dasti",
                    "port"
                ],
                "pairingText": "Cake works really well with Cream Sherry, Moscato d'Asti, and Port. A common wine pairing rule is to make sure your wine is sweeter than your food. Delicate desserts go well with Moscato d'Asti, nutty desserts with cream sherry, and caramel or chocolate desserts pair well with port. The NV Johnson Estate Cream Sherry with a 5 out of 5 star rating seems like a good match. It costs about 19 dollars per bottle.",
                "productMatches": [
                    {
                        "id": 430626,
                        "title": "NV Johnson Estate Cream Sherry",
                        "description": "Very aromatic with notes of hazelnut, vanilla, and a touch of oak followed by sweet raisins and a touch of yeast. Clean lasting finish. Good now but will reward those allow it to age\"\". A favorite pre-prandial beverage. Consider it with nuts before dinner as an aperitif, or after dinner with dessert, especially chocolates and fruit-based desserts. Also wonderful on cold afternoons, served with biscotti to dip in \"\"Italian-style\"\". \"",
                        "price": "${'$'}19.49",
                        "imageUrl": "https://spoonacular.com/productImages/430626-312x231.jpg",
                        "averageRating": 1.0,
                        "ratingCount": 2.0,
                        "score": 0.8571428571428572,
                        "link": "https://www.amazon.com/Johnson-Estate-Cream-Sherry-750/dp/B00D3GQSRW?tag=spoonacular-20"
                    }
                ]
            },
            "instructions": "Prepare boxed cake mix according to directions.\nOnce baked and slightly cooled, poke holes into cake.\nPrepare Jello according to package.\nPour Jello onto the cake, making sure to pour directly into the holes.\nSet in the fridge for a few hours, overnight is even better.\nJust prior to serving top with Cool Whip.",
            "analyzedInstructions": [
                {
                    "name": "",
                    "steps": [
                        {
                            "number": 1,
                            "step": "Prepare boxed cake mix according to directions.",
                            "ingredients": [
                                {
                                    "id": 10018137,
                                    "name": "cake mix",
                                    "localizedName": "cake mix",
                                    "image": ""
                                }
                            ],
                            "equipment": []
                        },
                        {
                            "number": 2,
                            "step": "Once baked and slightly cooled, poke holes into cake.",
                            "ingredients": [],
                            "equipment": []
                        },
                        {
                            "number": 3,
                            "step": "Prepare Jello according to package.",
                            "ingredients": [],
                            "equipment": []
                        },
                        {
                            "number": 4,
                            "step": "Pour Jello onto the cake, making sure to pour directly into the holes.",
                            "ingredients": [],
                            "equipment": []
                        },
                        {
                            "number": 5,
                            "step": "Set in the fridge for a few hours, overnight is even better.",
                            "ingredients": [],
                            "equipment": []
                        },
                        {
                            "number": 6,
                            "step": "Just prior to serving top with Cool Whip.",
                            "ingredients": [],
                            "equipment": []
                        }
                    ]
                }
            ],
            "originalId": null,
            "spoonacularSourceUrl": "https://spoonacular.com/cherry-jello-poke-cake-637767"
        }
    """.trimIndent()
}
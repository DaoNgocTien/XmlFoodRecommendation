<%-- 
    Document   : index
    Created on : Jul 8, 2020, 10:00:20 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="ASSETS/StyleSheet.css">
        <style>
            body, html {
                height: 100%;
                font-family: "Inconsolata", sans-serif;
            }

            .bgimg {
                background-position: center;
                background-size: cover;
                background-image: url("ASSETS/IMAGE/home-design.jpg");
                min-height: 75%;
            }

            .menu {
                display: none;
            }
            /* vietnamese */
            @font-face {
                font-family: 'Inconsolata';
                font-style: normal;
                font-weight: 400;
                font-stretch: 100%;
                src: url("ASSETS/QldgNThLqRwH-OJ1UHjlKENVzkWGVkL3GZQmAwLYxYWI2qfdm7Lpp4U8WRL2l2eY(1).woff2") format('woff2');
                unicode-range: U0102-0103, U0110-0111, U0128-0129, U0168-0169, U+01A0-01A1, U+01AF-01B0, U+1EA0-1EF9, U+20AB;
            }
            /* latin-ext */
            @font-face {
                font-family: 'Inconsolata';
                font-style: normal;
                font-weight: 400;
                font-stretch: 100%;
                src: url("ASSETS/QldgNThLqRwH-OJ1UHjlKENVzkWGVkL3GZQmAwLYxYWI2qfdm7Lpp4U8WRP2l2eY.woff2") format('woff2');
                unicode-range: U0100-024F, U0259, U1E00-1EFF, U2020, U20A0-20AB, U20AD-20CF, U2113, U2C60-2C7F, U+A720-A7FF;
            }
            /* latin */
            @font-face {
                font-family: 'Inconsolata';
                font-style: normal;
                font-weight: 400;
                font-stretch: 100%;
                src: url("ASSETS/QldgNThLqRwH-OJ1UHjlKENVzkWGVkL3GZQmAwLYxYWI2qfdm7Lpp4U8WR32lw.woff2") format('woff2');
                unicode-range: U0000-00FF, U+0131, U0152-0153, U02BB-02BC, U+02C6, U+02DA, U+02DC, U2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193, U+2212, U+2215, U+FEFF, U+FFFD;
            }
        </style>
        <script>


//            const getFoodSample = async () => {
//                var xhr = new XMLHttpRequest();
//                return new Promise(function (resolve, reject) {
//                    xhr.onreadystatechange = function () {
//                        if (xhr.readyState === 4) {
//                            if (xhr.status >= 300) {
//                                reject("Error, status code = " + xhr.status)
//                            } else {
//                                resolve(xhr.responseText);
//                            }
//                        }
//                    }
//                    xhr.onerror = function (e) {
//                        console.error(xhr.statusText);
//                    };
//                    xhr.open('get', 'http://localhost:8080/SE1302_Meal_Webservice/webresources/tien.webservice.material/', true);
//                    xhr.send();
//                });
//            }
//
//            const getFood = async () => {
//                alert("getFood")
//                try {
//                    let food = await getFoodSample();
//                    console.log(food);
//                } catch (err) {
//                    console.log(err);
//                }
//            }

            const pagination = command => {
                const domMaterial = localStorage.getItem("MATERIALSTRING");
                const parser = new DOMParser();
                const xmlDoc = parser.parseFromString(domMaterial, "text/xml");

                let txtPageDirection = document.querySelector('#txtPageDirection');
                let pageNumber = parseInt(txtPageDirection.innerHTML);
                let searchIngredient = document.querySelector('#searchIngredientContent');
                searchIngredient.innerHTML = "";
                let content;
                if (command === "next") {
                    if (pageNumber < 25) {
                        pageNumber++;
                    }
                } else if (command === "back") {
                    if (pageNumber > 1) {
                        pageNumber--;
                    }
                }
                txtPageDirection.innerHTML = pageNumber;
                content = "";
                for (var i = pageNumber * 10; i < (pageNumber + 1) * 10; i++) {
                    content += "<h5>" + xmlDoc.getElementsByTagName("foodname")[i].childNodes[0].nodeValue + "</h5><br/>"
                            + "<p class='w3-text-grey'>Carbohydrate: " + xmlDoc.getElementsByTagName("carbonhydrate")[i].childNodes[0].nodeValue
                            + "Calories: " + xmlDoc.getElementsByTagName("calories")[i].childNodes[0].nodeValue
                            + "Protein: " + xmlDoc.getElementsByTagName("protein")[i].childNodes[0].nodeValue
                            + "Fat: " + xmlDoc.getElementsByTagName("fat")[i].childNodes[0].nodeValue
                            + "Fiber: " + xmlDoc.getElementsByTagName("fiber")[i].childNodes[0].nodeValue + "</p> <br/> <hr/> <br/>";
                }
                searchIngredient.innerHTML = content;
            };


            //  Get List Food and List Material from database, then redirect to homepage
            const saveData = () => {
            <c:if test="${sessionScope.MATERIALSTRING != null}">
                <c:if test="${not empty sessionScope.MATERIALSTRING}">
//                document.querySelector("#MATERIALSTRING").innerHTML = "${sessionScope.MATERIALSTRING}";
                const domMaterial = localStorage.getItem("MATERIALSTRING");
                if (!domMaterial) {
                    localStorage.setItem("MATERIALSTRING", "${sessionScope.MATERIALSTRING}");
//                    alert("!       domMaterial");
                } else {
//                    alert("domMaterial");
                }
                </c:if>
            </c:if>
            };

        </script>
    </head>
    <body onload="saveData()">
        <div class="w3-sand w3-grayscale w3-large" id="MATERIALSTRING">

        </div>
        <!-- Header with image -->
        <header class="bgimg w3-display-container w3-grayscale-min" id="home">
            <div class="w3-display-bottomleft w3-center w3-padding-large w3-hide-small">
                <span class="w3-tag">Open from 7am to 5:30pm</span>
            </div>
            <div class="w3-display-middle w3-center">
                <span class="w3-text-white" style="font-size:90px">the<br>Gym</span>
            </div>
            <div class="w3-display-bottomright w3-center w3-padding-large">
                <span class="w3-text-white">Lot 24 Quang Trung Software Park</span>
            </div>
        </header>

        <!-- Links (sit on top) -->
        <div class="w3-top">
            <div class="w3-row w3-padding w3-black">
                <div class="w3-col s3">
                    <a href="index.jsp" class="w3-button w3-block w3-black">ABOUT US</a>
                </div>
                <div class="w3-col s3">
                    <a href="calculate.jsp" class="w3-button w3-block w3-black">RECOMMENDATION AND CALCULATOR</a>
                </div>
                <div class="w3-col s3">
                    <a href="dataindex.jsp" class="w3-button w3-block w3-black">INDEX</a>
                </div>
                <div class="w3-col s3">
                    <a href="about.jsp" class="w3-button w3-block w3-black">CONTACT</a>
                </div>
            </div>
        </div>
        <script>
            // Tabbed Menu
            const openMenu = (aLink, content) => {
                document.querySelector("#" + aLink).classList.contains("w3-dark-grey") ?
                        document.querySelector("#" + aLink).classList.remove("w3-dark-grey") :
                        document.querySelector("#" + aLink).classList.add("w3-dark-grey");
                document.querySelector("#" + content).style.display === "none" ?
                        document.querySelector("#" + content).style.display = "block" :
                        document.querySelector("#" + content).style.display = "none";

            };

            const liveSearch = () => {
                let search = document.querySelector("#txtLiveSearch").value;

                const domMaterial = localStorage.getItem("MATERIALSTRING");
                const parser = new DOMParser();
                const xmlDoc = parser.parseFromString(domMaterial, "text/xml");

                let searchIngredient = document.querySelector('#searchIngredientContent');
                document.querySelector('#searchIngredientPagination').style.display = "none";
                searchIngredient.innerHTML = "";
                let content = "";
                let count = 0;
                for (var i = 0; i < 250; i++) {
                    let foodname = xmlDoc.getElementsByTagName("foodname")[i].childNodes[0].nodeValue;

                    if (foodname.indexOf(search) > -1) {
                        console.log(foodname);
                        count++;
                        if (count < 11) {
                            content += "<h5>" + xmlDoc.getElementsByTagName("foodname")[i].childNodes[0].nodeValue + "</h5><br/>"
                                    + "<p class='w3-text-grey'>Carbohydrate: " + xmlDoc.getElementsByTagName("carbonhydrate")[i].childNodes[0].nodeValue
                                    + "Calories: " + xmlDoc.getElementsByTagName("calories")[i].childNodes[0].nodeValue
                                    + "Protein: " + xmlDoc.getElementsByTagName("protein")[i].childNodes[0].nodeValue
                                    + "Fat: " + xmlDoc.getElementsByTagName("fat")[i].childNodes[0].nodeValue
                                    + "Fiber: " + xmlDoc.getElementsByTagName("fiber")[i].childNodes[0].nodeValue + "</p> <br/> <hr/> <br/>";

                        }
                    }
                }
                if (search !== "" && search) {
                    searchIngredient.innerHTML = content;
                } else {
                    document.querySelector('#searchIngredientPagination').style.display = "block";
                    document.querySelector('#txtPageDirection').innerHTML = "2";
                    pagination('back');
                }
            }
        </script>
        <!-- !PAGE CONTENT! -->
        <div class="w3-sand w3-grayscale w3-large">

            <!-- Menu Container -->
            <div class="w3-container" id="menu">
                <!--Live search--> 
                <div class="w3-content" style="max-width:700px">

                    <h5 class="w3-center w3-padding-48"><span class="w3-tag w3-wide">SEARCH YOUR INGREDIENT</span></h5>

                    <div class="w3-row w3-center w3-card w3-padding w3-dark-grey"  id="myLink" >
                        <input style="width: 80%;color:#a94442 " id="txtLiveSearch" type="text" placeholder="What do you search for" onmousedown="liveSearch();" onkeyup="liveSearch();"/>
                    </div>

                    <div id="searchIngredient" class="w3-container menu w3-padding-48 w3-card" style="display: block">
                        <div  id="searchIngredientContent">
                            <c:if test="${sessionScope.DOMMATERIAL != null}">
                                <c:if test="${not empty sessionScope.DOMMATERIAL}">
                                    <c:set value="${sessionScope.DOMMATERIAL}" var="doc"/>
                                    <x:forEach select="$doc/materials/*" var="items" varStatus="counter">
                                        <%--<c:set value="${param.txtPage}" var="txtPagetxtPage"/>--%>
                                        <%--<c:out value="${txtPagetxtPage}"/>--%>
                                        <c:if test="${counter.count lt 10}">
                                            <h5><x:out select="$items/foodname"/></h5>
                                            <p class="w3-text-grey">Carbohydrate: <x:out select="$items/carbonhydrate"/>    Calories <x:out select="$items/calories"/>      Protein: <x:out select="$items/protein"/>       Fat <x:out select="$items/fat"/>    Fiber <x:out select="$items/fiber"/></p><br/><hr/><br/>
                                        </c:if>
                                    </x:forEach>
                                </c:if>
                            </c:if>
                        </div>


                        <!-- Phân trang -->
                        <div class="w3-center w3-padding-28" id="searchIngredientPagination">
                            <div class="w3-bar">
                                <a onclick="pagination('back');" class="w3-bar-item w3-button w3-hover-pink">«</a>
                                <!--<a href="#" class="w3-bar-item w3-black w3-button">1 of 27</a>-->
                                <input type="hidden" name="txtPage" id="txtPage" value="1" />
                                <a class="w3-bar-item w3-button w3-hover-pink" id="txtPageDirection">1</a>
                                <a onclick="pagination('next');"  class="w3-bar-item w3-button w3-hover-pink">»</a>
                            </div>
                        </div>
                    </div> 

                    <img src="ASSETS/IMAGE/c700x420.jpg" style="width:100%;max-width:1000px;margin-top:32px;">
                </div>

                <!--The index of ingredient-->
                <div class="w3-content" style="max-width:700px">

                    <h5 class="w3-center w3-padding-48"><span class="w3-tag w3-wide">THE INDEX OF INGREDIENT</span></h5>

                    <!--EGG-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('eggLink', 'egg');" id="eggLink">
                        <a >
                            <div class=" s6 tablink">Nutritional value of eggs, egg whites, ...</div>
                        </a>

                    </div>

                    <div id="egg" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/1.JPG" style="width:100%;max-width:1000px;margin-top:32px;">
                        <img src="ASSETS/IMAGE/a5trung.png" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--PORK-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('porkLink', 'pork');" id="porkLink">
                        <a >
                            <div class=" s6 tablink">Nutritional value of pork</div>
                        </a>

                    </div>

                    <div id="pork" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/2.JPG" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--BEEF-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('beefLink', 'beef');" id="beefLink">
                        <a >
                            <div class=" s6 tablink">Nutritional value of beef</div>
                        </a>

                    </div>

                    <div id="beef" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/3.JPG" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--CHICKEN-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('chickenLink', 'chicken');" id="chickenLink">
                        <a >
                            <div class=" s6 tablink">Nutritional value of chicken meat</div>
                        </a>

                    </div>

                    <div id="chicken" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/4.JPG" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--DUCK-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('duckLink', 'duck');" id="duckLink">
                        <a >
                            <div class=" s6 tablink">Nutritional value of duck meet</div>
                        </a>

                    </div>

                    <div id="duck" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/5.JPG" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--Beans, rice, fruits, seaweed, corn, sweet potatoes, .., and spices-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('beanLink', 'bean');" id="beanLink">
                        <a >
                            <div class=" s6 tablink">Beans, rice, fruits, seaweed, corn, sweet potatoes, .., and spices</div>
                        </a>

                    </div>

                    <div id="bean" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/6.JPG" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--SEAFOOD-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('seafoodLink', 'seafood');" id="seafoodLink">
                        <a >
                            <div class=" s6 tablink">Nutritional value of seafood</div>
                        </a>

                    </div>

                    <div id="seafood" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/7.JPG" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--Vegetables and fruits-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('fruitLink', 'fruit');" id="fruitLink">
                        <a >
                            <div class=" s6 tablink">Nutritional value of vegetables and fruits</div>
                        </a>

                    </div>

                    <div id="fruit" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/8.JPG" style="width:100%;max-width:1000px;margin-top:32px;">
                        <img src="ASSETS/IMAGE/9.JPG" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                </div>


                <!--The index of food-->
                <div class="w3-content" style="max-width:700px">

                    <h5 class="w3-center w3-padding-48"><span class="w3-tag w3-wide">THE INDEX OF FOOD</span></h5>

                    <!--Vegetarian dishes-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('vegeFoodLink', 'vegeFood');" id="vegeFoodLink">
                        <a >
                            <div class=" s6 tablink">Vegetarian dishes</div>
                        </a>

                    </div>

                    <div id="vegeFood" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/a1.png" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--Teas - Sticky rice-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('teaFoodLink', 'teaFood');" id="teaFoodLink">
                        <a >
                            <div class=" s6 tablink">Teas - Sticky rice</div>
                        </a>

                    </div>

                    <div id="teaFood" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/a2.png" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--Folk cakes - Cakes-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('cakeFoodLink', 'cakeFood');" id="cakeFoodLink">
                        <a >
                            <div class=" s6 tablink">Folk cakes - Cakes</div>
                        </a>

                    </div>

                    <div id="cakeFood" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/a3.png" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 

                    <br/>
                    <!--Beverage - Beer-->
                    <div class="w3-row w3-center w3-card w3-padding" onclick="openMenu('beerFoodLink', 'beerFood');" id="beerFoodLink">
                        <a >
                            <div class=" s6 tablink">Beverage - Beer</div>
                        </a>

                    </div>

                    <div id="beerFood" class="w3-container menu w3-padding-48 w3-card" style="display: none">
                        <img src="ASSETS/IMAGE/a4.png" style="width:100%;max-width:1000px;margin-top:32px;">
                    </div> 
                    <br/> <br/>
                </div>
            </div>
        </div>

        <!-- End page content -->


        <!-- Footer -->
        <footer class="w3-center w3-light-grey w3-padding-48 w3-large">
            <p>Powered by <a href="#" title="W3.CSS" target="_blank" class="w3-hover-text-green">deSigning</a></p>
        </footer>



    </body>
</html>

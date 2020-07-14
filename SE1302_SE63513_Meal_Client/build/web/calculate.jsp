<%-- 
    Document   : index
    Created on : Jul 8, 2020, 10:00:20 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            //  Get List Food and List Material from database, then redirect to homepage
            const saveMealData = () => {
//                const breakfast = localStorage.getItem("BREAKFAST");
//                const lunch = localStorage.getItem("LUNCH");
//                const dinner = localStorage.getItem("DINNER");
//
//                if (!breakfast) {
//                    localStorage.setItem("BREAKFAST", JSON.stringify("${sessionScope.BREAKFAST}"));
//                }
//
//                if (!lunch) {
//                    localStorage.setItem("LUNCH", JSON.stringify("${sessionScope.LUNCH}"));
//                }
//
//                if (!dinner) {
//                    localStorage.setItem("DINNER", JSON.stringify("${sessionScope.DINNER}"));
//                }
                calculateBMR();
            };

        </script>
    </head>
    <body onload="saveMealData()">

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

        <!-- Add a background color and large text to the whole page -->
        <div class="w3-sand w3-grayscale w3-large">

            <!-- Menu Container -->
            <div class="w3-container" id="menu">
                <div class="w3-content" style="max-width:700px">
                    <h5 class="w3-center w3-padding-48"><span class="w3-tag w3-wide">THE CALCULATOR</span></h5>
                    <div class="w3-row w3-center w3-card w3-padding">
                        <a>
                            <div class=" s6 tablink" style="display: block">Calculate your energy for your  gym career</div>
                        </a>
                    </div>
                    <div id="cal" class="w3-container menu w3-padding-48 w3-card" style="display: block">
                        <!--Script calculate BMR and BMI-->
                        <script>
                            const calculateBMR = () => {
//                                alert("calculateBMR");
                                let gender = parseFloat(document.querySelector("#opGender").value);
                                let age = parseFloat(document.querySelector("#txtAge").value);
                                let height = parseFloat(document.querySelector("#txtHeight").value);
                                let weight = parseFloat(document.querySelector("#txtWeight").value);
                                let activity = parseFloat(document.querySelector("#opActivity").value);
                                let result = document.querySelector("#calculateResult");
                                console.log(age + "-" + height + "-" + weight);

                                if (age < 10 || age > 70 || height < 100 || height > 230 || weight < 30 || weight > 150 || isNaN(age) || isNaN(height) || isNaN(weight)) {
                                    result.innerHTML = "";
                                    document.querySelector("#txtCalories").value = "";
                                    document.querySelector("#recommendMeal").disabled = true;
                                } else {
                                    let bmi = parseFloat(weight) / (parseFloat(height) * parseFloat(height));
                                    let bmr;
                                    if (gender === 0) {
                                        bmr = 66 + (13.7 * parseFloat(weight)) + (5 * parseFloat(height)) - (6.8 * parseFloat(age));
                                    } else {
                                        bmr = 65.5 + (9.6 * parseFloat(weight)) + (1.8 * parseFloat(height)) - (4.7 * parseFloat(age));
                                    }
                                    result.innerHTML = "YOUR BMI: " + bmi * 10000 + "<br/>YOUR BMR: " + bmr + "<br/>YOUR DAILY CALORIES: " + bmr * parseFloat(activity);

                                    document.querySelector("#txtCalories").value = bmr * parseFloat(activity);
                                    document.querySelector("#recommendMeal").disabled = false;
                                }

                            }

                            const reset = () => {
                                document.querySelector("#opGender").value = "0";
                                document.querySelector("#txtAge").value = "";
                                document.querySelector("#txtHeight").value = "";
                                document.querySelector("#txtWeight").value = "";
                                document.querySelector("#opActivity").value = "0";
                                document.querySelector("#txtCalories").value = "";
                                document.querySelector("#recommendMeal").disabled = true;
                                document.querySelector("#calculateResult").innerHTML = "";
                            }

                            const recommendMealAsync = async () => {
//                                var xhr = new XMLHttpRequest();
//                                return new Promise(function (resolve, reject) {
//                                    xhr.onreadystatechange = function () {
//                                        if (xhr.readyState === 4) {
//                                            if (xhr.status >= 300) {
//                                                reject("Error, status code = " + xhr.status)
//                                            } else {
//                                                resolve(xhr.responseText);
//                                            }
//                                        }
//                                    }
//                                    xhr.onerror = function (e) {
//                                        console.error(xhr.statusText);
//                                    };
//                                    xhr.open('get', 'http://localhost:8084/SE1302_SE63513_Meal_Client/LoadFoodController?txtCalories=' + document.querySelector("#txtCalories").value, true);
//                                    xhr.send();
//                                });

                            };

                            const recommendMeal = async () => {
//                                alert("getFood")
//                                try {
//                                    let food = await recommendMealAsync();
//                                    console.log(food);
//                                } catch (err) {
//                                    console.log(err);
//                                }

                            };
                        </script>

                        <!--Form for calculation BMR and BMI-->
                        <form class="form-horizontal" name="cal_frm" id="cal_frm" action="LoadFoodController" method="POST">
                            <fieldset>
                                <!-- Form Name -->
                                <h1><legend>BMR CALCULATION</legend></h1>
                                <!-- Select Basic -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Gender</label>
                                    <div class="col-md-4">
                                        <select id="opGender" name="txtOpGender" class="form-control">
                                            <option value="0">Gentle men</option>
                                            <option value="1">Lady</option>
                                        </select>
                                    </div>
                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Age</label>
                                    <div class="col-md-4">
                                        <input id="txtAge" name="txtAge" value="${param.txtAge}" class="form-control input-md" type="number" placeholder="years">

                                    </div>
                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Height</label>
                                    <div class="col-md-4">
                                        <input id="txtHeight" name="txtHeight" value="${param.txtHeight}" class="form-control input-md" type="number" placeholder="cm">
                                    </div>
                                </div>

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="txtWeight">Weight</label>
                                    <div class="col-md-4">
                                        <input id="txtWeight" name="txtWeight" value="${param.txtWeight}" class="form-control input-md" type="number" placeholder="kg">

                                    </div>
                                </div>

                                <!-- Select Basic -->
                                <div class="form-group">
                                    <label class="col-md-4 control-label">Daily activation</label>
                                    <div class="col-md-4">
                                        <select id="opActivity" name="txtOpActivity" class="form-control">
                                            <option value="1.2">Rarely or never doing exercises</option>
                                            <option value="1.375">Casual (Casual Exercise - 1-3 times/week)</option>
                                            <option value="1.55">Often (Daily Exercise 3-5 days/week)</option>
                                            <option value="1.725">Positive (Hard Work Out 6-7 days/week</option>
                                            <option value="1.9">Passionate (Extreme Work Out)</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div id="thongbaoloi" class="alert alert-warning" role="alert" style="display: block;">
                                        <p>
                                            Incorrect information entered:<br/>
                                            Height must be between 100cm and 230cm!<br/>
                                            Weight must be from 30Kg to 150Kg!<br/>
                                            Age must be from 10 to 70!
                                        </p>
                                    </div>
                                </div>				


                                <!-- Button (Double) -->

                                <div class="form-group">
                                    <label class="col-md-4 control-label"></label>
                                    <div class="col-md-8">
                                        <input type="button" name="tinhbodyfat" class="btn btn-success" value="Calculate BMR" onclick="calculateBMR()">
                                        <input type="reset" class="btn btn-danger" value="Reset" onclick="reset()">

                                        <input id="txtCalories" name="txtCalories" class="form-control input-md" type="hidden" placeholder="calo">
                                        <input id="recommendMeal" disabled="true" type="submit" class ="btn btn-primary" value="Recommend meal">

                                    </div>
                                </div>


                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="col-md-4 control-label" for="textinput">Result</label>  
                                    <div class="col-md-5">
                                        <div id="calculateResult" class="alert alert-success" role="alert" style="font-weight:bold;"></div>
                                    </div>
                                </div>


                            </fieldset>
                        </form>
                    </div>  
                    <img src="ASSETS/IMAGE/01_Thap-dinh-duong-can-doi-cho-nguoi-truong-thanh-1-e1515991265261.jpg" style="width:100%;max-width:1000px;margin-top:32px;">
                </div>
            </div>
            <!--Script for display cooking method and material-->
            <script>
                const cooking = (cooking) => {
//                    let cookingForBreakfastClient = document.querySelector("#cookingForBreakfastClient");
//                    let foodID = document.querySelector("#foodID");
//                    let foodCookingMethod = document.querySelector("#foodCookingMethod");
//                    let foodMaterialDescription = document.querySelector("#foodMaterialDescription");
//                    let breakfast = localStorage.getItem("BREAKFAST");
//                    let arrFood = [...JSON.parse(breakfast)];
//                    alert(foodID.value)
//                    console.log(breakfast);
//                    cookingForBreakfastClient.innerHTML = cookingForBreakfastClient;
//                    cookingForBreakfastClient.style.display = "block";
                }
            </script>


            <!--Display food calculated-->
            <!--Breakfast-->
            <c:if test="${sessionScope.BREAKFAST != null}">
                <c:if test="${not empty sessionScope.BREAKFAST}">
                    <div class="w3-main w3-content w3-padding" style="max-width:1200px; align-content: center">
                        <h5 class="w3-left w3-padding-48"><span class="w3-tag w3-wide">BREAKFAST</span></h5>

                        <div class="w3-row-padding w3-padding-16 w3-center" id="foodForBreakfast">

                            <c:set var="doc" value="${sessionScope.BREAKFAST}"/>
                            <c:forEach var="list" items="${sessionScope.BREAKFAST}" varStatus="counter">
                                <div class="w3-quarter">
                                    <a href="${list.getHref()}"><img src="${list.getImage()}" alt="${list.getTitle()}" style="width:100%"></a>
                                    <h3>${list.getTitle()}</h3>
                                    <p>Carbohydrate: ${list.getCarbonhydrate()}<br/>
                                        Calories: ${list.getCalories()}<br/>
                                        Protein: ${list.getProtein()}<br/>
                                        Fat: ${list.getFat()}<br/>
                                        Fiber: ${list.getFiber()}</p><br/>
                                    <input type="hidden" value="${list.getId()}" id="foodID" />
                                    <a href="${list.getHref()}"><input type="button" id="howToCookOpen" class="btn btn-success" value="How to cook" onclick="cooking();"></a>
                                </div>
                                <div class="w3-threequarter"  id="cookingForBreakfastClient">
                                    Material:<br/>

                                    <hr/>
                                    Method:<br/>
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                </c:if>
            </c:if> 

            <!--            <div class="w3-sand w3-grayscale w3-large">
                            <div class="w3-container" id="menu">
                                Live search 
                                <div class="w3-content" style="max-width:1200px">
            
                                    <h5 class="w3-center w3-padding-48"><span class="w3-tag w3-wide">SEARCH YOUR INGREDIENT</span></h5>
            
                                    <div class="w3-row w3-center w3-card w3-padding" ">
                                        <input style="width: 80%;color:#a94442 " type="text" placeholder="Close" />
                                    </div>
            
                                    <div id="cookingForBreakfastClient" class="w3-container menu w3-padding-48 w3-card" style="display: none">
            
            
            
                                    </div> 
                                </div>
                            </div>
                        </div>-->



            <!--Display Cooking Method-->
            <!--            <div class=" w3-container w3-main w3-content w3-padding" style="width: 90%" id="cookingForBreakfast" style="display: none">
            
                        </div>
                        <div class="w3-main w3-content w3-padding" style="width: 100%; align-content: center" id="cookingForBreakfast" style="display: none">
                            Display Cooking Method
                            <div class="w3-row-padding w3-padding-16 w3-center" id="cookingForBreakfast" style="display: none">
            
                            </div>
                        </div>-->
            <!--Lunch-->
            <c:if test="${sessionScope.LUNCH != null}">
                <c:if test="${not empty sessionScope.LUNCH}">
                    <div class="w3-main w3-content w3-padding" style="max-width:1200px; align-content: center">
                        <h5 class="w3-left w3-padding-48"><span class="w3-tag w3-wide">LUNCH</span></h5>

                        <div class="w3-row-padding w3-padding-16 w3-center" id="foodForLunch">

                            <c:set var="doc" value="${sessionScope.LUNCH}"/>
                            <c:forEach var="list" items="${sessionScope.LUNCH}" varStatus="counter">
                                <div class="w3-quarter">
                                    <a href="${list.getHref()}"><img src="${list.getImage()}" alt="${list.getTitle()}" style="width:100%"></a>
                                    <h3>${list.getTitle()}</h3>
                                    <p>Carbohydrate: ${list.getCarbonhydrate()}<br/>
                                        Calories: ${list.getCalories()}<br/>
                                        Protein: ${list.getProtein()}<br/>
                                        Fat: ${list.getFat()}<br/>
                                        Fiber: ${list.getFiber()}</p><br/>
                                    <input type="hidden" value="${list.getId()}" id="foodID" />
                                    <input type="button" id="howToCookOpen" class="btn btn-success" value="How to cook" onclick="cooking();">
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                </c:if>
            </c:if> 

            <!--Dinner-->
            <c:if test="${sessionScope.DINNER != null}">
                <c:if test="${not empty sessionScope.DINNER}">
                    <div class="w3-main w3-content w3-padding" style="max-width:1200px; align-content: center">
                        <h5 class="w3-left w3-padding-48"><span class="w3-tag w3-wide">DINNER</span></h5>

                        <div class="w3-row-padding w3-padding-16 w3-center" id="foodForDinner">

                            <c:set var="doc" value="${sessionScope.DINNER}"/>
                            <c:forEach var="list" items="${sessionScope.DINNER}" varStatus="counter">
                                <div class="w3-quarter">
                                    <a href="${list.getHref()}"><img src="${list.getImage()}" alt="${list.getTitle()}" style="width:100%"></a>
                                    <h3>${list.getTitle()}</h3>
                                    <p>Carbohydrate: ${list.getCarbonhydrate()}<br/>
                                        Calories: ${list.getCalories()}<br/>
                                        Protein: ${list.getProtein()}<br/>
                                        Fat: ${list.getFat()}<br/>
                                        Fiber: ${list.getFiber()}</p><br/>
                                    <input type="hidden" value="${list.getId()}" id="foodID" />
                                    <input type="button" id="howToCookOpen" class="btn btn-success" value="How to cook" onclick="cooking();">
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                </c:if>
            </c:if> 

            <!-- End page content -->
        </div>

        <!-- Footer -->
        <footer class="w3-center w3-light-grey w3-padding-48 w3-large">
            <p>Powered by <a href="#" title="W3.CSS" target="_blank" class="w3-hover-text-green">deSigning</a></p>
        </footer>

        <script>
            // Tabbed Menu
            function openMenu(evt, menuName) {
                var i, x, tablinks;
                x = document.getElementsByClassName("menu");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablink");
                for (i = 0; i < x.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" w3-dark-grey", "");
                }
                document.getElementById(menuName).style.display = "block";
                evt.currentTarget.firstElementChild.className += " w3-dark-grey";
            }
        </script>

    </body>
</html>

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

    </head>
    <body onload="callINFO();">
        <script>
            const  callINFO = () => {
//                if (localStorage.getItem("LISTFOOD")) {
//                    alert("LISTFOOD");
//                } else {
//                    localStorage.setItem("LISTFOOD", JSON.stringify("${sessionScope.LISTFOOD}"));
//                    alert("NOT LISTFOOD");
//                }
//                console.log(localStorage.getItem("LISTFOOD"));
//
//                if (localStorage.getItem("DOMMATERIAL")) {
//                    alert("DOMMATERIAL");
//                } else {
//                    localStorage.setItem("DOMMATERIAL", JSON.stringify("${sessionScope.DOMMATERIAL}"));
//                    alert("NOT DOMMATERIAL");
//                }
//                console.log(localStorage.getItem("DOMMATERIAL"));
            };
        </script>
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

            <!-- About Container -->
            <div class="w3-container" id="about">
                <div class="w3-content" style="max-width:700px">
                    <h5 class="w3-center w3-padding-64"><span class="w3-tag w3-wide">ABOUT THE GYM</span></h5>
                    <p>The GYM was founded in blabla by Mr. Soi in lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                    <p>In addition to our full espresso and brew bar menu, we serve fresh made-to-order breakfast and lunch sandwiches, as well as a selection of sides and salads and other good stuff.</p>
                    <div class="w3-panel w3-leftbar w3-light-grey">
                        <p><i>"Use products from nature for what it's worth - but never too early, nor too late." Fresh is the new sweet.</i></p>
                        <p>Chef, Coffeeist and Owner: Liam Brown</p>
                    </div>
                    <img src="ASSETS/IMAGE/home-gym-room-in-the-attic-royalty-free-image-1092674152-1565968486.jpg" style="width:100%;max-width:1000px" class="w3-margin-top">
                    <p><strong>Opening hours:</strong> everyday from 7am to 5:30pm.</p>
                    <p><strong>Address:</strong> Lot 24 Quang Trung Software Park, HCMC</p>
                </div>
            </div>




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
            document.getElementById("myLink").click();
        </script>

    </body>
</html>

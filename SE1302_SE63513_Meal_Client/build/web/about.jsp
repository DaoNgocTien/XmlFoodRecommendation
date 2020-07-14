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
    <body onload="callINFO();">
        <script>
            const  callINFO = () => {
                let today = new Date().toLocaleDateString();
                document.querySelector("#txtDate").value = today;
//                if (localStorage.getItem("SESSIONINFO")) {
//                    alert(localStorage.getItem("SESSIONINFO"));
//                } else {
//                    localStorage.setItem("SESSIONINFO", ${sessionScope.LISTMATERIAL});
//                }
//                console.log(localStorage.getItem("SESSIONINFO"));
            }
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



            <!-- Contact/Area Container -->
            <div class="w3-container" id="where" style="padding-bottom:32px;">
                <div class="w3-content" style="max-width:700px">
                    <h5 class="w3-center w3-padding-48"><span class="w3-tag w3-wide">WHERE TO FIND US</span></h5>
                    <p>Find us at some address at some place.</p>
                    <img src="ASSETS/IMAGE/Findus.jpg" class="w3-image" style="width:100%">
                    <p><span class="w3-tag">the Gym!</span> We offer full-service catering for any event, large or small. We understand your needs and we will give you the best services to satisfy the biggest criteria of them all, both look and taste.</p>
                    <p><strong>Reserve</strong> a subscription, ask for today's special offer or just send us a message:</p>
                    <form action="SubscriptionController" method="POST">
                        <p><input class="w3-input w3-padding-16 w3-border" value="${param.txtName}" type="text" placeholder="Your Name" required name="txtName"></p>
                        <p><input class="w3-input w3-padding-16 w3-border" value="${param.txtEmail}" type="email" placeholder="And your email" required name="txtEmail"></p>
                        <p><input class="w3-input w3-padding-16 w3-border" value="${param.txtTitle}" type="text" placeholder="Your request title" required name="txtTitle" ></p>
                        <p><input class="w3-input w3-padding-16 w3-border" value="${param.txtDate}" id="txtDate" type="hidden" placeholder="Date and time" required name="txtDate"  ></p>
                        <p><input class="w3-input w3-padding-16 w3-border" value="${param.txtMessage}" type="text" placeholder="Message \ Special requirements" required name="txtMessage"></p>
                        <div class="form-group">
                            <div id="thongbaoloi" class="alert alert-warning" role="alert" style="display: block;">
                                <p>
                                    We appreciate your subscription<br/>
                                    <c:if test="${requestScope.SUBSCRIPTION != null}">
                                        <c:if test="${not empty requestScope.SUBSCRIPTION}">
                                            ${requestScope.SUBSCRIPTION}
                                        </c:if>
                                    </c:if>
                                </p>
                            </div>
                        </div>		
                        <p><button class="w3-button w3-black" type="submit">SUBSCRIPTION</button></p>
                    </form>
                </div>
            </div>

            <!-- End page content -->
        </div>

        <!-- Footer -->
        <footer class="w3-center w3-light-grey w3-padding-48 w3-large">
            <p>Powered by <a href="#" title="W3.CSS" target="_blank" class="w3-hover-text-green">deSigning</a></p>
        </footer>

    </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String username = (String) session.getAttribute("Username");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
<style>
body,h1,h2,h3,h4,h5 {font-family: "Poppins", sans-serif}
body {font-size:16px;}
.w3-half img{margin-bottom:-6px;margin-top:16px;opacity:0.8;cursor:pointer}
.w3-half img:hover{opacity:1}
</style>
<script>
// Script to open and close sidebar
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}
</script>
<style>
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}
</style>


<title>index</title>
</head>
<body>
<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;" id="mySidebar"><br>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-hide-large w3-display-topleft" style="width:100%;font-size:22px">ปิดเมนู</a>
  <div class="w3-container">
    <center><img src="http://www.science.mju.ac.th/chemistry/download/Logo/mju_logo.gif" style="width:150px;height:150px;padding:0px" ></center>
  </div>
   <hr>
  <div class="w3-bar-block"> 
    <a href="${pageContext.request.contextPath}/myprofile" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">หน้าแรก</a>
    <a href="${pageContext.request.contextPath}/EditProfile" class="w3-bar-item w3-button w3-hover-white" onclick="w3_close()">แก้ไขข้อมูลส่วนตัว</a>
    <a href="${pageContext.request.contextPath}/RepairList2" onclick="w3_close()" class="w3-bar-item w3-button w3-hover-white">รายการแจ้งซ่อมทั้งหมด</a> 
    <a href="${pageContext.request.contextPath}/InsertRepair" class="w3-bar-item w3-button w3-hover-white" onclick="w3_close()">แจ้งซ่อม</a>
    <a href="${pageContext.request.contextPath}/ShowStatus" class="w3-bar-item w3-button w3-hover-white" onclick="w3_close()">สถานะการแจ้งซ่อม</a>
    <a href="${pageContext.request.contextPath}/logout" class="w3-bar-item w3-button w3-hover-white" onclick="w3_close()">ออกจากระบบ</a>
  </div>
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-red w3-xlarge w3-padding">
  <a href="javascript:void(0)" class="w3-button w3-red w3-margin-right" onclick="w3_open()">☰</a>
  <span>มหาวิทยาลัยแม่โจ้</span>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:340px;margin-right:40px">
<!-- Header -->
  <!-- Header -->
  <div class="w3-container" style="margin-top:50px" id="showcase">
    <h1 class="w3-xxxlarge"><b>สวัสดี</b></h1>
    <h1 class="w3-xlarge w3-text-red"><b>${user.getUsername()}</b></h1>
    <hr style="width:50px;border:5px solid red" class="w3-round">
  </div>
  
 <!-- Photo grid (modal) -->
  <div>
   	<center><div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="https://goo.gl/kniG1C" style="width:70%">
  <div class="text">Home Page</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="https://goo.gl/X4rL33" style="width:70%">
  <div class="text">Home Page</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="https://goo.gl/XJw3rH" style="width:70%">
  <div class="text">Home Page</div>
</div>

</div></center>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>
  </div>
 <script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 5000); // Change image every 2 seconds
}
</script>
  
 
  
  
<!-- W3.CSS Container -->

<footer class="w3-light-grey w3-container w3-padding-32" style="margin-top:75px;padding-right:58px">
<p class="w3-center"><span>สำนักงานคณะวิทยาศาสตร์</span> มหาวิทยาลัยแม่โจ้</p>
</footer>
</body>
</html>
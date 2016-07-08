<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<head>
<meta charset="UTF-8">
<title>DevOps Self Service Demo </title>
</head>
<style>
    .addBorder {
  /* Thickness, Style, and Color */
  border: 4px solid #808080;
  width: 160px;
  height: 160px;
   margin: 10px 15px 10px 10px; 
}
    .addBorderTool {
  /* Thickness, Style, and Color */
  width: 160px;
  height: 160px;
   float: left;
}
 
.toolName{
   text-align: center;
    display:inline-block;
   font-weight: bold;
  font-size: 120%;
}
.demoButton {
    position:absolute;
    transition: .5s ease;i th
    top: 80%;
    left:25%;
  background: #3498db;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 12;
  -moz-border-radius: 12;
  border-radius: 12px;
  font-family: Arial;
  color: #ffffff;
  font-size: 20px;
  padding: 15px 35px 15px 35px;
  text-decoration: none;
}

 .inline { 
    border:solid 1px black;
    display:inline-block;
    border: 4px solid gray; 
    width:160px;
    height:160px;
    margin: 15px 15px 10px 10px; 
    
 }
  
    
.demoButton:hover {
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
} 

     .toolContainer{
     width:800px;
     height: 205px;
      border: 4px solid gray;
    padding: 20px 15px;

     }
     .tool_Name{
     position: absolute;
     text-align: center;
     font-weight: bold;
     font-size:120%;
     width:160px;
     height:160px;
     }
​
</style>

<body>
<canvas id="ssd_header" width="1300" height="50" style="border:3px solid #808080;"> </canvas>
<script>
var canvas = document.getElementById("ssd_header");
var ctx = canvas.getContext("2d");

ctx.fillStyle = "#DFECF0";
ctx.fillRect(0, 0, 1500, 60);

ctx.font = "30px Arial";
ctx.fillStyle = "black";

ctx.fillText("DST Devops Self Service Portal",220,35);
ctx.restore();

function drag(evt)
{
evt.dataTransfer.setData("text",evt.target.id);
}


function enableDrop(evt,divId)
{
	//evt.preventDefault();
dragged_item=evt.dataTransfer.getData("text");
//document.getElementById("demo").innerHTML =dragged_item;
document.getElementById(divId).innerHTML = "";
element = document.getElementById(dragged_item).firstChild.getAttribute("src");
img=document.createElement("img");
img.src=element;
img.id=divId;
img.height=160
img.width=160
var foo = document.getElementById(divId);
foo.appendChild(img); 

}
 

function drop(evt)
{
evt.preventDefault();
var dragged_item=evt.dataTransfer.getData("text");
evt.target.appendChild(document.getElementById(dragged_item));
}
 </script>

<p> Select a tool chain below or drag and drop tools from the palette on to the canvas to build your own tool chain</p>
<div>
<img src="./images/ibm_logo.jpg" alt="ibm_logo"class="addBorder"/>
<img src="./images/group.jpg" alt="group"  class="addBorder"/>
<img src="./images/atlassian.jpg" alt="atlassian" class="addBorder"/>
<img src="./images/recommanded.jpg" alt="recommanded" class="addBorder"/>
</div>
<div class="toolContainer">
<div class="inline" id="scm_holder" ondrop="drop(event)" ondragover="enableDrop(event, this.id)"><img src="./images/scm.jpg" class="addBorderTool"></div>
<div class="inline" id="build_holder" ondrop="drop(event)" ondragover="enableDrop(event, this.id)"><img src="./images/build.jpg" class="addBorderTool"></div>
<div class="inline" id="deploy_holder" ondrop="drop(event)" ondragover="enableDrop(event, this.id)"><img src="./images/deploy.jpg" class="addBorderTool"></div>
<div class="inline" id="test_holder" ondrop="drop(event)" ondragover="enableDrop(event, this.id)"><img src="./images/test.png" class="addBorderTool"></div>
<div class="tool_Name" style="margin:0px 1px 10px 10px;">SCM</div>
<div class="tool_Name" style="margin:0px 1px 10px 210px;">Build</div>
<div class="tool_Name" style="margin:0px 1px 10px 410px;">Deploy</div>
<div class="tool_Name" style="margin:0px 1px 10px 610px;">Test</div>
</div>
<form id="startDemo" action="http://www.google.com">
<input class="demoButton" type="submit" value="Submit">
</form>
<div id="drag_me" ondragstart="drag(event)" ><img id="drag_me" src="./images/test.png" draggable="true" width=120 height=120></div>
<div id="drag_me1" ondragstart="drag(event)" ><img id="drag_me1" src="./images/scm.jpg" draggable="true" width=120 height=120 ></div>
</body>
</html>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Files list</title>
		<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="/js/upload.js"></script>
		<link rel="stylesheet" type="text/css" href="/css/upload.css"/>
	</head>
	<body>
<h3 style="background-color:Tomato;">File Uploaded</h3> 
<c:out value="${message}"/><br><br><br>
	Click <a href="/fileupload.html">here</a> to upload more files.
	<hr size="4" color="gray"/>
	<table>
	 	<tr>
	       	<td>Select individual file to see the words details - </td>
	    </tr>
		<c:forEach items="${files}" var="fileName" varStatus="filecount">
	    <tr>
	    	<td><a class="fileclass" id="fileid ${filecount.index }" href="#"  data-fileName="${fileName}"><c:out value="${fileName}"/></a></td>
	   	</tr>
		</c:forEach>
		 <tr>
	       <td>&nbsp;</td>
	    </tr>
	</table>
	<hr size="4" color="gray"/>
	
	<h3 style="background-color:Tomato;">File Details</h3> <br>
		
	 <div id="filedata"></div> 
	</body>
</html>
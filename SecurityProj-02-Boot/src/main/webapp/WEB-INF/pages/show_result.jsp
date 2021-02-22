<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color:fuchsia; text-align:center">${opration} Information</h1>
<c:choose>
	<c:when test="${infoList ne null && !empty infoList}">
		<table align="center">
			<c:forEach var="list" items="${infoList}">
				<tr>
					<td>${list}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	
	<c:otherwise>
		<h2 style="color:red; text-align:center">No Country to display</h2>
	</c:otherwise>

</c:choose>

count=${count}

<a href="welcome">home</a><br>
<a href="logout">logout</a>

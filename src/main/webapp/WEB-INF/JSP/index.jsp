<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html lang="nl">
	<head>
		<title>Albums</title>
		<link rel='icon' href='<c:url value="/images/favicon.ico"/>'>
		<meta name='viewport' content='width=device-width,initial-scale=1'>
		<link rel='stylesheet' href='<c:url value="/styles/default.css"/>'>
	</head>
	<body>
		<h1>Albums</h1>
		<c:if test="${not empty albums}">
			<h2>Alle albums:</h2>
			<table>
				<thead>
					<tr>
						<th>Album</th><th>Artiest</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${albums}" var="album">
						<c:url value="" var="detailURL">
							<c:param name="id" value="${album.id}"/>
						</c:url>
						<tr>
							<td><a href="${detailURL}" title="${album.naam}">
							${album.naam}</a></td>
							<td>${album.artiest.naam}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${not empty album}">
			<h2>${album.naam} van ${album.artiest.naam}</h2>
			<h3>Tracklijst:</h3>
			<table>
				<thead>
					<tr>
						<th>Track</th><th>Duur</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${album.tracks}" var="track">
						<tr>
							<td>${track.naam}</td>
							<td><fmt:formatNumber value="${track.tijd}"
							minFractionDigits="2" maxFractionDigits="2"/></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Totale duurtijd</th>
						<th><fmt:formatNumber value="${album.getAlbumduur()}"
						minFractionDigits="2" maxFractionDigits="2"/></th>
					</tr>
				</tfoot>
			</table>
		</c:if>
		<c:if test="${empty album and not empty param}">
			Dit album is niet gevonden.
		</c:if>
	</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>


<body>
<div class="spittleForm">
    <h1>Spit it out...</h1>
    <form id="spittleForm" method="POST" name="spittleForm">
        <input type="hidden" name="latitude" value="0">
        <input type="hidden" name="longitude" value="0">
        <textarea name="message" cols="80" rows="5"></textarea><br/>
        <input type="submit" value="Add"/>
    </form>
</div>
<div class="listTitle">
    <h1>Recent Spittles</h1>
    <ul class="spittleList">
        <c:forEach items="${spittleList}" var="spittle">
            <li id="spittle_<c:out value="spittle.id"/>">
                <div class="spittleMessage"><c:out value="${spittle.message}"/></div>
                <div>
                    <span class="spittleTime"><c:out value="${spittle.date}"/></span>
                    <span class="spittleLocation">(<c:out value="${spittle.latitude}"/>, <c:out
                            value="${spittle.longitude}"/>)</span>
                </div>
            </li>
        </c:forEach>
    </ul>
    <c:if test="${fn:length(spittleList) gt 20}">
        <hr/>
        <s:url value="/spittles?count=${nextCount}" var="more_url"/>
        <a href="${more_url}">Show more</a>
    </c:if>
</div>
</body>
<script>
    var form = document.getElementById("spittleForm");
    form.addEventListener("submit", getLocation);

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(success, error);
        } else {
            alert("Geolocation is not supported by this browser");
        }
        return false;
    };

    function success(position) {
        document.getElementById("latitude").value = position.coords.latitude;
        document.getElementById("longitude").value = position.coords.longitude;
        form.submit();
    }

    function error() {
        alert("Unable to retrieve you location");
    }
</script>


</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<table>
  <thead>
  <th>책ID</th>
  <th>이름</th>
  <th>장르</th>
  </thead>

  <tbody>
  <c:forEach var="item" items="books">
    <tr>
      <td>${item.id}</td>
      <td>${item.name}</td>
      <td>${item.genre}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Group Page</title>
</head>

<body>
<div class="container">
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <br>
    <br>
    <h1>All Groups</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Num</th>
            <th>Department</th>
            <th>Action</th>
        </tr>
        </thead>
        <c:forEach  items="${GroupList}" var ="group">
            <tr>
                <td>${group.id}</td>
                <td>${group.num}</td>
                <td><c:forEach var="department" items="${group.department}" varStatus="loop">
                    ${department}
                    <c:if test="${not loop.last}">,</c:if>
                </c:forEach></td>
                <td>
                    <button type="button" class="btn btn-info" onclick="location.href='/group/${group.id}'">Details</button>
                    <button type="button" class="btn btn-primary" onclick="location.href='/group/update/${group.id}'">Update</button>
                    <button type="button" class="btn btn-danger" onclick="location.href='/group/delete/${group.id}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<br>
<button type="button" class="btn btn-success btn-lg my-2 col-2 offset-5" data-toggle="modal" data-target="#exampleModalCenter">Create</button>
<div class="col-10 offset-1">
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Add new group</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="POST" action="/group/create">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="num" class="col-form-label">Num:</label>
                            <input type="number" name="num" class="form-control" id="num">
                        </div>
                        <div class="form-group">
                            <label for="department" class="col-form-label">Department:</label>
                            <input type="text" name="department" class="form-control" id="department">
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button class="btn btn-primary"  type="submit">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
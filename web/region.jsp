<%-- 
    Document   : region
    Created on : Jun 22, 2019, 12:25:48 PM
    Author     : Arif Fridasari
--%>

<%@page import="models.Region"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <!-- Font Style-->
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab&display=swap" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Merienda:700&display=swap" rel="stylesheet"> 

        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#d_table').DataTable();
            });
        </script>
    </body>
    <title>Data Tables </title>
    <%@ include file='header_region.jsp' %>
<p><br/></p>
    <%
        List<Region> regions = (List<Region>) session.getAttribute("regions");
        Region region = (Region) session.getAttribute("region");
        boolean isRegionNull = regions == null;
        if (isRegionNull) {
            response.sendRedirect("region");
        }


    %>

<div class="container mt-5" style="font-family: 'Roboto Slab', serif;" >
    <h1 class="text-center mb-4" style="font-family: 'Merienda', cursive;">Region Table</h1>
    <form class="container" action="region" method="POST">
        <table class="table table-striped table-bordered table-hover">
            <tr>
                <td>ID :</td>
                <td><input type="text" name="regionId" value="<%=(region != null) ? region.getId() : ""%>" /></td>
            </tr>
            <tr>
                <td>Name :</td>
                <td><input type="text" name="regionName" value="<%=(region != null) ? region.getName() : ""%>" /></td>
            </tr>
            </tr>
            <div>
                <td colspan="2"><button class="btn btn-primary float-right" type="submit" value="Save" />Save</td>
            </div>
            </tr>
        </table>
    </form>

    <table class="table table-striped table-bordered table-hover" id="d_table">
        <thead class="thead-dark">
            <tr>
                <th>No</th>
                <th>ID</th>
                <th>Name</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <%
                int i = 1;
                if (!isRegionNull) {
                    for (Region region1 : regions) {
                        if (region1.getCountryList().isEmpty()) {

            %>
            <tr>
                <td><%=i++%></td>
                <td><%=region1.getId()%></td>
                <td><%=region1.getName()%></td> 
                <td><a class="btn btn-primary" href="region?action=update&id=<%=region1.getId()%>">update</a></td>
                <td><a class="btn btn-danger" href="region?action=delete&id=<%=region1.getId()%>">delete</a></td>


                <%  } else {%>
                <td><%=i++%></td>
                <td><%=region1.getId()%></td>
                <td><%=region1.getName()%></td>               
                <td><a class="btn btn-primary" href="region?action=update&id=<%=region1.getId()%>">update</a></td>
                <td><a class="btn btn-secondary">delete</a></td>
            </tr >
            <%        }
                    }
                }
            %>
        </tbody>
    </table>        

</div>
</head>
<%@ include file='footer.jsp'%>
</body>
<%
    session.removeAttribute("regions");
    session.removeAttribute("region");
%>
</html>

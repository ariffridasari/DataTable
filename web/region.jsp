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


        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#d_table').DataTable();
            });
        </script>
    </body>
    <title>Data Tables </title>
        <p><br/></p>
            <%
                List<Region> regions = (List<Region>) session.getAttribute("regions");
                Region region = (Region) session.getAttribute("region");
                boolean isRegionNull = regions == null;
                if (isRegionNull) {
                    response.sendRedirect("region");
                }
            %>
        <div class="container">
            <h1>Data Table</h1>
            <table class="table table-striped table-bordered table-hover" id="d_table">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>Name</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int i = 1;
                        if (!isRegionNull) {
                            for (Region region1 : regions) {
                    %>
                    <tr>
                        <td><%=i++%></td>
                        <td><%=region1.getId()%></td>
                        <td><%=region1.getName()%></td>
                    </tr    >
                    <%  }
                        }
                    %>
                </tbody>
            </table>        

        </div>
</head>
</body>
<%
    session.removeAttribute("regions");
    session.removeAttribute("region");
%>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
</html>


<%@page import="etu1835.framework.model*"%>
<%@page import="java.util.*"%>
<%
    List<Dept> list = null;
    if(request.getAttribute("listdept")==null){
      out.print("tsy tonga");
    }else{
       list = (List<Dept>) (request.getAttribute("listdept"));
    } 
     
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doc</title>
</head>
<body>
    <p>Holla</p>
        <form  action="insert">
        <h1>Formulaire</h1>

                <p> Departement :  <select name="deptno" class="form-control" required>
                    for(int i=0; i<list.size; i++){ %>
                        <option value=<% out.println(list.get(i).getId());%> >list.get(i).getLibele</option>
                       <%
                       }
                       %>
                </select>
            </p>
        <p> Nom :<input type="text" name="nom" id="name"> </p> 
        <p> Salaire :<input type="text" name="salaire" id="salaire"> </p>
        <p> Poste : <input type="text" name="job" id="job"> </p>
        <input type="submit" value="Soumetre">
    </form>

</body>
</html>

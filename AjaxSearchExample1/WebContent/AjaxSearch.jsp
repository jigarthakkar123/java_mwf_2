    <%@ page import="java.sql.*" %>  
    <%  
    String name=request.getParameter("val");  
    if(name==null||name.trim().equals(""))
    {  
    	out.print("<p>Please Enter Name!</p>");  
    }
    else
    {  
    	try
    	{  
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biren","root","");  
    		PreparedStatement ps=con.prepareStatement("select * from product where product_category like '"+name+"%'");  
    		ResultSet rs=ps.executeQuery();  
      		if(!rs.isBeforeFirst()) 
      		{      
     			out.println("<p>No Record Found!</p>");   
    		}
      		else
      		{  
    			out.print("<table border='1' cellpadding='2' width='100%'>");  
    			out.print("<tr><th>Product Category</th><th>Product Type</th><th>Product Price</th><th>Product Description</th></tr>");  
    			while(rs.next())
    			{  
    				out.print("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(7)+"</td></tr>");  
    			}  
    			out.print("</table>");  
    		}  
    		con.close();  
    	}
    	catch(Exception e)
    	{
    		out.print(e);
    	}  
    }  
    %>  
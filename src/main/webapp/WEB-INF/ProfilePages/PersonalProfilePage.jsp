<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="polimi.blog.model.*" %>
<%@page import="polimi.blog.dao.*" %>
<!DOCTYPE html>
<html style="overflow-y: hidden;">
    <head>
    
            <%User u = (User) request.getSession().getAttribute("user"); %>
            <%u = DAOFactory.getDAOFactory().getUserDAO().mergeUser(u); %>
    
        <title>@<%=u.getUsername()%></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%=request.getContextPath()%>/styles/bulma.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/styles/profileStyle.css" rel="stylesheet">
    </head>

    <body>
        <div class="columns" style="margin-top: 2rem">
            <div class="column is-10 is-offset-1">
                <div class="columns">
                    <!-- Username -->
                    <div class="column is-narrow">
                        <div class="link-button-container">
                            <form action="<%=request.getContextPath()%>/HomeServlet" method="POST"> 
                                <button type="submit" class="link-button label-link">&lt;- Go back</button>
                            </form> 
                        </div>
                        <h1 class="title is-2" style="color:white;">
                            @<%=u.getUsername()%>
                        </h1>
                    </div>
                    <!-- Subscriber Count -->
                    <div class="column is-narrow detail-label subscribers-label">
                        <%= (Long) request.getSession().getAttribute("counter") %> subscribers
                    </div>
                </div>
                <!-- Info Label -->
                <h1 class="title is-4" style="color:white;">
                    Info:
                </h1>
                <div class="columns">
                    <!-- Info -->
                    <div class="column is-full">
                        <p style="color:white;">               
                        <%if(u.getInfo() == null || u.getInfo().isEmpty()){ %>
                        	No Description.
                        <%} else {%>
                        	<%= u.getInfo() %>
                        	<%} %>               
                        </p>
                    </div>
                </div>
                <div class="columns">
                    <!-- Modify Infos -->
                   	<form action="<%=request.getContextPath()%>/PersonalProfileServlet" method="POST">
	                    <div class="column is-10">
	                        <div class="field block">
	                            <div class="control" style="width: 100%;">
	                                <textarea class="textarea text-input" rows="1" placeholder="Write here to update your Info!" name="info" style="width = 90%;"></textarea>
	                            </div>
	                        </div>
	                    </div>
                    <!-- Modify Infos Button -->
                    <div class="column is-2">
                        <button type="submit" class="button is-fullwidth update-info-button"><b>Update Info</b></button>
                    </div>
                  </form>        
            	   	<form action="<%=request.getContextPath()%>/CreatePostServlet" method="GET">
		                 <div class="column is-2">
	                        <button type="submit" class="button is-fullwidth update-info-button"><b>Create a post!</b></button>
	                    </div>
             		</form>  
                </div>
                <!-- Divisor -->
                <hr style="border-top: 2px solid #bbb;"></hr>
                <div class="columns">
                    <div class="column is-10 is-offset-1">
                        <!-- Posts Content -->
                        <div class="columns">
                            <!-- Space for Posts -->
                            <div class="column is-full post-space">
                                <!-- Post -->
                                <%if(u.getPosts().isEmpty()){ %>
                                	<div class="post-title block">No post here. Create a new one! </div>
                                	<%} else{ %>
	                              <%for(Post p : u.getPosts()){ %>  
		                                <div class="list-element">
		                                    <!-- Posted on Date -->
		                                    <div class="detail-label">		        
		                                        Posted on <%=p.getPostDate().toLocalDate() %>		                                        
		                                    </div>
		                                    <!-- Post Title Preview -->
			                                    <form action="<%=request.getContextPath()%>/PostServlet" method="POST">
			                                    <%request.getSession().setAttribute("post", p); %>
			                                    <div class="post-title block">
			                                    	<button type="submit"><%=p.getTitle() %></button>
			                                    </div>
			                                    </form>
		                                    <!-- Post Content Preview -->
		                                    <div>
		                                        <p>													
													<%=p.getContent()%>
		                                        </p>
		                                    </div>
		                                </div>
	                                <%}%>
                               	 <%}%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


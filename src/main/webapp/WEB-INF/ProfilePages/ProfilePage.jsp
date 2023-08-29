<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="polimi.blog.model.*" %>
<%@page import="polimi.blog.dao.*" %>
<!DOCTYPE html>
<html style="overflow-y: hidden;">
    <head>
        <title>@"profilename"</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%=request.getContextPath()%>/styles/bulma.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/styles/profileStyle.css" rel="stylesheet">
    </head>

	<%User su = (User) request.getSession().getAttribute("searcheduser"); %>
	<%su = DAOFactory.getDAOFactory().getUserDAO().mergeUser(su); %>

    <body>
        <div class="columns" style="margin-top: 2rem">
            <div class="column is-10 is-offset-1">
                <div class="columns">
                    <!-- Username -->
                    <div class="column is-narrow">
                        <div class="link-button-container">
                            <form action="<%=request.getContextPath()%>/RemoveAttributeServlet" method="POST">
                                <button type="submit" class="link-button label-link">&lt;- Go back</button>
                            </form>
                        </div>
                        <h1 class="title is-2" style="color:white;">
                            @<%=su.getUsername() %>
                        </h1>
                    </div>
                    <!-- Subscriber Count -->
                    <div class="column is-narrow detail-label subscribers-label">
                        <%=(Long) request.getSession().getAttribute("counter")%> subscribers
                    </div>
                    <!-- Follow Button -->
                    
                    <%request.getSession().setAttribute("searcheduser", su);%>
                    <%boolean subcheck = (boolean) request.getSession().getAttribute("checksub");%>
                    <div class="column is-narrow" style="margin-left: auto;">
                    <form action="<%=request.getContextPath()%>/SubToBloggerServlet" method="POST">
                        <button class="button is-medium button-input" type="submit" style="color:lightgray">
                           
                           <%if(subcheck){ %>
							  Unfollow
                            <%}else {%>
                            Follow
                            <%} %>
                            
                        </button>
                        </form>
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
                        <%=su.getInfo() %>
                        </p>
                    </div>
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
                               <%if(su.getPosts() == null || su.getPosts().isEmpty()){ %> 
                                    <div class="post-title block">
                                    	No posts here.
                                    </div>
                                    <%}else{ %>
	                                <% for(Post p : su.getPosts()) {%>
	                                
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
												<%=p.getContent() %>
	                                        </p>
	                                    </div>
	                                </div>
	                                <%} %>
                                <%} %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="polimi.blog.model.*" %>
<!doctype html>
<html style="overflow-y: hidden;">

        <%User u = (User) request.getSession().getAttribute("user"); %>
        
    <head>
        <title>@<%=u.getUsername()%>'s Home Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%=request.getContextPath()%>/styles/bulma.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/styles/homePageStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.css">
    </head>

    <body style="color:white;">
        <!-- Topbar -->
        <div class="columns topbar">
            <div class="column is-full">
                <div class="columns">
                    <!-- Topbar Left -->
                    <div class="column is-9">
                        <div class="columns">
                            <!-- Content Search -->
                            <div class="column is-5">
                                <div class="columns">
                                    <div class="column is-11 is-offset-1">
                                        <div class="field block">
                                            <div class="control">
                                                <input type="text" class="input is-medium text-input" placeholder="Search">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Tag Search -->
                            <div class="column is-4">
                                <div class="field block">
                                    <div class="control">
                                        <input type="text" class="input is-medium text-input" placeholder="Eg. Dogs, Cooking, Gardening...">
                                    </div>
                                </div>
                            </div>
                            <!-- Post/Profile Selector -->
                            <div class="column is-2">
                                <div class="select is-rounded is-fullwidth is-medium" >
                                    <select style="background-color: #010409; border: 0; color: gray;">
                                        <option>Search in Posts</option>
                                        <option>Search in Profiles</option>
                                    </select>
                                </div>
                            </div>
                            <!-- Search Button -->
                            <div class="column is-1">
                          	  <form action="<%=request.getContextPath()%>/SearchServlet" method="POST">
	                                <button class="button is-rounded is-medium button-input" type="submit">
	                                 	 <span class="icon">
	                                        <i class="fas fa-search my-icon"></i>
	                                    </span>
	                                </button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Topbar Right -->
                    <div class="column is-2 is-offset-1">
                        <div class="columns">
                            <!-- Spacer Column -->
                            <div class="column is-3"></div>
                            <!-- Profile Link Button -->
                            <div class="column is-narrow">
                    			<form action="<%=request.getContextPath()%>/PersonalProfileServlet" method="POST">
                                <button class="button is-rounded is-medium button-input" type="submit">
                                    <span class="icon">
                                        <i class="fa-solid fa-at" style="color:white"></i>
                                    </span>
                                </button>
                                </form>
                            </div>
                            <!-- Logout Button -->
                            <form action="<%=request.getContextPath()%>/LogoutServlet" method="POST">
	                            <div class="column is-narrow">
	                                <button class="button is-medium button-input" type="submit" style="color:lightgray">
	                                    Logout
	                                </button>
	                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
		<%List<Post> ps = (List<Post>) request.getSession().getAttribute("posts"); %>
		<%List<User> fu = (List<User>) request.getSession().getAttribute("followedusers"); %>
    
        <!-- Page Content -->
        <div class="columns">
	            <div class="column is-10 is-offset-1">
	                <div class="columns">
	                    <!-- Space for Posts -->
	                    <div class="column is-9 post-space">
                        <%if(fu == null || fu.isEmpty()){ %>
	                     	
                        
                        <form action="<%=request.getContextPath()%>/ShowBlogsServlet" method="POST">
                            <div class="post-title block">
                                It seems you don't have any subscriptions! 
                             	Click  <button class="button is-medium button-input" type="submit" style="color:lightgray"> >here&lt; </button>
                             	 to see some blogs
                            </div>
                        </form>
	                     		
	                     <%} else if(ps.isEmpty()) {%>
	                     	
                        <form action="<%=request.getContextPath()%>/ShowBlogsServlet" method="POST">
                            <div class="post-title block">
                                It seems there is nothing to see here for today! 
                             	Click  <button class="button is-medium button-input" type="submit" style="color:lightgray"> >here&lt; </button>
                             	to check some other blogs
                            </div>
                        </form>
	                     	
	                     <%} else { %>
	                     
	                    <%for(Post p : ps){%>
	                      	  <!-- Post -->
		                        <div class="list-element">
		                            <!-- Posted By Author on Date -->
		                            <div class="detail-label">
		                                Posted by <b class="label-link">@<%=p.getUser().getUsername()%></b> on <%=p.getPostDate() %>
		                            </div>
		                            <!-- Post Title Preview -->
		                            <div class="post-title block">
		                                <%=p.getTitle() %>
		                            </div>
		                            <!-- Post Content Preview -->
		                            <div>
		                                <p>
											<%=p.getContent() %>
		                                </p>
		                            </div>
		                        </div>
		                        <%}%>
	                     <%}%>
	                    <!-- Space for Followed Users -->
	                    <div class="column is-3 followed-space">
	                        <!-- Followed Users Label -->
	                        <div class="followed-users-label">
	                            <b>Followed Users:</b>
	                        </div>
	                        <!-- Followed User -->
	                        
                        <%if(fu == null || fu.isEmpty()){ %>
	                        	No Followed :/
	                        <%}else{ %>
		                       <%for(User fd : fu){ %> 
		                       <form action="<%=request.getContextPath()%>/ProfileServlet" method="POST">
		                        	<div class="list-element label-link followed-profile">
		                           		  <button class="link-button label-link" type="submit" ><b><%=fd.getUsername()%></b></button>
		                       		 </div>
		                        </form>
		                        <%} %>
	                        <%} %>
	                    </div>
	                </div>
	            </div>
	        </div>
        </div>
    </body>
</html>


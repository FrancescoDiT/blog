<%@page import="polimi.blog.dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="polimi.blog.model.*" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.time.LocalDate" %>
<%@page import="java.util.LinkedHashSet"%>
<!doctype html>
<html>

		<%User u = (User) request.getSession().getAttribute("user"); %>
		<%Post p = (Post) request.getSession().getAttribute("post"); %>
		<%
		@SuppressWarnings("unchecked")
		LinkedHashSet<Comment> comments = (LinkedHashSet<Comment>) request.getSession().getAttribute("comments");
		%>
		<%
		@SuppressWarnings("unchecked")
		LinkedHashSet<Tag> tags = (LinkedHashSet<Tag>) request.getSession().getAttribute("tags"); 
		%>

    <head>
        <title><%=p.getTitle()%></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%=request.getContextPath()%>/styles/bulma.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/styles/postStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.css">
    </head>

    <body style="margin-top: 2rem; color:white;">
        <div class="columns is-mobile">
            <div class="column is-10 is-offset-1">
                <div class="link-button-container">
                   	<form action="<%=request.getContextPath()%>/RemoveAttributeServlet" method="POST">
               		     <button class="link-button label-link" type="submit" >&lt;- Go back</button>
                	</form>
                </div>
                
             	 <p class="help is-danger" id="post-error">
					<% if(request.getAttribute("post-error") != null && request.getAttribute("post-error") != "") { %>
					<%=request.getAttribute("post-error")%>
					<% } %>
				</p>
                
                <div class="columns is-mobile">
                    <div class="column is-8">
                        <!-- Posted By Author -->
                       	<form action="<%=request.getContextPath()%>/ProfileServlet" method="POST">
	                        <div class="detail-label">
	                            Posted by <button type="submit" name="username" value="<%=p.getUser().getUsername()%>"><b class="label-link">@<%=p.getUser().getUsername()%></b></button>
	                        </div>
                        </form>
                        <!-- Post Title -->
                        <div class="post-title">
                        	 <%= p.getTitle()%>
                        </div>
                        <!-- Post Date -->
                        <div class="detail-label">
                            Posted on <%= p.getPostDate().toLocalDate() %>
                        </div>
                    </div>
                    <!-- Tags -->
                    <div class="column">
                        <div class="columns .is-variable is-multiline">
                        <%if(tags == null || tags.isEmpty()){ %>
                        <%}else{%>
                        <%for(Tag t : tags){ %>
                            <div class="column is-narrow label-link tag-label">
	                            <form action="<%=request.getContextPath()%>/TagSearchServlet" method="POST"> 
	                                <button type="submit" value="<%=t.getName()%>" name="tag_id"  >#<%=t.getName() %></button>
	                            </form>  
                            </div>
                            <% } %>
                          <% } %>
                        </div>
                    </div>
                </div>
                <!-- Content -->
                <div>
                    <p>
						<%=p.getContent() %>
                    </p>
                </div>
                <!-- Divisor -->
                <hr class="divisor"></hr>
                <!-- Comments -->
                <div class="block" style="font-size: x-large; font-weight: bold;">
                    Comments:
                </div>
                <!-- Comment Maker-->
                <div class="columns">
                    <div class="column is-half">
                    	<form action="<%=request.getContextPath()%>/ReloadPostServlet" method="POST">
	                        <div class="field has-addons">
	                            <div class="control" style="width: 100%;">
	                                <input type="text" class="input comment-input" placeholder="Write a comment!" name="comment">
	                            </div>
	                            <div class="control">
	                                <button class="button" type="submit" style="background-color: #010409; border: 0;">
	                                    <i class="fa-solid fa-paper-plane" style="color: gray;"></i>
	                                </button>
	                            </div>
	                        </div>
                        </form>
                    </div>
                </div>
                <div>
                
                <%if(comments == null || comments.isEmpty()){ %>
                	<div>No Comments.</div>
                	<%}else{ %>
	                  <%for(Comment c : comments) { %>
	                    <div class="block">
	                        <!-- Comment Posted By Author -->
	                        <div class="detail-label">
	                            Posted by <b class="label-link">
	                            @<%=c.getUser().getUsername() %>
	                            </b>
	                        </div>
	                        <!-- Comment Content -->
	                        <div>
	                            <%=c.getContent() %>
	                        </div>
	                    </div>
	                    <%} %>
                    <%} %>
                </div>
            </div>
        </div>
    </body>
</html>
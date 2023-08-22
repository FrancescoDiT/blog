<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="polimi.blog.model.*" %>
<%@page import="java.util.List" %>
<%@page import="java.time.LocalDate" %>
<!doctype html>
<html>
    <head>
        <title>"post title"</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%=request.getContextPath()%>/styles/bulma.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/styles/postStyle.css" rel="stylesheet">
    </head>

		<%User u = (User) request.getSession().getAttribute("User"); %>
		<%Post p = (Post) request.getSession().getAttribute("Post"); %>

    <body style="margin-top: 2rem; color:white;">
        <div class="columns is-mobile">
            <div class="column is-10 is-offset-1">
                <div class="link-button-container">
                    <a class="link-button label-link" href="-">&lt;- Go back</a>
                </div>
                <div class="columns is-mobile">
                    <div class="column is-8">
                        <!-- Posted By Author -->
                        <div class="detail-label">
                            Posted by <b class="label-link">@<%=p.getUser().getUsername()%></b>
                        </div>
                        <!-- Post Title -->
                        <div class="post-title">
                        	 <% p.getTitle();%>
                        </div>
                        <!-- Post Date -->
                        <div class="detail-label">
                            Posted on <%= p.getPostDate().toLocalDate() %>
                        </div>
                    </div>
                    <!-- Tags -->
                    <div class="column">
                        <div class="columns .is-variable is-multiline">
                        <%for(Tag t : p.getTags()){ %>
                            <div class="column is-narrow label-link tag-label">
                                #<%=t.getName() %>
                            </div>
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
                    	<form action="<%=request.getContextPath()%>/PostPageServlet" method="POST">
	                        <div class="field has-addons">
	                            <div class="control" style="width: 100%;">
	                                <input type="text" class="input comment-input" placeholder="Write a comment!">
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
                  <%for(Comment c : p.getComments()) { %>
                    <div class="block">
                        <!-- Comment Posted By Author -->
                        <div class="detail-label">
                            Posted by <b class="label-link">
                            @<%=c.getUser() %>
                            </b>
                        </div>
                        <!-- Comment Content -->
                        <div>
                            <%=c.getContent() %>
                        </div>
                    </div>
                    <%} %>
                </div>
            </div>
        </div>
    </body>
</html>
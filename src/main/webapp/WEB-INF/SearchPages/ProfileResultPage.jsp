<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="polimi.blog.model.*" %>
<%@page import="java.util.stream.IntStream" %>
<!DOCTYPE html>
<html style="overflow-y: hidden;">
    <head>
        <title>Profile Search</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/styles/bulma.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/styles/profileResultStyle.css" rel="stylesheet">
    </head>

	<% List<User> morePopular = (List<User>) request.getSession().getAttribute("morepopular"); %>
	<% List<Long> counter = (List<Long>) request.getSession().getAttribute("counter"); %>
    <body>
        <div class="columns">
            <div class="column is-10 is-offset-1">
                <form action="<%=request.getContextPath()%>/ProfileResultServlet" method="GET">
                    <button class="link-button label-link" type="submit" >&lt;- Go back</button>
                </form>
                <!-- Profile Content -->
                <div class="columns" style="margin-top: 1rem">
                    <!-- Space for Profiles -->
                    <div class="column is-full profile-space">
                    <%for(int index = 0; index < morePopular.size(); index++){ %>
                        <!-- Profile -->
                        <div class="list-element">
                            <div class="columns">
                                <!-- Profile Name -->
                                <div class="column is-narrow">
                                <form action="<%=request.getContextPath()%>/ProfileServlet" method="POST">
                                   			<h1 class="title is-3" style="color: white">
                                        		<button type="submit" name="username" value="<%=morePopular.get(index).getUsername() %>">@<%=morePopular.get(index).getUsername() %></button>
                               				</h1>
                                     </form>
                                </div>
                                <!-- Subscribers -->
                                <div class="column is-narrow detail-label subscribers-label">
                                    <%=counter.get(index) %> subscribers
                                </div>
                            </div>
                            <div class="columns">
                                <!-- Profile Info Preview -->
                                <div class="column is-full">
                                <%=morePopular.get(index).getInfo() %>
                                </div>
                            </div>
                        </div>
                        <%} %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

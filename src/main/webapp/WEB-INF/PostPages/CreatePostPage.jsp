<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="overflow: hidden">
    <head>
        <title>Create a Post!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="<%=request.getContextPath()%>/styles/bulma.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/styles/createPostStyle.css" rel="stylesheet">
    </head>

    <body style="color:white;">
        <div class="gradient-background"> <!-- Gradient che gira -->
            <div class="columns" style="height: 101vh">
                <div class="column" style="background-color: #16161d90;"></div>
                    <div class="column is-half" style="background-color: #16161d;">
                        <!-- Main Form -->
		   				<p class="help is-danger" id="post-error">
							<% if(request.getAttribute("post-error") != null && request.getAttribute("post-error") != "") { %>
							<%=request.getAttribute("post-error")%>
							<% } %>
						</p>
                        <div class="columns">
                            <div class="column is-10 is-offset-1" style="margin-top: 2rem;">
                                <!-- Go Back -->
                                <div class="link-button-container">
				                   	<form action="<%=request.getContextPath()%>/RemoveAttributeServlet" method="POST">
				               		     <button class="link-button label-link" type="submit" >&lt;- Go back</button>
				                	</form>
                                </div>
                                 <form action="<%=request.getContextPath()%>/CreatePostServlet" method="POST">
                                <!-- Create A Post -->
                                <div class="page-title block">
                                    Create a Post!
                                </div>
                                <!-- Title -->
                                <div class="field block">
                                    <label class="label form-label">Title</label>
                                    <div class="control" style="width: 100%;">
                                        <input type="text" class="input text-input" placeholder="Title here" name="title">
                                    </div>
                                </div>
                                
                          			<p class="help is-danger" id="title-error">
									<% if(request.getAttribute("title-error") != null && request.getAttribute("title-error") != "") { %>
									<%=request.getAttribute("title-error")%>
									<% } %>
								</p>
                                
                                <!-- Content -->
                                <div class="field block">
                                    <label class="label form-label">Post Content</label>
                                    <div class="control" style="width: 100%;">
                                        <textarea class="textarea text-input" rows="15" placeholder="Write a beautiful post!"  name="content"></textarea>
                                    </div>
                                </div>
                                
                         			<p class="help is-danger" id="content-error">
									<% if(request.getAttribute("content-error") != null && request.getAttribute("content-error") != "") { %>
									<%=request.getAttribute("content-error")%>
									<% } %>
								</p>
                                
                                <!-- Tags -->
                                <div class="field block">
                                    <label class="label form-label">Insert Tags</label>
                                    <div class="control" style="width: 100%;">
                                        <input type="text" class="input text-input" placeholder="Eg. Dogs, Cooking, Gardening..."  name="tags">
                                    </div>
                                </div>
                                
                                <!-- Divisor -->
                                <hr style="border-top: 2px solid #bbb;"></hr>
                                <!-- Post Button -->
                                <div class="columns">
                                    <div class="column is-6 is-offset-3">
                                        <button type="submit" class="button is-fullwidth gradient-background post-button"><b>Post!</b></button>
                                    </div>
                                </div>
                              </form>
                            </div>
                        </div>
                    </div>
                <div class="column" style="background-color: #16161d90;"></div>
            </div>
        </div>
    </body>
</html>
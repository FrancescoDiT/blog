<!doctype html>
<html class="gradient-background">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/styles/bulma.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/styles/formStyle.css" rel="stylesheet">
</head>

<body>
	<div class="box form-container">
		<form action="<%=request.getContextPath()%>/LoginServlet" method='POST'>
			<div class="columns is-centered">
				<div class="column" style="text-align: center;">
					<p class="title is-3" style="font-weight: bold;">Welcome Back!</p>
				</div>
			</div>
				<p class="help is-danger" id="general-error">
					<% if(request.getAttribute("general-error") != null && request.getAttribute("general-error") != "") { %>
					<%=request.getAttribute("general-error")%>
					<% } %>
				</p>
			<div class="field block">
				<label class="label">Username/Email</label>
				<div class="control">
					<input class="input" type="text" placeholder="Username/Email"
						id="username" name="username">
				</div>
				<p class="help is-danger" id="username-error">
					<% if(request.getAttribute("username-error") != null && request.getAttribute("username-error") != "") { %>
					<%=request.getAttribute("username-error")%>
					<% } %>
				</p>
			</div>
			<div class="field block">
				<label class="label">Password</label>
				<div class="control">
					<input class="input" type="password" placeholder="Password"
						id="password" name="password">
				</div>
				<p class="help is-danger" id="password-error">
					<% if(request.getAttribute("password-error") != null && request.getAttribute("password-error") != "") { %>
					<%=request.getAttribute("password-error")%>
					<% } %>
				</p>
			</div>
			<div class="columns is-centered" style="margin-top: 0.5rem;">
				<div class="column" style="text-align: center;">
					<input class="button is-primary is-fullwidth gradient-background"
						type="submit" value="Login!" style="font-weight: bold;">
				</div>
			</div>
		</form>
		<div class="link-button-container">
			<a class="link-button" href="SignUp.jsp">Don't have an account
				yet? Sign Up!</a>
		</div>
	</div>
</body>
</html>
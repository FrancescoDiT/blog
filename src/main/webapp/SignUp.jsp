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
		<form action="<%=request.getContextPath()%>/SignUpServlet" method='POST'>
			<div class="columns is-centered">
				<div class="column" style="text-align: center;">
					<p class="title is-3" style="font-weight: bold;">Create an
						account!</p>
				</div>
			</div>

			<p class="help is-danger" id="general-error">
				<% if(request.getAttribute("general-error") != null && request.getAttribute("general-error") != "") { %>
				<%=request.getAttribute("general-error")%>
				<% } %>
			</p>

			<div class="field block">
				<label class="label">Username</label>
				<div class="control">
					<input class="input" type="text" placeholder="Username"
						id="username" name="username">
				</div>
				<p class="help is-danger" id="username-error">
					<% if(request.getAttribute("username-error") != null && request.getAttribute("username-error") != "") { %>
					<%=request.getAttribute("username-error")%>
					<% } %>
				</p>
			</div>
			<div class="field block">
				<label class="label">Email</label>
				<div class="control">
					<input class="input" type="text" placeholder="example@example.com"
						id="email" name="email">
				</div>
				<p class="help is-danger" id="email-error">
					<% if(request.getAttribute("email-error") != null && request.getAttribute("email-error") != "") { %>
					<%=request.getAttribute("email-error")%>
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
			<div class="field block">
				<label class="label">Repeat Password</label>
				<div class="control">
					<input class="input" type="password" placeholder="Repeat Password"
						id="repeatedpassword" name="repeatedpassword">
				</div>
				<p class="help is-danger" id="repeatedpassword-error">
					<% if(request.getAttribute("repeatedpassword-error") != null && request.getAttribute("repeatedpassword-error") != "") { %>
					<%=request.getAttribute("repeatedpassword-error")%>
					<% } %>
				</p>
			</div>
			<div class="columns is-centered" style="margin-top: 0.5rem;">
				<div class="column" style="text-align: center;">
					<input class="button is-primary is-fullwidth gradient-background"
						type="submit" value="Sign up!" style="font-weight: bold;">
				</div>
			</div>
		</form>
		<div class="link-button-container">
			<a class="link-button" href="Login.jsp">Already have an account?
				Log in!</a>
		</div>
	</div>
</body>
</html>
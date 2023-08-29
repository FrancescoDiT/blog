<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="overflow-y: hidden;">
    <head>
        <title>Profile Search</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<%=request.getContextPath()%>/styles/bulma.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/styles/postResultStyle.css" rel="stylesheet">
    </head>

    <body>
        <div class="columns">
            <div class="column is-10 is-offset-1">
                <form action="<%=request.getContextPath()%>/RemoveAttributeServlet" method="POST">
                    <button class="link-button label-link" type="submit" >&lt;- Go back</button>
                </form>
                <!-- Post Content -->
                <div class="columns" style="margin-top: 1rem">
                    <!-- Space for Posts  -->
                    <div class="column is-full post-space">
                        <!-- Post -->
                        <div class="list-element">
                            <!-- Posted By Author on Date -->
                            <div class="detail-label">
                                Posted by <b class="label-link">@Manuel</b> on 11th August 2014
                            </div>
                            <!-- Post Title Preview -->
                            <div class="post-title block">
                                Guys I think i found out why my dog was eating my dildo, is think he found out he's gay
                            </div>
                            <!-- Post Content Preview -->
                            <div>
                                <p>
                                    Hey guys, did you know that in terms of male human and female Pokémon breeding,
                                    Vaporeon is the most compatible Pokémon for humans?
                                    Not only are they in the field egg group, which is mostly comprised of mammals,
                                    Vaporeon are an average of 3”03’ tall and 63.9 pounds, this means
                                    they’re large enough to be able handle human dicks, and with their impressive
                                    Base Stats for HP and access to Acid Armor...
                                </p>
                            </div>
						</div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

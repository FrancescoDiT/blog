<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html style="overflow-y: hidden;">
    <head>
        <title>@"profilename"'s' Home Page</title>
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
                                <button class="button is-rounded is-medium button-input" type="submit">
                                    <span class="icon">
                                        <i class="fas fa-search my-icon"></i>
                                    </span>
                                </button>
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
                                <button class="button is-rounded is-medium button-input" type="submit">
                                    <span class="icon">
                                        <i class="fa-solid fa-at" style="color:white"></i>
                                    </span>
                                </button>
                            </div>
                            <!-- Logout Button -->
                            <div class="column is-narrow">
                                <button class="button is-medium button-input" type="submit" style="color:lightgray">
                                    Logout
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Page Content -->
        <div class="columns">
            <div class="column is-10 is-offset-1">
                <div class="columns">
                    <!-- Space for Posts -->
                    <div class="column is-9 post-space">
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
                    <!-- Space for Followed Users -->
                    <div class="column is-3 followed-space">
                        <!-- Followed Users Label -->
                        <div class="followed-users-label">
                            <b>Followed Users:</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@CucinaDaBenedetta</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@AndreaGatta</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@DomenicoCastiGay</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@ErCringe</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@CiccioDiTullio</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@CazzoDuro4Life</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@SilvioIsBack</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus1</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus2</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus3</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus4</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus5</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus6</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus7</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus8</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus9</b>
                        </div>
                        <!-- Followed User -->
                        <div class="list-element label-link followed-profile">
                            <b>@Amogus10</b>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


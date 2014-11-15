<#macro layout title="Switter">
<html>
<head>
    <script src="/public/jquery/js/jquery.min.js" type="text/javascript"></script>
    <link href="/public/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="/public/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <link href="/public/app/css/main.css" type="text/css" rel="stylesheet"/>

    <title>${title}</title>
</head>
<body>
<header>
    <nav class="navbar navbar-logo navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand-img" href="/">
                    <img alt="Brand" src="/public/app/img/switter-48x48.png">
                </a>
                <a class="navbar-brand" href="/">SWITTER</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/">Blog</a></li>
                <li><a href="/about">About</a></li>
                <li><a href="/credits">Credits</a></li>
            </ul>
        </div>
    </nav>
    <nav class="navbar navbar-menu navbar-fixed-top" role="navigation">
        <div class="container">
            <ul class="nav navbar-nav">
                <li><a href="/post/all">All Posts</a></li>
                <li><a href="#">Favorites</a></li>
            </ul>
            <form class="navbar-form navbar-left" method="GET" action="/post/new">
                <button type="submit" class="btn btn-default">Create</button>
            </form>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" disabled>
                </div>
                <button type="submit" class="btn btn-default disabled">Search</button>
            </form>
        </div>
    </nav>
</header>
<div class="content">
    <div class="container">
        <#nested />
    </div>
</div>
<footer>
</footer>
</body>
</#macro>
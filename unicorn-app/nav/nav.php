<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
?>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="http://localhost:8012/unicorn-app/">WebSiteName</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="nav-item <?php if(!isset($_GET['site'])){echo " active";}  ?>"><a href="http://localhost:8012/unicorn-app/">Home</a></li>
                <li class="nav-item <?php if($_GET['site']=="user"){echo " active";}  ?>"><a href="?site=user">user</a></li>
                <li class="nav-item <?php if($_GET['site']=="settings"){echo " active";}  ?>"><a href="?site=settings">settings</a></li>
                <li class="nav-item <?php if($_GET['site']=="edit-profile"){echo " active";}  ?>"><a href="?site=edit-profile">edit profile</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="<?php if($_GET['site']=="register"){echo " active";}  ?>"><a href="?site=register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li class="<?php if($_GET['site']=="login"){echo " active";}  ?>"><a href="?site=login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
include './includes.php';

$displayposts = new Postview();
$userdata = new CreateUser();
$user = $userdata->returnUser();

$unicorndata = new CreateUnicorns();
$unicorns = $unicorndata->returnUnicorns();

switch ($_SERVER['REQUEST_URI']){
    case "/unicorn-app/": include "./view/main.php";break;
    case "/unicorn-app/index.php": include "./view/main.php";break;
    case "/unicorn-app/?site=user": include "./view/user_profile.php";break;
    case "/unicorn-app/?site=edit-profile": include "./view/edit-profile.php";break;
    case "/unicorn-app/?site=settings": include "./view/settings.php";break;
    default: print "page not found";
}

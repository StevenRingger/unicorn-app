<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
    
?>
<!DOCTYPE html>
<html>
<head>
    <title>Unicorn</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/styles.css">
    <script src="./script/scripts.js"></script>
    <script src="./script/site-load.js"></script>
    <script src="./script/bootstrap.min.js"></script>
</head>
<body>
    <header>
        <?php 
        if (isset($_SESSION)) {
            include_once './nav/nav-logedin.php';
        }else{
            include_once './nav/nav.php';  
        }
        ?>
    </header>
    <div class="container body">
        <div class="content container-fluid">
            <?php include_once './logic/controller.php'; ?>
        </div>
        
        <footer >
            <?php include_once './nav/footer.php'; ?>
        </footer>
    </div>


</body>
</html>
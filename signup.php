<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['name']) && isset($_POST['email']) && isset($_POST['password']) && isset($_POST['phoneNumber']) && isset($_POST['sex']) && isset($_POST['filiere']) ) {
    if ($db->dbConnect()) {
        if ($db->signUp("users", $_POST['name'], $_POST['email'],$_POST['password'], $_POST['phoneNumber'], $_POST['sex'], $_POST['filiere'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required !";
?>

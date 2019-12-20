
<?php
$koneksi = mysql_connect('localhost','root','') or die(mysql_error());
$db = mysql_select_db('ulanganharian') or die (mysql_error());
define('HOST','localhost');
 define('USER','root');
 define('PASS','');
 define('DB','ulanganharian');
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
?>
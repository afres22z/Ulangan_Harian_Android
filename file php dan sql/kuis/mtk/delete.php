<?php

$sql = "TRUNCATE TABLE matematika";
require_once('koneksi.php');
if(mysqli_query($con,$sql)){
 echo 'Berhasil Menghapus';
 }else{
 echo 'Gagal Menghapus';
 }


?>
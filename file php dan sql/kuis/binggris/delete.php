<?php

$sql = "TRUNCATE TABLE bahasainggris";
require_once('koneksi.php');
if(mysqli_query($con,$sql)){
 echo 'Berhasil Menghapus';
 }else{
 echo 'Gagal Menghapus';
 }


?>
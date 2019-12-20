<?php
include("koneksi.php");
$arr = array();
$q = mysql_query("select * from ipa order by rand() limit 10");
 while ($row = mysql_fetch_assoc($q)) {
 $temp = array(
 "soal_id" => $row['id'],
 "soal"=>$row['soal'],
 "a"=>$row['a'],
 "b"=>$row['b'],
 "c" => $row['c'],
 "jawaban" => $row['jawaban'].""
 );

 array_push($arr, $temp);
 }
 $data = json_encode($arr);
 $data = str_replace("\\", "", $data);
 echo "{\"daftar_soal\":" . $data . "}";
?>
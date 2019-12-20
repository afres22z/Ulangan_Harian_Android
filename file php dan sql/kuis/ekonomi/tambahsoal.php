<?php
 
 /*
 
 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/
 
 */
 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$id = $_POST['id'];
		$tanya = $_POST['tanya'];
		$j1= $_POST['jawab1'];
		$j2 = $_POST['jawab2'];
		$j3 = $_POST['jawab3'];
		$benar = $_POST['benar'];
		
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO ekonomi (id,soal,a,b,c,jawaban) VALUES ('$id','$tanya','$j1','$j2','$j3','$benar')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan soal';
		}else{
			echo 'Gagal Menambahkan soal';
		}
		
		mysqli_close($con);
	}
?>
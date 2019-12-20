<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id = $_POST['id'];
		$tanya = $_POST['tanya'];
		$j1= $_POST['jawab1'];
		$j2 = $_POST['jawab2'];
		$j3 = $_POST['jawab3'];
		$benar = $_POST['benar'];
		$sql = "INSERT INTO bahasa (id,soal,a,b,c,jawaban) VALUES ('$id','$tanya','$j1','$j2','$j3','$benar')";
		require_once('koneksi.php');
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan soal';
		}else{
			echo 'Gagal Menambahkan soal';
		}
		
		mysqli_close($con);
	}
?>
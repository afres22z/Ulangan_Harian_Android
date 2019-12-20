<?php 
 
 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable 
		$id = $_POST['ids'];
		$tanya = $_POST['tanya'];
		$j1 = $_POST['jawab1'];
		$j2 = $_POST['jawab2'];
		$j3 = $_POST['jawab3'];
		$b = $_POST['benar'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE matematika SET soal = '$tanya', a = '$j1', b='$j2',c='$j3',jawaban='$b' WHERE id = $id;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data ';
		}else{
			echo 'Gagal Update Data ';
		}
		
		mysqli_close($con);
	}
?>
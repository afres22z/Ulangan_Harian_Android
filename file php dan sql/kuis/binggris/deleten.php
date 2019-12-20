<?php 
 
 
		
		
		//import file koneksi database 
		
		
		//Membuat SQL Query
		$sql = "UPDATE nilai SET Nilaiinggris = '0'";
		require_once('koneksi.php');
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data ';
		}else{
			echo 'Gagal Update Data ';
		}
		
		mysqli_close($con);
	
?>
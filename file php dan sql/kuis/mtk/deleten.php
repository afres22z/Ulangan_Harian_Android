<?php 
 
 
		
		
		//Membuat SQL Query
		$sql = "UPDATE nilai SET Nilaimtk = '0'";
		require_once('koneksi.php');
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data ';
		}else{
			echo 'Gagal Update Data ';
		}
		
		mysqli_close($con);
	
?>
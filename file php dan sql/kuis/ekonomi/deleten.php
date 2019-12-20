<?php 
 		$sql = "UPDATE nilai SET Nilaiekonomi = '0'";
		require_once('koneksi.php');
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data ';
		}else{
			echo 'Gagal Update Data ';
		}
		
		mysqli_close($con);
	
?>



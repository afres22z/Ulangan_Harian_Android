<?php 
 
 	
	
	$id = $_GET['id'];
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan id yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT Nilaiinggris FROM nilai WHERE nis=$id";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(

			
			"ing"=>$row['Nilaiinggris']
			
		));
 
	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>
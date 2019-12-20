<?php 
 
 	
	//Mendapatkan Nilai Dari Variable ID Pegawai yang ingin ditampilkan
	$id = $_GET['id'];
	
	//Importing database
	require_once('koneksi.php');
	
	//Membuat SQL Query dengan pegawai yang ditentukan secara spesifik sesuai ID
	$sql = "SELECT nis,Nama,Nilaibahasa,Nilaiinggris,Nilaimtk,Nilaiipa,Nilaiekonomi,Nilaiips FROM nilai WHERE nis=$id";
	
	//Mendapatkan Hasil 
	$r = mysqli_query($con,$sql);
	
	//Memasukkan Hasil Kedalam Array
	$result = array();
	$row = mysqli_fetch_array($r);
	array_push($result,array(

			"nis"=>$row['nis'],
			"nama"=>$row['Nama'],
			"bahasa"=>$row['Nilaibahasa'],
			"ing"=>$row['Nilaiinggris'],
			"mtk"=>$row['Nilaimtk'],
			"ipa"=>$row['Nilaiipa'],
			"eko"=>$row['Nilaiekonomi'],
			"ips"=>$row['Nilaiips']
		));
 
	//Menampilkan dalam format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>
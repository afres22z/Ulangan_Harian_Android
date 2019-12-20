<?php 
 
 /*
 
 penulis: Muhammad yusuf
 website: http://www.kodingindonesia.com/
 
 */
 
	//Import File Koneksi Database
	require_once('koneksi.php');
	
	//Membuat SQL Query
	$sql = "SELECT * FROM nilai order by Nama";
	
	//Mendapatkan Hasil
	$r = mysqli_query($con,$sql);
	
	//Membuat Array Kosong 
	$result = array();
	
	while($row = mysqli_fetch_array($r)){
		
		//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat 
		array_push($result,array(
			"nis"=>$row['nis'],
			"nama"=>$row['Nama'],
			"mtk"=>$row['Nilaimtk'],
			"ipa"=>$row['Nilaiipa'],
			"ips"=>$row['Nilaiips'],
			"bahasa"=>$row['Nilaibahasa'],
			"ing"=>$row['Nilaiinggris'],
			"eko"=>$row['Nilaiekonomi']
			
		));
	}
	
	//Menampilkan Array dalam Format JSON
	echo json_encode(array('result'=>$result));
	
	mysqli_close($con);
?>
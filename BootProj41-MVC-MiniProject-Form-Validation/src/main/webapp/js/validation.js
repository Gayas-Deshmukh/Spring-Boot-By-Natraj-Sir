
function doValidation(frm) {
	document.getElementById("enameErr").innerHTML='';
	document.getElementById("desErr").innerHTML='';
	document.getElementById("salErr").innerHTML='';

	let ename 	= frm.ename.value;
	let des 	= frm.deg.value;
	let sal 	= frm.sal.value;
	
	frm.vFlag.value='yes';

	let isValid = true;
	
	if (ename=='') {
		document.getElementById("enameErr").innerHTML='Employee name is required (FE)';
		isValid = false;
	}
	else if (!(ename.length >= 5 && ename.length <= 15)){
		document.getElementById("enameErr").innerHTML='Employee name is must be >=5 and <=15 (FE)';
		isValid = false;
	}
	
	if (des=='') {
		document.getElementById("desErr").innerHTML='Employee designation is required (FE)';
		isValid = false;
	}
	else if (!(des.length >= 2 && des.length <= 5)){
		document.getElementById("desErr").innerHTML='Employee designation is must be >=2 and <=5 (FE)';
		isValid = false;
	}
	
	if (sal=='') {
		document.getElementById("salErr").innerHTML='Employee salary is required (FE)';
		isValid = false;
	}
	else if (isNaN(sal)) {
		document.getElementById("salErr").innerHTML='Employee salary must be numeric value (FE)';
		isValid = false;
	}
	else if (!(sal >= 10000 && sal <= 90000)) {
		document.getElementById("salErr").innerHTML='Employee salary must be in between 10,000 and 90,000 (FE)';
		isValid = false;
	}
	
	return isValid;
}
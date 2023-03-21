function searchComptes(){
	let soldeMini = document.getElementById("txtSoldeMini").value;
	let wsUrl = "./api-bank/compte?soldeMini="+soldeMini;
	makeAjaxGetRequest(wsUrl , (jsonResponse) => {
		document.getElementById("spanRes").innerHTML=jsonResponse;
		let jsComptes = JSON.parse(jsonResponse);
		let tbodyElt = document.getElementById("tbody");
		tbodyElt.innerHTML="";
		for(let i in jsComptes){
			let compte = jsComptes[i]; 
			let trElt = tbodyElt.insertRow(-1);
			trElt.insertCell(0).innerHTML=compte.id;
			trElt.insertCell(1).innerHTML=compte.label;
			trElt.insertCell(2).innerHTML=compte.solde;
		}
		
	});
}
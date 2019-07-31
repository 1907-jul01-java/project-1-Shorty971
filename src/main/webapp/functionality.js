window.onload = function myFunction() {
	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", "http://localhost:8080/proj1/employee", true);
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var a = xhttp.responseText;
			var JSONObject = JSON.parse(a);
			var welcomemessage = document.getElementById("welcome");
			welcomemessage.innerHTML= "Welcome " + JSONObject.Username +" this is a succesful login";			
			if(JSONObject.Authority == 1)
			loadReq();
			else if(JSONObject.Authority == 2)
			loadReqwithbutton();
		}
	}
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(encodeURI("methodname=loademp"));
}


function loadReq() {
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", "http://localhost:8080/proj1/reimb", true);

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var a = xhttp.responseText;
			var JSONObject = JSON.parse(a);
			var EmpName = document.getElementById("table");
			var htm = "";
			for (var i = 0; i < JSONObject.length; i++) {
			    var counter = JSONObject[i];
			    
				htm +="<tr><td>"+counter.Username+"</td><td>"+counter.Value+"</td><td>"+counter.Type+"</td><td>"+counter.Stat+"</td></tr>";
			}
			EmpName.innerHTML = '<thead><tr><th>Employee name</th><th>Amount</th><th>Type</th><th>Status</th></tr></thead>'+htm;
			    $('#table').DataTable();
			var reimbcreateform = document.getElementById("form-container");
			reimbcreateform.innerHTML += "<h1>Create Reimburstment</h1><b>Reimburstment Description</b> <input type='text'placeholder='Gas' name='type' required><b>Reimburstment Amount</b> <input type='number' placeholder='250' name='amount' required> <input type='submit' value='Create request'>";
		}
	}
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(encodeURI("methodname=loademp"));
}

function loadReqwithbutton() {
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", "http://localhost:8080/proj1/reimb", true);

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var a = xhttp.responseText;
			var JSONObject = JSON.parse(a);
			var EmpName = document.getElementById("table");
			var htm = "";
			for (var i = 0; i < JSONObject.length; i++) {
			    var counter = JSONObject[i];
			    if (counter.Stat =="Pending")
				htm +="<tr><td>"+counter.Username+"</td><td>"+counter.Value+"</td><td>"+counter.Type+"</td><td>"+counter.Stat+"</td><td>"+"<button type='button' onclick='Accept("+counter.Id+")'>Accept</button><button type='button' onclick='Deny("+counter.Id+")'>Deny</button></td></tr>";
			    else
			    	htm +="<tr><td>"+counter.Username+"</td><td>"+counter.Value+"</td><td>"+counter.Type+"</td><td>"+counter.Stat+"</td><td>Request completed</td></tr>";
			    	
			}
			EmpName.innerHTML = '<thead><tr><th>Employee name</th><th>Amount</th><th>Type</th><th>Status</th><th>Approve/Deny</th></tr></thead>'+htm;
			
			    $('#table').DataTable();
		}
	}
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(encodeURI("methodname=loademp"));
}

function logout(){
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", "http://localhost:8080/proj1/logout", true);

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			window.location = "http://localhost:8080/proj1/index.html";
		}
	}
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(encodeURI("methodname=loademp"));
	}

function makeReq() {
//	let desc = document.getElementById("ty").value;

	//let value = document.getElementById("am").value;
//	var param = "desc="+desc+"&val="+value;
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", "http://localhost:8080/proj1/reimbcreate", true);

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.location.reload(true)
		}
	}
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(encodeURI("methodname=loademp"));
}

function Accept(id){
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", "http://localhost:8080/proj1/reimbupdate?ID="+id, true);

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			window.location = "http://localhost:8080/proj1/loggedinuser.html";
		}
	}
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(encodeURI("methodname=loademp"));
	}

function Deny(id){
	var xhttp = new XMLHttpRequest();

	xhttp.open("POST", "http://localhost:8080/proj1/reimbupdateD?ID="+id, true);

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			window.location = "http://localhost:8080/proj1/loggedinuser.html";
		}
	}
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(encodeURI("methodname=loademp"));
	}

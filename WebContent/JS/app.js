console.log("we can't use  alert.classList.remove(`${alert}`) we just remove the content ");
console.log("we can't query selector `${alert}` ");	

			const alert = document.getElementById("alert");
			displayAlert();
			function displayAlert() {
				  //alert.textContent = "${STATUS}";
				  //alert.classList.add(`alert-${action}`);
				  // remove alert
				  setTimeout(function () {
				    alert.textContent = "";
				  }, 3000);
				}
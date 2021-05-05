var moreth;
var moretd;
var btnmore;
var btnless;
var container;

window.onload = function() {
	moreth = document.getElementsByClassName("custom-table_th-more");
	moretd = document.getElementsByClassName("custom-table_td-more");
	btnmore = document.getElementsByClassName("custom-table_btn-more");
	btnless = document.getElementsByClassName("custom-table_btn-less");
	container = document.getElementById("tableContainer");

	if (document.getElementById("restName")) {
		if (document.getElementById("restName").classList == "") {
			document.getElementById("searchResultTable").style.display = "none";
		}
	}

}


function showMore(e) {
	//display more category headings and data cells
	for (var i = 0; i < moreth.length; i++) {
		moreth[i].style.display = "table-cell";
	}
	for (var i = 0; i < moretd.length; i++) {
		moretd[i].style.display = "table-cell";
	}
	//switch show more and less buttons				
	for (var i = 0; i < btnmore.length; i++) {
		btnmore[i].style.display = "none";
	}
	for (var i = 0; i < btnless.length; i++) {
		btnless[i].style.display = "block";
	}
	//change container size
	container.style.maxWidth = "76%";
	//hide other rows
	var rows = e.parentNode.parentNode.parentNode.childNodes;
	for (var i = 0; i < rows.length; i++) {
		if (rows[i].classList != e.parentNode.parentNode.className && rows[i].tagName == "TR") {
			rows[i].style.display = "none";
		}
	}
}

function showLess(e) {
	//display more category headings and data cells
	for (var i = 0; i < moreth.length; i++) {
		moreth[i].style.display = "none";
	}
	for (var i = 0; i < moretd.length; i++) {
		moretd[i].style.display = "none";
	}
	//switch show more and less buttons				
	for (var i = 0; i < btnmore.length; i++) {
		btnmore[i].style.display = "block";
	}
	for (var i = 0; i < btnless.length; i++) {
		btnless[i].style.display = "none";
	}
	//change container size
	container.style.removeProperty("max-width");
	//show all rows
	var rows = e.parentNode.parentNode.parentNode.childNodes;
	for (var i = 0; i < rows.length; i++) {
		if (rows[i].tagName == "TR") {
			rows[i].style.removeProperty("display");
		}
	}
}

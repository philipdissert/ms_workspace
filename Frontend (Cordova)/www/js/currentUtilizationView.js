for (var x=0; x<176; x++) {
    var board = document.createElement('div');
    board.className = "square";
		board.id = ""+x;
    document.getElementById("container").appendChild(board);
}

poolElements.forEach(function(poolElement) {
	//Put icon of the pool element in the layout
	var divIndex = + poolElement.posX + poolElement.posY*16;
	var iconURL;
	switch (poolElement.type) {
		case "PC":
			iconURL = "https://webadmin.informatik.kit.edu/pool/img/win_free.png";
			break;
		case "Laptop":
			iconURL = "https://www.beep.es/blog/wp-content/uploads/2013/11/portatil_icono.jpg";
			break;
		case "Printer":
			iconURL = "https://webadmin.informatik.kit.edu/pool/img/kyocera.png";
			break;
		default:

	}
	document.getElementById("" + divIndex).style.backgroundImage = "url('" + iconURL +"')";

	//Put id of the pool element in the layout
	divIndex = + poolElement.posX + poolElement.posY*16;
	var span = document.createElement('span');
	span.className ="span";
	span.innerHTML = ""+ poolElement.type + poolElement.id;
	document.getElementById("" + divIndex).appendChild(span);
})

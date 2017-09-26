alert("ENTROU");

$(function() {
	alert("ENTROU");
	$.ajax({
		url:"/reference",
		type:"get",
		dataType:"json",
		//data:$("#username"),
		data:"10",
		contextType:"application/json",
	}).done(function(response) {
		$.each(response, function(i, elem) {
			$("#references").append("<p>" + elem.date + " - " + elem.id + " - " + elem.description + "</p>");
		});
	}).fail(function(response) {
		alert("ERROR");
	});
});

$("#postReference").click(function() {
	$.ajax({
		url:"/reference",
		type:"post",
		dataType:"json",
		data:JSON.stringify(serializeObject($("#referenceForm"))),
		contextType:"application/json",
	}).done(function(response) {
		$("#display").append("<p>Reference posted succesfully.</p>");
	}).fail(function(response) {
		$("#display").append("<p>Error posting Reference.</p>");
	});
});
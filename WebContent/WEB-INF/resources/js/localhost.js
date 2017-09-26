$(function() {
	var contextRoot = window.location.pathname.split('/')[1];
	var requestData = {
		userName:$("#username").val()
	};
	
	$.ajax({
		url:'/' + contextRoot + '/reference',
		type:"get",
		dataType:"json",
		data:requestData,
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
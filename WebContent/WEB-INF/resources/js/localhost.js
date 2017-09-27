$(function() {
	
	// Reference Form.
	$("#leaveReferenceForm").hide();
	
	$("#leaveReference").click(function() {
		$("#leaveReferenceForm").show();
	});

	$("#leaveReferenceConfirmButton").click(function() {
		var contextRoot = window.location.pathname.split('/')[1];
		
		var requestData = {
			description:$("#referenceFormDescription").val()
		};
		
		$.ajax({
			url:'/' + contextRoot + '/reference',
			type:"post",
			dataType:"json",
			//data:JSON.stringify(serializeObject($("#referenceForm"))),
			data:requestData,
			contextType:"application/json",
		}).done(function(response) {
			alert("Reference posted succesfully");
			alert("Reference:" + response.description);
		}).fail(function(response) {
			alert("Error posting Reference");
		});
	});
	
	// Reference DIV
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
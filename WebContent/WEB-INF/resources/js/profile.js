$(function() {
	
	// Hide Post Reference form on view load.
	$("#postReferenceForm").hide();
	
	// Show Post Reference form on button click.
	$("#postReference").click(function() {
		$("#postReferenceForm").show();
		$("header").block({message:'', overlayCSS:{backgroundColor:'#fff'}});
		$("nav").block({message:'', overlayCSS:{backgroundColor:'#fff'}});
		$("#references").block({message:'', overlayCSS:{backgroundColor:'#fff'}});
	});
	
	// Submit Post Reference form on button click.
	$("#referenceFormConfirm").click(function() {
		var contextRoot = window.location.pathname.split('/')[1];
		
		var requestData = {
			type:$("#referenceFormType").val(),
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
	
	// Load Reference list section.
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
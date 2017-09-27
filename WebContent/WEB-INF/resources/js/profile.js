$(function() {
	
	// Hide Post Reference form on view load.
	$("#postReferenceForm").hide();
	
	// Show Post Reference form on button click.
	$("#postReference").click(function() {
		$("header").hide();
		$("nav").hide();
		$("#references").hide();
		$("#postReferenceForm").show();
		
		$("#referenceFormDescription").val("");
	});
	
	// Hide Post Reference form on button click.
	$("#referenceFormCancel").click(function() {
		$("header").show();
		$("nav").show();
		$("#references").show();
		$("#postReferenceForm").hide();
		
		$("#referenceFormDescription").val("");
	});
	
	// Submit Post Reference form on button click.
	$("#referenceFormConfirm").click(function() {
		var contextRoot = window.location.pathname.split('/')[1];
		
		var requestData = {
			type:$("#referenceFormType").val(),
			description:$("#referenceFormDescription").val()
		};
		
		$.ajax({
			url:'/' + contextRoot + '/reference1',
			type:"post",
			dataType:"json",
			data:requestData,
			contextType:"application/json",
		}).done(function(response) {
			$("header").show();
			$("nav").show();
			$("#references").show();
			$("#postReferenceForm").hide();
			
			loadReferenceList();
		}).fail(function(response) {
			alert("Error posting reference.");
			$("#referenceFormError").css("color", "red").html("Error posting reference.");
		});
	});
	
	// Load Reference list section function.
	var loadReferenceList = function() {
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
			$("#referenceList").html("");
			
			$.each(response, function(i, elem) {
				$("#referenceList").append("<p>" + elem.date + " - " + elem.id + " - " + elem.description + "</p>");
			});
		}).fail(function(response) {
			alert("ERROR");
		});
	};
	
	loadReferenceList();
});
$(function() {
	
	// Hide Post Reference form on view load.
	$("#postReferenceForm").hide();
	
	// Show Post Reference form on "postReference" button click.
	$("#postReference").click(function() {
		$("#profile-page").hide();
		$("#postReferenceForm").show();
		
		$("#referenceFormDescription").val("");
		$("#referenceFormError").html("");
	});
	
	// Hide Post Reference form on "referenceFormCancel" button click.
	$("#referenceFormCancel").click(function() {
		$("#profile-page").show();
		$("#postReferenceForm").hide();
		
		$("#referenceFormDescription").val("");
	});
	
	// Submit Post Reference form on "referenceFormConfirm" button click.
	$("#referenceFormConfirm").click(function() {
		var contextRoot = window.location.pathname.split('/')[1];
		
		var requestData = {
			userName:$("#username").val(),
			type:$("#referenceFormType").val(),
			description:$("#referenceFormDescription").val()
		};
		
		$.ajax({
			url:'/' + contextRoot + '/reference',
			type:"post",
			dataType:"json",
			data:requestData,
			contextType:"application/json",
		}).done(function(response) {
			$("#profile-page").show();
			$("#postReferenceForm").hide();
			
			loadReferenceList();
		}).fail(function(response) {
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
				var date = new Date(elem.date);
				var month = date.getMonth() + 1;
				date = date.getDate() + "/" + month + "/" + date.getFullYear();
				$("#referenceList").append("<p>" + date + " - " + elem.userProfile.firstName +
					" " + elem.userProfile.lastName + " - " + elem.description + "</p>");
			});
		}).fail(function(response) {
		});
	};
	
	// Call Load Reference list section function on view load.
	loadReferenceList();
});
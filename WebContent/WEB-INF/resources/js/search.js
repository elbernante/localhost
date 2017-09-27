// Redirect to Profile module on "profile" button click.
function viewProfile(username) {
	$(location).attr('href', '../profile/' + username);
}

$(function() {
	
	// Submit User form on "userFormConfirm" button click.
	$("#userFormConfirm").click(function() {
		loadUserList();
	});
	
	// Load User list section function.
	var loadUserList = function() {
		var contextRoot = window.location.pathname.split('/')[1];
		var requestData = {
			city:$("#userFormCity").val(),
			state:$("#userFormState").val(),
			country:$("#userFormCountry").val()
		};
		
		$.ajax({
			url:'/' + contextRoot + '/search/getList',
			type:"get",
			dataType:"json",
			data:requestData,
			contextType:"application/json",
		}).done(function(response) {
			$("#userList").html("");
			
			$.each(response, function(i, elem) {
				$("#userList").append("<p>" + elem.firstName + " " + elem.lastName + "<br />" +
					elem.location.city + ", " + elem.location.state + ", " + elem.location.country + "</p>")
					.append("<button onclick='viewProfile(\"" + elem.user.username + "\")'>View Profile</button>");
			});
		}).fail(function(response) {
		});
	};
});
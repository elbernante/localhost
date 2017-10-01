$(function() {
	const contextRoot = window.location.pathname.split('/')[1];
	
	const getUpcomingTrips = function () {
		$.ajax({
			url: '/' + contextRoot + '/itinerary/list/upcoming',
			type: "GET",
			dataType: "json",
			success: function (data) {
				if (data.length === 0) {
					$("#trip-list").text("No upcoming trips. Click on 'Plan a Trip' to create one!");
				} else {
					var $list = $("<ul>");
					data.forEach(function (e) {
						var $li = $("<li>");
						$li.text(e.arrivalDate + " - " + e.departureDate + ": " +
								 e.city + ", " + e.state + ", " + e.country);
						$list.append($li);
					});
					$("#trip-list").empty();
					$("#trip-list").append($list);
				}
				console.log(data.length);
			}, 
			error: function (errorObject) {
				$("#trip-list").text("Something went wrong. :( ");
			}
		});
	};
	
	getUpcomingTrips();
	
});
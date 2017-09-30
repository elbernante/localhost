$(function () {
	
	var contextRoot = window.location.pathname.split('/')[1];
	console.log("Document ready!");
	console.log($("#newDistination"));
	
	const fillupForm = function (data) {
		$form = $("#itinerary-form");
		$.each(data, function (k, v) {
			$form.find("[name='" + k + "']").val(v);
		});
	};
	
	const clearForm = function () {
		$("#itinerary-form .errors ").html("");
		$("#itinerary-form").find("input, textarea")
							.filter(":not([type=button])")
							.filter(":not([type=submit])")
							.val("");
	};
	
	const getFormData = function (selector) {
		var values = {}
		$(selector).serializeArray().forEach(function (e) {
			values[e.name] = e.value;
		});
		return JSON.stringify(values);
	};
	
	const ItenaryItem = ({arrivalDate, departureDate, city, state, country, message}) => `
		<div class="list-entry">
			<div class="label">Arrival Date:</div><div class="value">${arrivalDate}</div>
			<div class="label">Departure Date:</div><div class="value">${departureDate}</div>
			<div class="label">Destination:</div><div class="value">${city}, ${state}, ${country}</div>
			<div class="message"><hr /><p>${message}</p></div>
			<div class="buttons">
				<button class="btnEdit">Edit</button><br />
				<button class="btnDelete">Delete</button>
			</div>
		</div>
	`;
	
	const editItinerary = function (itinerary) {
		clearForm();
		fillupForm(itinerary);
		$(".popup-form").show();
	};
	
	const deleteItinerary = function (id) {
		$.ajax({
			url: '/' + contextRoot + '/itinerary/delete/' + id,
			type: "POST",
			contentType:"application/json; charset=utf-8",
			dataType: "json",
			success: function (data) {
				retriveTrips();
			}, 
			error: function (error) {
				alert(error.responseJSON.message);
			}
		});
	};
	
	const populateList = function (data) {
		$(".itinerary-list").empty();
		data.map(ItenaryItem).forEach((e, i) => {
			var $e = $(e);
			
			$e.find(".btnEdit").click(function () {
				editItinerary(data[i]);
			});
			
			$e.find(".btnDelete").click(function () {
				deleteItinerary(data[i].id);
			});
			$(".itinerary-list").append($e);
		});
	};
	
	const retriveTrips = function () {
		$.ajax({
			url: '/' + contextRoot + '/itinerary/list/mytrips',
			type: "GET",
			dataType: "json",
			success: function (data) {
				populateList(data);
			}, 
			error: function (errorObject) {
				alert("Something went wrong! :(");
			}
		});
	};
	
	$("#newDistination").on('click', function () {
		clearForm();
		$(".popup-form").show();
	});
	
	
	$("#itinerary-form .cancel-btn").click(function () {
		$(".popup-form").hide();
	});
	
	$("#itinerary-form").submit(function () {
		event.preventDefault();
		var formData = getFormData("#itinerary-form");
		$(".popup-form").hide();
		$.ajax({
			url: $(this).attr('action'),
			type: "POST",
			data: formData,
			contentType:"application/json; charset=utf-8",
			dataType: "json",
			success: function (data) {
				retriveTrips();
			}, 
			error: function (error) {
				$errors = $("#itinerary-form .errors "); 
				$("#itinerary-form .errors ").html("");
				
				if (error.responseJSON) {
					if (error.responseJSON.message) {
						$errors.append(error.responseJSON.message + "<br />");
					}
					
					$.each(error.responseJSON.errors, function (i, e) {
						$errors.append(e.error + "<br />");
					})
				}
				$(".popup-form").show();
			}
		});
	});
	
	retriveTrips();
	
});
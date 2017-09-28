$(function () {
	
	var contextRoot = window.location.pathname.split('/')[1];
	console.log("Document ready!");
	console.log($("#newDistination"));
	
	var fillupForm = function (data) {
		$form = $("#itinerary-form");
		$.each(data, function (k, v) {
			$form.find("[name='" + k + "']").val(v);
		});
	};
	
	var getFormData = function (selector) {
		var values = {}
		$(selector).serializeArray().forEach(function (e) {
			values[e.name] = e.value;
		});
		return JSON.stringify(values);
	};
	
	$("#newDistination").on('click', function () {
		
		$.get('/' + contextRoot + '/itinerary/new', function (data) {
			fillupForm(data);
		}).fail(function () {
			alert("Something went wrong!");
		});
	});
	
	
	$("#itinerary-form").submit(function () {
		event.preventDefault();
		var formData = getFormData("#itinerary-form");
		
		$.ajax({
			url: $(this).attr('action'),
			type: "POST",
			data: formData,
			contentType:"application/json; charset=utf-8",
			dataType: "json",
			success: function (data) {
				console.log("Success");
				console.log(data);
			}, 
			error: function (errorObject) {
				console.log("ERROR");
				console.log(errorObject);
			}
		});
	});
});
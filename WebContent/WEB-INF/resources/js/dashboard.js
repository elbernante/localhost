$(function() {
	
	// Redirect to Search controller on "search" button click.
	$("#search").click(function() {
		$(location).attr('href', 'search/getForm');
	});
});
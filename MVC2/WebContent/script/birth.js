$(function() {
	var old_year = $("#year").val();
	var old_month = $("#month").val();
	var new_year = null;
	var new_month = null;
	var date = null;
	$("#year").change(function() {
		new_year = $("#year").val();
		getDate();
	});
	$("#month").change(function() {
		new_month = $("#month").val();
		getDate();
	});
	function getDate() {
		if (new_year == null && new_month == null) {
			year_month_change(old_year, old_month);
		} else if (new_year == null && new_month != null) {
			year_month_change(old_year, new_month);
		} else if (new_year != null && new_month == null) {
			year_month_change(new_year, old_month);
		} else {
			year_month_change(new_year, new_month);
		}
	}
	function year_month_change(year, month) {
		date = new Date(year, month, 0).getDate();
		$("#date").html("");
		getDates(date);
	}
	function getDates(date) {
		for (var i = 1; i <= date; i++) {
			if (String(i).toString().length < 2) {
				$("#date").append(
						"<option value='0" + String(i) + "'>0" + String(i)
								+ "</oprion>");
			} else {
				$("#date").append(
						"<option value='" + i + "'>" + i + "</oprion>");
			}
		}
	}
	getDate();
});

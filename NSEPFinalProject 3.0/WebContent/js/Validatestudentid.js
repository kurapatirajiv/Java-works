function validate() {

	if (document.student.studentid.value == "") {
		alert("Please enter student id.");
		return false;
	}

	if (document.student.studentid.value != "") {

		var reg = /^\d+$/;

		if (!reg.test(document.student.studentid.value)) {
			alert("Please enter valid student id.");
			return false;
		}

		if (document.student.studentid.value.length < 5) {
			alert("Student id  can not be less than 5 digits. Please enter valid student id.");
			return false;
		}
		if (document.student.studentid.value.length > 5) {
			alert("Student id can not be greater than 5 digits. Please enter valid student id.");
			return false;
		}

	}
	return true;
}
public class KUStudent {
	private String stud_fname, stud_lname, stud_kuid, stud_dpt; // Declares four variables that are private
	public void set_name(String fname, String lname) { // Method that takes parameters fname and lname and sets the student's firstname and student's lastname equal to fname and lname respectively
		stud_fname = fname;
		stud_lname = lname;
	}
	public void set_kuinfo(String kuid, String dpt) {// Method that takes parameters kuid,dpt and sets the student's KUID and Department equal to kuid and dpt respectively
		stud_kuid = kuid;
		stud_dpt = dpt;
	}
	public String get_fname() {// Method that takes no parameters and returns the student's firstname
		return(stud_fname);
	}
	public String get_lname() {// Method that takes no parameters and returns the student's lastname
		return(stud_lname);
	}
	public String get_id() {// Method that takes no parameters and returns the student's KUID.
		return(stud_kuid);
	}
	public String get_dept() {// Method that takes no parameters and returns the student's Department
		return(stud_dpt);
	}
}

package student;

import java.util.ArrayList;

public class StudentDAO {
	public ArrayList<StudentDTO> getManualList() {
		ArrayList<StudentDTO> dto = new ArrayList<StudentDTO>();	
		for (int i = 0; i < 10; i++) {
			dto.add(new StudentDTO("Hansol", "hhhsss", "ssssss", "hs", "shin", i));
		}//for
		return dto;
	}//getManualList()
}//class
package pack03.go.data;

public class RequestJsonDTO {
	//"상 호":"고려조삼계탕 (충장점)","소재지":"광주 동구 금남로 231(금남로2가)","연락처":"062-224-2525","연번":"1","주메뉴":"삼계탕"
	
	String name, addr, tel, num, menu;
	
	public RequestJsonDTO() {}

	public RequestJsonDTO(String name, String addr, String tel, String num, String menu) {
		super();
		this.name = "상 호";
		this.addr = "소재지";
		this.tel = "연락처";
		this.num = "연번";
		this.menu = "주메뉴";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	
}//class
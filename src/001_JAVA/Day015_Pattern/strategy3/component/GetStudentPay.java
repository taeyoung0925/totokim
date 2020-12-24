package strategy3.component;

public class GetStudentPay implements MoneyImpl {

	@Override
	public void get() {
		System.out.println("교육급여를 받습니다.");
	}

}

import java.util.Scanner;

public class Arr3 {

	public static void main(String[] args) {
		int i = 0;
		float avg, sum = 0; // sum은 원래 int로 선언했지만 실수 / 나누기 정수는 이미 실수이기에 아래 형변환을 넣지 않아도 된다
		// int i, sum = 0; 기본 설정
		// float avg; 기본 설정
		int[] jumsu = new int[5]; // 점수를 5자리의 객체로 만들어 선언
		Scanner sc = new Scanner(System.in); // 새로운 객체 스캐너 선언

		System.out.println("5명의 수학 점수를 입력하시오");
		for (i = 0; i < jumsu.length; i++) { // 내가 입력한 값이 스캐너를 통해서 i값에 저장됨
			// 처음 계산은 0부터 시작되며 ex) 0 < 80 은 True가 되기에 jumsu[i] 각각의 자리 총 5개에 저장이 된다
			jumsu[i] = sc.nextInt(); // 자리값을 계산하는것이라 0이 포함되

//		그니까 자리값이 0,1,2,3,4는 방 번호이며
//			   	for (i = 0; i <jumsu.length; i++) { 로 계산할땐 칸수 1,2,3,4,5 5칸을 비교한다는것
//			
//			
		}

		for (i = 0; i < jumsu.length; i++) { // 여기도 jumsu의 총 글자수만 비교
			sum += jumsu[i]; // 01, 12, 23, 34, 45, (55, 이건 False기에 출력되지 않고 종료)
								// sum에 jumsu의 합이 누적됨
		}
		avg = sum / 5; // 형변환이 일어난다
		// avg = (float) sum / 5; 원래 형변환은 이렇게 써야한다
		// sum = 정수(int)이지만 평균값을 구하기 위해 avg에 실수의 값으로 변환되어 대입하게 된다
		// 여기서 변환을 하지 않는다면 소숫점아래는 버려지게 되어 나타나지 않는다

		System.out.println("총점 = " + sum + ", 평균 = " + avg);
		// avg엔 실수로 변한 sum의 / 5 값이 들어가출력된다.
	}
}

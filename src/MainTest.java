import java.util.Scanner;

public class MainTest {
public static void main(String[] args) {

	테스트 a테스트 = new 테스트();
	Scanner sc = new Scanner(System.in);
//	int a = 0;
//	int i = 0;
//	String b = null;
//	String c = null;
	a테스트.a누리 = new 누리꾼();
	a테스트.Kia = a테스트.실행(15);
	System.out.println(a테스트.Kia); //kia의 값을 재정의 하여 15+1로 30만듬
	a테스트.a누리.출력문(15);//테스트클래스에서 a누리를 정의하여 출력문 호출
							 //누리꾼 클래스에서 응답을 받아 리턴값 실행
	a테스트.이동식();	//테스트의 값을 누리꾼으로 옮김
	System.out.println(a테스트.a누리.출력문(0));
	//호출기에서 다른 호출기 사용 및 반환
	//출력시엔 호출부호 붙여서 불러냄
//	
//	String[] arr = new String[4];
////	a = sc.nextInt();
////	System.out.println(a);
//	switch(i) {
//	case 0:
//		arr[i] = sc.nextLine(); 
//		System.out.println(i+1 +"번째 문장 : " + arr[i]);
//		i++;
//	case 1:
//		arr[i] = sc.nextLine(); 
//		System.out.println(i+1 +"번째 문장 : " + arr[i]);
//		i++;
//	case 2:
//		arr[i] = sc.nextLine(); 
//		System.out.println(i+1 +"번째 문장 : " + arr[i]);
//		i++;
//	case 3:
//		arr[i] = sc.nextLine(); 
//		System.out.println(i+1 +"번째 문장 : " + arr[i]);
//		i++;
//		default:
//			break;
//	
//	}
	
//	i = 0;
//	while(i < arr.length) {
//		System.out.println(arr[i]);
//		i++; }
//		i = 0;
//		for (i < arr.length; i++) {
//			System.out.println(arr[i]);
//	}
		
		// 향상된 for문
		// arr2에 sc 스캐너 문장 입력을 대입해주는 것이다.
		// 배열의 수는 넣어진 스캐너의 수에 의해 결정된다.
//		String[] arr2 = {sc.nextLine(), sc.nextLine()};
//		
//		for (String f : arr2) {
//			System.out.println("2번째 배열 : " + f);
//		}
//	System.out.println("몇번 입력할지 정하시오.");
//		int asb = sc.nextInt();
//		int [] arr3 = new int[asb];
//		System.out.println("입력하신 반복 횟수 : " + asb);
//		for (int test : arr3) {
//			test = sc.nextInt();
//			System.out.println(test + " : 입력하신 숫자");
//			
//		}
//		
		
//	b = sc.nextLine();
//	System.out.println(b);
//	c = sc.nextLine();
//	System.out.println(b + " " + c);
	
	
}
}

class 테스트 {
	int Kia;
	String arr3;
	누리꾼 a누리;
	void 이동식() {
		a누리.출발(Kia, arr3); // 누리꾼으로 정보이동
	}

			
int 실행 (int i) {
	i += 15;
	return i;
	
}
}
class 정보이동 extends 테스트 {
}
class 누리꾼 {
	int base;
	String arr5;
	void 출발(int a, String arr4) {
		base = a; // a의 값 재정의 및 저장
		arr5 = arr4; //arr4의 값 재정의 및 저장
		System.out.println(a + " " + arr4);
		System.out.println(base + " " + arr5);
		
	}
int 출력문 (int i) {
	i += 50;
	int a = i;
	return i; //출력문의 값을 리턴
}
	}

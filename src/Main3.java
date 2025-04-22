import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class Main3 {
public static void main(String[] args) {

	테스트 a테스트 = new 테스트();
	Scanner sc = new Scanner(System.in);
//	int a = 0;
//	int i = 0;
//	String b = null;
//	String c = null;
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
	System.out.println("몇번 입력할지 정하시오.");
		int asb = sc.nextInt();
		int [] arr3 = new int[asb];
		System.out.println("입력하신 반복 횟수 : " + asb);
		for (int test : arr3) {
			test = sc.nextInt();
			System.out.println(test + " : 입력하신 숫자");
			
		}
		
		
//	b = sc.nextLine();
//	System.out.println(b);
//	c = sc.nextLine();
//	System.out.println(b + " " + c);
	
	
}
}

class 테스트 {
	String arr3;
	
			
void 실행 () {
	
}
}
package stringoperation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DummyMain {
	
	public static void main(String[] args) {
		
		findDulpicatesInArray();
		biggestOfArrayUsingRecursion();
		recursiveBinarySearch();
		checkAnagram();
		
		String input1 = "qa w u    "; 
		String expectedOutput = "qa%20w%20u";
		insertCharacters(input1.toCharArray(), 6);
		
		
		String input2 = "Tact Coa";
		//Ex: taco cat,  atco cta
		boolean output = true; 
		System.out.println(isPermutationOfPalindrome(input2.toLowerCase()));
		
	
		String str1 = "pale"; String str2 = "ple";  //--> true 
		String str3 = "pales"; String str4 = "pale"; // --> true
		String str5 = "pale"; String str6 = "bae";  // --> false
		String str7 = "pale"; String str8 = "bale";  // --> true
		
		//insert, delete, replace
		System.out.println(isOneEditAway(str1, str2));
		System.out.println(isOneEditAway(str3, str4));
		System.out.println(isOneEditAway(str5, str6));
		System.out.println(isOneEditAway(str7, str8));
		
		
		 str1 = "aaaabbccccccccaaa";// a4b2c8a3
		 str2 = "abca";// a1b1c1a1 --> abca as this is less than former
		 str3 = "aaaabbccccccccaaah";// a4b2c8a3h1
		System.out.println(commpressedString(str1));
		System.out.println(commpressedString(str2));
		System.out.println(commpressedString(str3));
		
		
		String st1 = "waterbottle";
		String st2 = "terbottlewa";
		System.out.println(isStringRotation(st1, st2));
	
	}

	private static boolean isStringRotation(String st1, String st2) {
		
		// need to check if rotation of st2 makes it st1
		
		if(st1.length()!=st2.length()) {
			return false;
		}
		
		// st2 should be a substring of st1st1
		String st = st1 + st1;
		
		return st.contains(st2);
		
	}

	private static String commpressedString(String str) {
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count++;
			if((i+1 >= str.length()) || str.charAt(i)!= str.charAt(i+1)) {	
				sb.append(str.charAt(i)).append(count);
				count = 0;
			}
		}
		
		return sb.toString().length() < str.length() ?  sb.toString(): str ;
	}

	private static boolean isOneEditAway(String str1, String str2) {
		
		if(str1.length() - str2.length() > 1) {
			return false;
		}
		
		int arr[] = new int[26];
		
		for (int i = 0; i < str1.length(); i++) {
			arr[str1.charAt(i) - 'a']++; 
		}
		
		for (int i = 0; i < str2.length(); i++) {
			arr[str2.charAt(i) - 'a']--;
		}
		
		int sum = Arrays.stream(arr).map(Math::abs).sum();
		if(sum > 2) {
			return false;
		}
		
		return true;
	}

	private static boolean isPermutationOfPalindrome(String input) {
		
		int a[] = new int[26];
		
		IntStream.range(0, input.length())
		.filter(index -> input.charAt(index) != ' ')
		.forEach(index -> {
			  a[input.charAt(index) - 'a']++;
		});
		
//		for (int i = 0; i < input.length(); i++) {
//			
//			if(input.charAt(i) == ' ') {
//				continue;
//			}	
//		}
//		
		// there should only be one odd character, rest all should be even;
		
		
		boolean isOneOddChar = false;
		for (int i = 0; i < input.length(); i++) {
		
			if(input.charAt(i) != ' ' && a[input.charAt(i) - 'a'] % 2 == 1) {
				if(isOneOddChar) {
					return false;
				}
				isOneOddChar = true;
			}
		}
		
		return true;
	}

	private static void insertCharacters(char[] charArray, int actualLength) {
		
		System.out.println(charArray.length);
		// need to insert '%20'
		
		int spaceCount = 0;
		
		for (int i = 0; i < actualLength; i++) {
			if(charArray[i] == ' ') {
				++spaceCount;
			}
		}	
		
		// only two is required even though we are inserting 3 characters because 1 character size is already 
		// taken as the space
		int newLength = actualLength + spaceCount * 2 ; 
	
		for (int i = actualLength - 1, index = newLength-1; i > 0; i--) {
			
			if(charArray[i] == ' ') {
				charArray[index] = '0';
				--index;
				charArray[index] = '2';
				--index;
				charArray[index] = '%';
				--index;
			} else {
				charArray[index] =  charArray[i];
				--index;
			}	
		}
		
		System.out.println(charArray);
		
	}

	private static void checkAnagram() {
		 String str1 = "qawsxedco";
		 String str2 = "cdexswaqy";
		 
		 if(str1.length() != str2.length()) {
			 System.out.println("not anagram");
			 return;
		 }
		 
		 int arr[] = new int[26];
		 
		 IntStream.range(0, str1.length()).forEach(index -> {
			 arr[str1.charAt(index) - 'a']+=1;
			 
		 });
		 
		 IntStream.range(0, str2.length()).forEach(index -> {
			 
			 arr[str2.charAt(index) - 'a']-=1;
			 
			 if(arr[str2.charAt(index) - 'a'] < 0) {
				 System.out.println("not anagram");
			 } 
		 });
		 
		 
	}

	private static void recursiveBinarySearch() {
		int array[] = {27,53,11,345,4431,4643};
		
		boolean isPresent = recursiveBinarySearch(array, 0, array.length-1);
		System.out.println(isPresent);
	}

	private static boolean recursiveBinarySearch(int[] array, int start, int end) {
		int i = 46432;
		
		if(start == end) {
			return array[start] == i ;
		}
		
		int midIndex = (start + end)/2;
		int midNumber = array[midIndex];
		
		if(i == midNumber) {
			return true;
		}
		
		if(i > midNumber) {
			return recursiveBinarySearch(array, midIndex+1, end);
		} else {
			return recursiveBinarySearch(array, start, midIndex-1);
		}
		
	}

	private static void biggestOfArrayUsingRecursion() {
		int array[] = {27,53,11,345,4431,4643};
		int biggest = biggestOfArrayUsingRecursion(array, 0, Integer.MIN_VALUE);
		System.out.println(biggest);
	}

	//static int highest = Integer.MIN_VALUE;
	private static int biggestOfArrayUsingRecursion(int[] array, int i, int highest) {	
		if(i >= array.length) {
			return highest;
		}
		
		if(array[i] > highest) {
			highest = array[i];
		}
		
		return biggestOfArrayUsingRecursion(array, i+1, highest);
	}

	private static void findDulpicatesInArray() {
		int array[] = {2,5,1,5,1,4}; // elements should be less than the size of the array
		
		for (int i = 0; i < array.length; i++) {
			
			if(array[Math.abs(array[i])] > 0) {
				array[Math.abs(array[i])] *= -1;  // fliping if the array is positive  
			} else {
				System.out.println(Math.abs(array[i]) +  " is duplicate");
			}
			
		}
		
	}
}

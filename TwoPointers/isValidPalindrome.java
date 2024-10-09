public class isValidPalindrome {
    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }
    public static boolean isPalindrome(String s) {
        int first = 0;
        int last = s.length()-1;

        while(first<last){
            char currFirst = s.charAt(first);
            char currLast = s.charAt(last);
            if(!Character.isLetterOrDigit(currFirst)){
                first++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            }else{
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)){
                    return false;
                }
                first++;
                last--;
            }

        }
        return  true;

    }
}

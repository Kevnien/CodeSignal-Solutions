// Define an alphabet reflection as follows: a turns into z, b turns into y, c turns into x, ..., n turns into m, m turns into n, ..., z turns into a.

// Define a string reflection as the result of applying the alphabet reflection to each of its characters.

// Reflect the given string.

class ReflectString{
    public static String reflectString(String inputString){
        int length = inputString.length();
        String answer = "";
        for(int i=0; i<length; i++){
            char current = inputString.charAt(i);
            int offset = current - 'a';
            current = (char)('z' - offset);
            answer += current;
        }
        return answer;
    }
}
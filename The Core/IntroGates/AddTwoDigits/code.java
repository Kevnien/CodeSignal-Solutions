class Code{

int addTwoDigits(int n) {
    Integer dereferencedInput = (Integer)n;
    String stringFromInt = dereferencedInput.toString();
    char firstDigitAsChar = stringFromInt.charAt(0);
    String firstDigitAsString = Character.toString(firstDigitAsChar);
    String secondDigitAsString = Character.toString(stringFromInt.charAt(1));
    int firstDigit = Integer.decode(firstDigitAsString);
    int secondDigit = Integer.decode(secondDigitAsString);
    int answer = firstDigit + secondDigit;
    return answer;
}
}

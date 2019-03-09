// An email address such as "John.Smith@example.com" is made up of a local part ("John.Smith"), an "@" symbol, then a domain part ("example.com").

// The domain name part of an email address may only consist of letters, digits, hyphens and dots. The local part, however, also allows a lot of different special characters. Here you can look at several examples of correct and incorrect email addresses.

// Given a valid email address, find its domain part.

class FindEmailDomain{
    public static String findEmailDomain(String address){
        int length = address.length();
        int index = 0;
        String answer = "";
        for(index=length-1; address.charAt(index)!='@'; index--){
            answer = address.charAt(index) + answer;
        }
        return answer;
    }

    public static void main(String[] args){
        String[] inputs = {
            "prettyandsimple@example.com",
            "fully-qualified-domain@codesignal.com",
            "\" \"@space.com",
            "someaddress@yandex.ru",
            "\" \"@xample.org",
            "\"much.more unusual\"@yahoo.com",
            "\"very.unusual.@.unusual.com\"@usual.com",
            "admin@mailserver2.ru",
            "example-indeed@strange-example.com",
            "very.common@gmail.com"
        };
        String[] expectedOutputs = {
            "example.com",
            "codesignal.com",
            "space.com",
            "yandex.ru",
            "xample.org",
            "yahoo.com",
            "usual.com",
            "mailserver2.ru",
            "strange-example.com",
            "gmail.com"
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "findEmailDomain("+
                inputs[i]+"):\n"+
                findEmailDomain(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}
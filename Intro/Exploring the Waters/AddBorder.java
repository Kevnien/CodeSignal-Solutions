// Given a rectangular matrix of characters, add a border of asterisks(*) to it.
class AddBorder{
    String[] addBorder(String[] picture) {
        int lineLength = picture.length+2;
        String[] strings = new String[lineLength];
        String line = createAsteriskLine(picture[0].length());
        strings[0] = line;
        strings[lineLength-1] = line;
        for(int i=0; i<picture.length; i++){
            String current = "";
            current += "*" + picture[i] + "*";
            strings[i+1] = current;
        }
        return strings;
    }
    
    String createAsteriskLine(int amount){
        String line = "";
        for(int i=0; i<amount+2; i++){
            line += '*';
        }
        return line;
    }
}
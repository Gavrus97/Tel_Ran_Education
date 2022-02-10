public interface IConcatenator {
//TODO implement this interface 4 ways
// 1. with String (+)
// 2. with StringBuilder
// 3. with StringBuffer
// 4. using char array whoose length is the total length of all the strings in the String array
// the implementation should create a char array of the total length, then one by one copy every string into this array.
// after that create a result string based on this array.
    /**
     * The method concatenates all the ellements from "strings"
     * @param strings a String array to concatenate
     * @return concatenated string
     */

    String concatenate(String[] strings);
}

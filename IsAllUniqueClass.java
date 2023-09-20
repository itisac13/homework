import java.util.ArrayList;

public class IsAllUniqueClass {

    public static boolean IsAllUnique(String str)
    {
        ArrayList<Character> charactersFound = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++)
        {
            char currentChar = str.charAt(i);

            // if the character is already in the list, then that means there is a duplicate. Thus, it cannot be unique
            if (charactersFound.contains(currentChar))
            {
                return false;
            }
            charactersFound.add(currentChar);
        }
        return true;
    }
}

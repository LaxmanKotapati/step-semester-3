import java.util.Scanner;

class FileExtension {
    static String validateFileExtension(String filename) {
        int pos = filename.lastIndexOf('.');

        if (pos == -1)
            return "Rejected — invalid file type";

        String extension = filename.substring(pos + 1);

        if (extension.equalsIgnoreCase("pdf") ||
                extension.equalsIgnoreCase("docx") ||
                extension.equalsIgnoreCase("zip"))
            return "Accepted";

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String filename = sc.nextLine();

        System.out.println(validateFileExtension(filename));
    }
}
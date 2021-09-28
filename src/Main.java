import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Open original file for reading
            var inputFile = new FileInputStream("image.gif");
            var outputFile = new FileOutputStream("image2.gif");

            // Read the first 19 bytes from the original image
            byte[] data = inputFile.readNBytes(19);
            // and write them to the new image
            outputFile.write(data);

            // Create modified color data. -1 is used to represent 255 as byte is signed
            // -1 binary is 1111 1111, that is 255 decimal
            byte[] modifiedData = {-1, 0, 0};
            // Write modified data to new file
            outputFile.write(modifiedData);

            // Skip the 3 bytes in the original file that we created above
            inputFile.skip(3);
            // Read the rest of the original file
            data = inputFile.readAllBytes();

            // Write the rest of the content from the original file to the copy
            outputFile.write(data);


//            inputFile.skip(13);
//
//            for(int i = 0; i < 256; i++) {
//                byte[] rgb = inputFile.readNBytes(3);
//                String hexStr = String.format("%d. R(%02X)  G(%02X) B(%02X)", i, rgb[0], rgb[1], rgb[2]);
//                System.out.println(hexStr);
//            }
            // Close both files
            inputFile.close();
            outputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

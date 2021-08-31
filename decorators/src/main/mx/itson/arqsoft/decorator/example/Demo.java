package mx.itson.arqsoft.decorator.example;

import mx.itson.arqsoft.decorator.example.decorators.*;

public class Demo {
    public static void main(String[] args) {
        String records = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000\nPatrick Robers,862700";
        encrypt(records);
        compress(records);
        encryptAndCompress(records);

        System.out.println(decrypt());
        System.out.println(uncompress());
        System.out.println(decryptAndUncompress());
    }

    private static void encrypt(String data) {
        DataSourceDecorator encrypted = new EncryptionDecorator(
            new FileDataSource("D:\\out\\OutputDemoEncrypted.txt"));
        encrypted.writeData(data);
    }

    private static String decrypt() {
        DataSourceDecorator decrypted = new EncryptionDecorator(
            new FileDataSource("D:\\out\\OutputDemoEncrypted.txt"));
        return decrypted.readData();
    }

    private static void compress(String data) {
        DataSourceDecorator compressed = new CompressionDecorator(
            new FileDataSource("D:\\out\\OutputDemoCompressed.txt"));
        compressed.writeData(data);
    }

    private static String uncompress() {
        DataSourceDecorator uncompressed = new CompressionDecorator(
            new FileDataSource("D:\\out\\OutputDemoCompressed.txt"));
        return uncompressed.readData();
    }

    private static void encryptAndCompress(String data) {
        DataSourceDecorator encoded = new CompressionDecorator(
            new EncryptionDecorator(
                new FileDataSource("D:\\out\\OutputDemo.txt")));
        encoded.writeData(data);
    }

    private static String decryptAndUncompress() {
        DataSourceDecorator decoded = new CompressionDecorator(
            new EncryptionDecorator(
                new FileDataSource("D:\\out\\OutputDemo.txt")));
        return decoded.readData();
    }
}

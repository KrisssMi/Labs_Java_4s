package Task_1;

public class Main {

    public static void main(String[] args) {
        var connection = new InternetConnection();
        connection.getLocalHost();
        connection.getByName("www.belstu.by");
        byte[] ip = {(byte)127, (byte)0, (byte)0, (byte)7};     // внутренний адрес, в пределах одного ПК
        connection.getByAddress("Unknown", ip);
        System.out.println("");
        connection.getInfo("https://github.com/KrisssMi");
        System.out.println("\nHTML of vk.com:");
        connection.readHTML("https://vk.com/mnvch_krstn");
    }
}

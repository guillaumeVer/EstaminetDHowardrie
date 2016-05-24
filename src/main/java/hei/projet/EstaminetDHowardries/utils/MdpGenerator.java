package hei.projet.EstaminetDHowardries.utils;

public class MdpGenerator {

	public String generate() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890"; // Tu supprimes les lettres dont tu ne veux pas
        String motdepass = "";
        for (int x = 0; x < 8; x++) {
            int i = (int) Math.floor(Math.random() * 32); // Si tu supprimes des lettres tu diminues ce nb
            motdepass += chars.charAt(i);
        }
        System.out.println(motdepass);
        return motdepass;

    }
}

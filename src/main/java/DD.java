import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DD {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
        System.out.println(encoder.encode("pm"));
        System.out.println(encoder.encode("team"));
        System.out.println(encoder.encode("user"));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentValidator {
    ProgramList programList;
    public StudentValidator(ProgramList programList) { this.programList = programList; }
    public List<String> validate(Map<String,String> kv) {
        List<String> errors = new ArrayList<>();
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        if (name.isBlank()) errors.add("Name is required.");

        if (email.isBlank()) errors.add("Email is required.");
        else if (!email.contains("@")) errors.add("Email is invalid.");

        if (phone.isBlank()) errors.add("Phone is required.");
        else if (!phone.matches("\\d{10}")) errors.add("Phone is invalid.");

        if (program.isBlank()) errors.add("Program is required.");
        else if (!programList.contains(program)) errors.add("Program is not supported.");

        if (errors.isEmpty()) return null;
        else System.out.println("ERROR: cannot register");
        
        for (String e : errors) System.out.println("- " + e);

        return errors;
    }
}

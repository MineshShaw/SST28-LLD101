import java.util.*;

public class OnboardingService {
    private final Database db;
    private final StudentParser parser;
    private final StudentValidator validator;
    private final ConsoleReporter reporter;

    public OnboardingService(Database db, StudentParser parser, StudentValidator validator, ConsoleReporter reporter) {
        this.db = db;
        this.parser = parser;
        this.validator = validator;
        this.reporter = reporter;
    }

    public void registerFromRawInput(String raw) {

        reporter.printInput(raw);

        ParsedStudent parsed = parser.parse(raw);

        List<String> errors = validator.validate(parsed);
        if (!errors.isEmpty()) {
            reporter.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(db.count());

        StudentRecord record = new StudentRecord(
                id,
                parsed.getName(),
                parsed.getEmail(),
                parsed.getPhone(),
                parsed.getProgram()
        );

        db.save(record);

        reporter.printSuccess(record, db.count());
        reporter.printDBDump(db);
    }
}

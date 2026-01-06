// Secret detection rules
package scanner;

import java.util.regex.Pattern;

/**
 * SecretRule represents a single rule used to detect
 * sensitive information (secrets) in source code.
 */
public class SecretRule {

    // Name of the secret (e.g., API_KEY, DB_PASSWORD)
    private String name;

    // Regex pattern used to detect the secret
    private Pattern pattern;

    // Severity level of the secret (LOW, MEDIUM, HIGH)
    private String severity;

    /**
     * Constructor to create a secret detection rule.
     *
     * @param name     Name of the secret type
     * @param regex    Regex pattern to detect the secret
     * @param severity Risk level of the secret
     */
    public SecretRule(String name, String regex, String severity) {
        this.name = name;
        this.pattern = Pattern.compile(regex);
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public String getSeverity() {
        return severity;
    }
}

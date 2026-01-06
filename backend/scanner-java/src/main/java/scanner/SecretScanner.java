// Main scanner logic
package scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * SecretScanner is responsible for scanning files
 * and detecting exposed secrets using predefined rules.
 */
public class SecretScanner {

    private List<SecretRule> rules = new ArrayList<>();

    /**
     * Constructor initializes default secret detection rules.
     */
    public SecretScanner() {
        loadDefaultRules();
    }

    /**
     * Define basic secret detection rules.
     */
    private void loadDefaultRules() {

        // Generic API Key rule
        rules.add(new SecretRule(
                "API_KEY",
                "API_KEY\\s*=\\s*[\"']?[A-Za-z0-9]{16,}",
                "HIGH"
        ));

        // Database password rule
        rules.add(new SecretRule(
                "DB_PASSWORD",
                "(?i)(password|db_password)\\s*=\\s*[\"']?.+",
                "HIGH"
        ));

        // Access token rule
        rules.add(new SecretRule(
                "ACCESS_TOKEN",
                "(?i)(access_token|token)\\s*=\\s*[\"']?[A-Za-z0-9\\-\\._]+",
                "MEDIUM"
        ));
    }

    /**
     * Scan a single file for secrets.
     *
     * @param file File to scan
     * @return List of detected secrets
     */
    public List<ScanResult> scanFile(File file) {

        List<ScanResult> results = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                for (SecretRule rule : rules) {
                    Matcher matcher = rule.getPattern().matcher(line);

                    if (matcher.find()) {
                        results.add(new ScanResult(
                                file.getName(),
                                lineNumber,
                                rule.getName(),
                                rule.getSeverity(),
                                maskSecret(matcher.group())
                        ));
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error scanning file: " + file.getName());
        }

        return results;
    }

    /**
     * Mask sensitive values before storing results.
     */
    private String maskSecret(String secret) {
        if (secret.length() <= 4) {
            return "****";
        }
        return secret.substring(0, 4) + "****";
    }
}

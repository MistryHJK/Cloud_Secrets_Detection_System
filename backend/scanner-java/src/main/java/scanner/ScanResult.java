// Scan result model
package scanner;

/**
 * ScanResult represents a single detected secret
 * found during a security scan.
 */
public class ScanResult {

    private String fileName;
    private int lineNumber;
    private String secretType;
    private String severity;
    private String detectedValue;

    /**
     * Constructor to create a scan result.
     *
     * @param fileName      Name of the file where secret was found
     * @param lineNumber    Line number of the secret
     * @param secretType    Type of secret detected
     * @param severity      Risk level of the secret
     * @param detectedValue Detected secret value (masked if needed)
     */
    public ScanResult(String fileName,
                      int lineNumber,
                      String secretType,
                      String severity,
                      String detectedValue) {

        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.secretType = secretType;
        this.severity = severity;
        this.detectedValue = detectedValue;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getSecretType() {
        return secretType;
    }

    public String getSeverity() {
        return severity;
    }

    public String getDetectedValue() {
        return detectedValue;
    }
}

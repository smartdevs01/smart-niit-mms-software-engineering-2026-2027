/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.math.BigDecimal;
import java.math.MathContext;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class simpleCalc extends javax.swing.JFrame {

    private static final int MAX_INPUT_LENGTH = 50;

    public simpleCalc() {

        initComponents();

        // SECURITY 1: Prevent manual modification of results
        result.setEditable(false);

        // SECURITY 2: Clear initial result
        result.setText("");
// SECURITY 3: Restrict input to numbers only
        firstNumber.setDocument(new javax.swing.text.PlainDocument());
        secondNumber.setDocument(new javax.swing.text.PlainDocument());

        ((javax.swing.text.AbstractDocument) firstNumber.getDocument())
                .setDocumentFilter(
                        new NumericInputFilter(MAX_INPUT_LENGTH, "First number"));

        ((javax.swing.text.AbstractDocument) secondNumber.getDocument())
                .setDocumentFilter(
                        new NumericInputFilter(MAX_INPUT_LENGTH, "Second number"));
        // SECURITY 5: Confirm closing through window X button
        addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                clearActionPerformed(null);
            }
        });
    }

    // SECURITY 6: Input length restriction class
// SECURITY: Numeric-only input filter
    private static class NumericInputFilter
            extends javax.swing.text.DocumentFilter {

        private final int maxLength;
        private final String fieldName;

        public NumericInputFilter(int maxLength, String fieldName) {
            this.maxLength = maxLength;
            this.fieldName = fieldName;
        }

        // Handle normal keyboard input
        @Override
        public void insertString(
                FilterBypass fb,
                int offset,
                String text,
                javax.swing.text.AttributeSet attrs)
                throws javax.swing.text.BadLocationException {

            if (text == null || text.isEmpty()) {
                return;
            }

            replace(fb, offset, 0, text, attrs);
        }

        // Handle typing, deletion, replacement and pasted text
        @Override
        public void replace(
                FilterBypass fb,
                int offset,
                int length,
                String text,
                javax.swing.text.AttributeSet attrs)
                throws javax.swing.text.BadLocationException {

            if (text == null) {
                text = "";
            }

            // Get existing text
            String currentText = fb.getDocument().getText(
                    0, fb.getDocument().getLength());

            // Build the proposed new text
            StringBuilder proposedText = new StringBuilder(currentText);

            proposedText.replace(offset, offset + length, text);

            String newText = proposedText.toString();

            // SECURITY 1: Maximum input length
            if (newText.length() > maxLength) {

                showError("Maximum input length is "
                        + maxLength + " characters.");

                return;
            }

            // SECURITY 2: Allow only digits,
            // one decimal point and an optional leading minus sign.
            // Partial values such as "-" and "." are allowed while typing.
            if (!newText.matches("-?\\d*(\\.\\d*)?")) {

                showError("Only numbers are allowed in "
                        + fieldName + ". Letters and special characters "
                        + "are not permitted.");

                return;
            }

            // Accept valid input
            fb.replace(offset, length, text, attrs);
        }

        private void showError(String message) {

            java.awt.Toolkit.getDefaultToolkit().beep();

            JOptionPane.showMessageDialog(
                    null,
                    message,
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

// SECURITY: Allow only approved arithmetic operators
    private void selectOperator(String operator) {

        if (!operator.equals("+")
                && !operator.equals("-")
                && !operator.equals("*")
                && !operator.equals("/")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid arithmetic operator.",
                    "Operator Error",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        middleDisplay.setText(operator);
        result.setText("");
    }

    // SECURITY 7: Validate numerical input
    private BigDecimal validateNumber(String input, String fieldName) {

        // Reject null or empty input
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    fieldName + " cannot be empty.");
        }

        input = input.trim();

        // Enforce maximum input length
        if (input.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(
                    fieldName + " cannot exceed "
                    + MAX_INPUT_LENGTH + " characters.");
        }

        // Allow only valid decimal numbers
        if (!input.matches("[-+]?(\\d+(\\.\\d*)?|\\.\\d+)")) {
            throw new IllegalArgumentException(
                    fieldName + " must contain a valid number.");
        }

        return new BigDecimal(input);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        firstNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        result = new javax.swing.JTextField();
        secondNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        midDisplay = new javax.swing.JPanel();
        plus = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        times = new javax.swing.JButton();
        divi = new javax.swing.JButton();
        equals = new javax.swing.JButton();
        middleDisplay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        clear1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(643, 483));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setMinimumSize(new java.awt.Dimension(643, 483));
        jPanel2.setPreferredSize(new java.awt.Dimension(603, 538));

        firstNumber.setBackground(new java.awt.Color(255, 255, 255));
        firstNumber.setForeground(new java.awt.Color(51, 51, 51));
        firstNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        firstNumber.setPreferredSize(new java.awt.Dimension(64, 30));
        firstNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNumberActionPerformed(evt);
            }
        });
        firstNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstNumberKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Enter Second Number:");

        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("*");

        result.setEditable(false);
        result.setBackground(new java.awt.Color(255, 255, 255));
        result.setForeground(new java.awt.Color(51, 51, 51));
        result.setBorder(null);
        result.setPreferredSize(new java.awt.Dimension(64, 30));
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });

        secondNumber.setBackground(new java.awt.Color(255, 255, 255));
        secondNumber.setForeground(new java.awt.Color(51, 51, 51));
        secondNumber.setBorder(null);
        secondNumber.setPreferredSize(new java.awt.Dimension(64, 30));
        secondNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondNumberActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Result:");

        midDisplay.setBackground(new java.awt.Color(153, 153, 153));
        midDisplay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        plus.setBackground(new java.awt.Color(255, 255, 255));
        plus.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        plus.setForeground(new java.awt.Color(51, 51, 51));
        plus.setText("+");
        plus.setBorder(null);
        plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusActionPerformed(evt);
            }
        });
        midDisplay.add(plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 64, 57));

        minus.setBackground(new java.awt.Color(255, 255, 255));
        minus.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        minus.setForeground(new java.awt.Color(51, 51, 51));
        minus.setText("-");
        minus.setBorder(null);
        minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusActionPerformed(evt);
            }
        });
        midDisplay.add(minus, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 63, 57));

        times.setBackground(new java.awt.Color(255, 255, 255));
        times.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        times.setForeground(new java.awt.Color(51, 51, 51));
        times.setText("x");
        times.setBorder(null);
        times.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timesActionPerformed(evt);
            }
        });
        midDisplay.add(times, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 67, 53));

        divi.setBackground(new java.awt.Color(255, 255, 255));
        divi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        divi.setForeground(new java.awt.Color(51, 51, 51));
        divi.setText("/");
        divi.setBorder(null);
        divi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diviActionPerformed(evt);
            }
        });
        midDisplay.add(divi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 63, 53));

        equals.setBackground(new java.awt.Color(255, 255, 255));
        equals.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        equals.setForeground(new java.awt.Color(51, 51, 51));
        equals.setText("=");
        equals.setBorder(null);
        equals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equalsActionPerformed(evt);
            }
        });
        midDisplay.add(equals, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 170, 54));

        middleDisplay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        midDisplay.add(middleDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 60, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("SIMPLE CALCULATOR");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Enter First Number:");

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("*");

        clear.setBackground(new java.awt.Color(204, 0, 0));
        clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("Exit");
        clear.setBorder(null);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        clear1.setBackground(new java.awt.Color(74, 79, 79));
        clear1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        clear1.setForeground(new java.awt.Color(255, 255, 255));
        clear1.setText("Clear");
        clear1.setBorder(null);
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(midDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(midDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(firstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(secondNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 538));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed

        selectOperator("-");
        // TODO add your handling code here:
    }//GEN-LAST:event_minusActionPerformed

    private void firstNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNumberActionPerformed

    private void plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusActionPerformed

        selectOperator("+");
        // TODO add your handling code here:
    }//GEN-LAST:event_plusActionPerformed

    private void timesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timesActionPerformed
        selectOperator("*");   // TODO add your handling code here:
    }//GEN-LAST:event_timesActionPerformed

    private void diviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diviActionPerformed
        selectOperator("/"); // TODO add your handling code here:
    }//GEN-LAST:event_diviActionPerformed

    private void equalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equalsActionPerformed

        // Clear any previous result
        result.setText("");

        try {

            // SECURITY 1: Check selected operator
            String operation = middleDisplay.getText().trim();

            if (operation.isEmpty()) {
                throw new IllegalArgumentException(
                        "Please select an arithmetic operator.");
            }

            // SECURITY 2: Validate input numbers
            BigDecimal firstNum = validateNumber(
                    firstNumber.getText(), "First number");

            BigDecimal secondNum = validateNumber(
                    secondNumber.getText(), "Second number");

            BigDecimal finalResult;

            // SECURITY 3: Perform safe mathematical operations
            switch (operation) {

                case "+":
                    finalResult = firstNum.add(secondNum);
                    break;

                case "-":
                    finalResult = firstNum.subtract(secondNum);
                    break;

                case "*":
                    finalResult = firstNum.multiply(secondNum);
                    break;

                case "/":

                    // Prevent division by zero
                    if (secondNum.compareTo(BigDecimal.ZERO) == 0) {
                        throw new ArithmeticException(
                                "Cannot divide by zero!");
                    }

                    finalResult = firstNum.divide(
                            secondNum, MathContext.DECIMAL128);
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Invalid arithmetic operator.");
            }

            // SECURITY 4: Format calculation result
            String answer = finalResult
                    .stripTrailingZeros()
                    .toPlainString();

            // Prevent excessively large displayed results
            if (answer.length() > 150) {
                throw new IllegalArgumentException(
                        "The result is too large to display.");
            }

            result.setText(answer);

        } catch (IllegalArgumentException e) {

            // Handle invalid input
            result.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Input Validation Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (ArithmeticException e) {

            // Handle mathematical errors
            result.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Mathematical Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {

            // SECURITY 5: Handle unexpected exceptions
            result.setText("");

            java.util.logging.Logger.getLogger(simpleCalc.class.getName())
                    .log(java.util.logging.Level.SEVERE,
                            "Unexpected calculator error.", e);

            JOptionPane.showMessageDialog(
                    this,
                    "An unexpected error occurred. Please try again.",
                    "Application Error",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_equalsActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            dispose();
        }


    }//GEN-LAST:event_clearActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed

        firstNumber.setText("");
        secondNumber.setText("");
        middleDisplay.setText("");
        result.setText("");

        firstNumber.requestFocusInWindow();


    }//GEN-LAST:event_clear1ActionPerformed

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultActionPerformed
        // No action required.

    }//GEN-LAST:event_resultActionPerformed

    private void secondNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondNumberActionPerformed
        // No action required.
    }//GEN-LAST:event_secondNumberActionPerformed

    private void firstNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNumberKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNumberKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(
                            info.getClassName());
                    break;
                }
            }

        } catch (Exception e) {

            java.util.logging.Logger.getLogger(simpleCalc.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, e);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new simpleCalc().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton divi;
    private javax.swing.JButton equals;
    private javax.swing.JTextField firstNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel midDisplay;
    private javax.swing.JLabel middleDisplay;
    private javax.swing.JButton minus;
    private javax.swing.JButton plus;
    private javax.swing.JTextField result;
    private javax.swing.JTextField secondNumber;
    private javax.swing.JButton times;
    // End of variables declaration//GEN-END:variables
}

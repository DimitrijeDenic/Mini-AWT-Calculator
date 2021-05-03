import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Calculator extends Frame {


    public static void main(String[] args) {

        final int[] num1 = new int[1];
        final int[] num2 = new int[1];
        int[] num3 = new int[num1.length];


        Calculator f = new Calculator();

        LayoutManager layOut = new GridLayout(5, 2);


        Label l = new Label("Enter First Number");
        Label l2 = new Label("Choose Operation");
        Label l3 = new Label("Enter Second Number");
        Label l4 = new Label("Result");
        Label l5 = new Label(" ");

        Image icon = Toolkit.getDefaultToolkit().getImage("calc.png");

        TextField tf = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();

        Choice operation = new Choice();

        Button b = new Button("Calculate");

        f.setLayout(layOut);

        tf.setColumns(30);

        ArrayList<Operation> operations = new ArrayList<>();
        operations.add(new Operation(1, "Select operation"));
        operations.add(new Operation(2, "+"));
        operations.add(new Operation(3, "-"));
        operations.add(new Operation(4, "*"));
        operations.add(new Operation(5, "/"));

        for (Operation o : operations) {
            operation.add(o.sign);
        }


        f.add(l);
        f.add(tf);

        f.add(l2);
        f.add(operation);

        f.add(l3);
        f.add(tf2);

        f.add(l5);
        f.add(b);

        f.add(l4);
        f.add(tf3);

        tf.setBackground(new Color(145, 220, 255));
        tf2.setBackground(new Color(145, 220, 255));
        tf3.setBackground(Color.lightGray);
        b.setBackground(Color.pink);
        l4.setBackground(new Color(227, 93, 93));
        operation.setBackground(Color.pink);

        f.setTitle("Mini AWT Calculator");
        f.setSize(500, 500);
        f.setIconImage(icon);
        f.setVisible(true);


        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        tf.addTextListener(e -> {
            TextField textField = (TextField) e.getSource();
            num1[0] = Integer.parseInt(textField.getText());
            System.out.println("num1 = " + num1[0]);
        });
        tf2.addTextListener(e -> {
            TextField textField = (TextField) e.getSource();
            num2[0] = Integer.parseInt(textField.getText());
            System.out.println("num2 = " + num2[0]);
        });
        operation.addItemListener(e -> {
            Choice op = (Choice) e.getSource();
            Operation operation1 = operations.get(op.getSelectedIndex());

            b.addActionListener(e1 -> {


                if (operation1.id == 1) {
                    tf3.setText("Please select the operation!");
                    System.out.println("ERROR - OPERATION NOT SELECTED!");

                }

                if (operation1.id == 2) {

                    for (int i = 0; i < num1.length; ++i) {
                        num3[i] = num1[i] + num2[i];
                        String result = Arrays.toString(num3);
                        result = result.replace("]", " ");
                        result = result.replace("[", " ");
                        tf3.setText(result);
                    }

                }
                if (operation1.id == 3) {

                    for (int i = 0; i < num1.length; ++i) {
                        num3[i] = num1[i] - num2[i];
                        String result = Arrays.toString(num3);
                        result = result.replace("]", " ");
                        result = result.replace("[", " ");
                        tf3.setText(result);

                    }
                }

                if (operation1.id == 4) {

                    for (int i = 0; i < num1.length; ++i) {
                        num3[i] = num1[i] * num2[i];
                        String result = Arrays.toString(num3);
                        result = result.replace("]", " ");
                        result = result.replace("[", " ");
                        tf3.setText(result);

                    }

                } else if (operation1.id == 5) {


                    if (num2[0] == 0) {
                        tf3.setText("ERROR");
                        System.out.println("ERROR - CAN NOT DIVIDE BY 0!");
                    } else {
                        for (int i = 0; i < num1.length; ++i) {
                            num3[i] = num1[i] / num2[i];
                            String result = Arrays.toString(num3);
                            result = result.replace("]", " ");
                            result = result.replace("[", " ");
                            tf3.setText(result);

                        }
                    }
                }
            });
        });
    }


}

class Operation {
    int id;
    String sign;

    Operation(int id, String sign) {
        this.id = id;
        this.sign = sign;

    }
}





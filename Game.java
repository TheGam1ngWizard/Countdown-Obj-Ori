package countdown;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends JFrame {
    static NumberBag numberBag = new NumberBag();
    static NumberBag numberBag2 = new NumberBag();
    static LetterBag letterBag = new LetterBag();
    static LetterBag letterBag2 = new LetterBag();


    static List<Integer> numberBoard = new ArrayList<Integer>();
    static List<Character> letterBoard = new ArrayList<Character>();

    static Player you = new Player();

    static int interval = 30;
    static int delay = 1000;
    static int period = 30000;
    static Time timer = new Time();
    public static void main(String[] args) {


        letterBag = Weighting.addLetterWeights("vowel");
        letterBag2 = Weighting.addLetterWeights("const");
        numberBag = Weighting.addNumberWeights("big");
        numberBag2 = Weighting.addNumberWeights("small");

        //Simple2 gameGui = new Simple2();
        //gameGui.setVisible(true);

        JFrame f = new JFrame();
        JButton b=new JButton("START GAME");
        b.setBounds(100,100,200, 50);
        NumberBag finalNumberBag = numberBag2;
        NumberBag finalNumberBag1 = numberBag;
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // NumberRoundFrame frame = new NumberRoundFrame();
                f.setVisible(false);
                runNumberRound(you, numberBoard, finalNumberBag, finalNumberBag1, delay, period, interval);
                //frame.setVisible(true);

                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        });

        f.add(b);


        JButton exit=new JButton("EXIT");
        exit.setBounds(100, 160, 200, 50);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        f.add(exit);



        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(500, 200);


       /* System.out.println("Would you like to play a game? (Press 'n' for NUMBER ROUND and 'l' for LETTER ROUND)");
        Scanner in = new Scanner(System.in);
        for (int j = 0; j < 1; j ++) {
        	char userChoice = in.next().charAt(0);
            if (userChoice == 'n') {
            	runNumberRound(you, numberBoard, numberBag2, numberBag, delay, period, interval);
            } else if (userChoice == 'l') {
            	runLetterRound(you, letterBoard, letterBag2, letterBag, delay, period, interval);
            } else {
                System.out.println("That is not a choice. Please choose 'n' or 'l' for NUMBER or LETTER round.");
            j--;
            }
        }
        in.close();
*/


    }


    public static void runNumberRound(Player you, List<Integer> numBoard, NumberBag small, NumberBag big, int delay, int period, int interval) {
        JFrame f = new JFrame();

        JLabel label = new JLabel("Welcome to the Number Round!");
        label.setBounds(100, 50, 350, 30);

        f.add(label);

        JLabel directions = new JLabel("Choose small numbers or big" + "\n" +
                "numbers to get started.");
        directions.setBounds(50, 80, 350, 20);

        f.add(directions);

        Font font = new Font("Comic Sans", Font.BOLD, 20);

        JTextArea num1 = new JTextArea("");
        num1.setBounds(50, 110, 300, 30);
        num1.setBackground(Color.darkGray);
        num1.setForeground(Color.white);
        num1.setFont(font);

        num1.setForeground(Color.white);


        f.add(num1);


        JButton b=new JButton("SMALL NUMBER");
        b.setBounds(25,160,150, 50);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                numBoard.add(small.drawNumber("small"));
                //num1.setText(numBoard.toString());
                String numbers = "";
                for (int i = 0; i < numBoard.size(); i++) {
                    numbers = numbers + " " + numBoard.get(i);
                }

                num1.setText(numbers);
                if (numBoard.size() == 6) {
                    f.setVisible(false);
                    startRoundNum(numBoard, numbers, you);

                }
            }
        });

        f.add(b);

        JButton c=new JButton("BIG NUMBER");
        c.setBounds(200,160,150, 50);
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                numBoard.add(big.drawNumber("big"));
                String numbers = "";
                for (int i = 0; i < numBoard.size(); i++) {
                    numbers = numbers + " " + numBoard.get(i);
                }

                num1.setText(numbers);
                if (numBoard.size() == 6) {
                    f.setVisible(false);
                    startRoundNum(numBoard, numbers, you);

                }
            }
        });

        f.add(c);


        JButton exit=new JButton("EXIT");
        exit.setBounds(90, 220, 200, 50);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        f.add(exit);



        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(500, 200);


/*

        Scanner in = new Scanner(System.in);
        for (int j = 0; j < 6; j ++) {
            System.out.println("Would you like a SMALL number or a BIG number? (Press 's' for SMALL and 'b' for BIG)");
            char userChoice = in.next().charAt(0);
            if (userChoice == 's') {
                numBoard.add(small.drawNumber("small"));
            } else if (userChoice == 'b') {
                numBoard.add(big.drawNumber("big"));
            } else {
                System.out.println("That is not a choice. Please choose 's' or 'b' for SMALL or BIG.");
                j--;
            }

        }



        System.out.println("Your numbers are: " + numBoard.toString());
        int goalNum = ThreadLocalRandom.current().nextInt(101, 999);
        System.out.println("Your goal number is : " + goalNum);
        System.out.println("You have 30 seconds to use your chosen numbers to reach the goal number. The time starts...NOW!");
        //Time timer = new Time();
        //timer.runTimer(30);
            List<Integer> pastResults = new ArrayList<Integer>();
            Integer resultOfOp = 0;
            while (resultOfOp != goalNum) {
                try {
                    Integer num = in.nextInt();
                    String operation = in.next();
                    Integer num2 = in.nextInt();


                if (you.isValid(numBoard, num, pastResults) == false || you.isValid(numBoard, num2, pastResults) == false) {
                    System.out.println("That is not a valid number, please try again.");
                } else {
                    switch (operation) {
                        case "+":
                            resultOfOp = num + num2;
                            pastResults.add(resultOfOp);
                            System.out.println("Answer: " + resultOfOp);
                            break;

                        case "-":
                            resultOfOp = num - num2;
                            pastResults.add(resultOfOp);
                            System.out.println("Answer: " + resultOfOp);
                            break;
                        case "/":
                            resultOfOp = num / num2;
                            pastResults.add(resultOfOp);
                            System.out.println("Answer: " + resultOfOp);
                            break;
                        case "*":
                            resultOfOp = num * num2;
                            pastResults.add(resultOfOp);
                            System.out.println("Answer: " + resultOfOp);
                            break;
                    }

                }
                }
                catch(Exception e){
                    System.out.println("Error! Input an integer, operation (+ - * /), then integer");
                    in.reset();
                    in.next();
                }
            }
        in.close();
*/
    }

    public static void startRoundNum(List<Integer> numboard1, String numbers, Player you) {
        List<Integer> resetNums = numboard1;
        List<Integer> numBoard = numboard1;
        JFrame g = new JFrame();
        JLabel label = new JLabel("Welcome to the Number Round!");
        label.setBounds(100, 50, 350, 30);

        g.add(label);
        int goalNum = ThreadLocalRandom.current().nextInt(101, 999);
        JLabel directions = new JLabel("You have 30 seconds to try to reach the goal number of " + goalNum);
        directions.setBounds(25, 80, 350, 20);

        g.add(directions);

        //Time timer = new Time();
        //int timeLeft = timer.runTimer(30);



        JLabel timerLabel = new JLabel("30");
        //while (timer.runTimer(30) != 0) {
        //    timerLabel.setText(Integer.toString(timeLeft));
        // }

        timerLabel.setBounds(300, 10, 20, 20);

        g.add(timerLabel);

        Font font = new Font("Comic Sans", Font.BOLD, 20);

        JTextArea num1 = new JTextArea("");
        num1.setBounds(50, 110, 300, 30);
        num1.setBackground(Color.darkGray);
        num1.setForeground(Color.white);
        num1.setFont(font);





        num1.setText(numbers);

        JTextArea numCurrent = new JTextArea("");
        numCurrent.setBounds(50, 150, 300, 30);
        Color color = g.getBackground();
        numCurrent.setBackground(color);
        numCurrent.setForeground(Color.BLUE);
        numCurrent.setFont(font);


        num1.setForeground(Color.white);

        //final List<Integer>[] numberBoardWorking = new List[]{new ArrayList<Integer>()};
        //numberBoardWorking[0].addAll(numBoard);
        int[] currentNums = new int[2];
        final String[] operations = {""};
        final int[] firstNum = {0};
        final int[] secondNum = {0};

        g.add(num1);
        g.add(numCurrent);

        JTextArea error = new JTextArea("");
        error.setBounds(10, 315, 400, 25);
        error.setForeground(Color.red);
        error.setBackground(color);


        JButton add=new JButton("+");
        add.setBounds(25,200,50, 50);
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                error.setText("");
                if (operations[0] == null) {
                    error.setText("Invalid. Please choose a number first.");
                }
                else {
                    operations[0] = "+";
                    String opText = numCurrent.getText() + " + ";
                    numCurrent.setText(opText);

                }

            }
        });

        g.add(add);

        JButton minus=new JButton("-");
        minus.setBounds(125,200,50, 50);
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                error.setText("");
                if (operations[0] == null) {
                    error.setText("Invalid. Please choose a number first.");
                }
                else {
                    operations[0] = "-";
                    String opText = numCurrent.getText() + " - ";
                    numCurrent.setText(opText);

                }

            }
        });

        JButton multiply=new JButton("x");
        multiply.setBounds(225,200,50, 50);
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                error.setText("");
                if (operations[0] == null) {
                    error.setText("Invalid. Please choose a number first.");
                }
                else {
                    operations[0] = "x";
                    String opText = numCurrent.getText() + " x ";
                    numCurrent.setText(opText);

                }

            }
        });

        JButton divide=new JButton("/");
        divide.setBounds(325,200,50, 50);
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                error.setText("");
                if (operations[0] == null) {
                    error.setText("Invalid. Please choose a number first.");
                }
                else {
                    operations[0] = "/";
                    String opText = numCurrent.getText() + " / ";
                    numCurrent.setText(opText);

                }

            }
        });




        g.add(error);
        g.add(minus);
        g.add(multiply);
        g.add(divide);

        JButton number1=new JButton(String.valueOf(numBoard.get(0)));
        number1.setBounds(30,260,50, 50);
        number1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(number1.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + number1.getText();
                    numCurrent.setText(newText);
                    number1.setVisible(false);

                }
                else {
                    int thenum = Integer.parseInt(number1.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + number1.getText();
                    numCurrent.setText(newText);
                    number1.setVisible(false);
                }

            }
        });
        JButton number2=new JButton(String.valueOf(numBoard.get(1)));
        number2.setBounds(85,260,50, 50);
        number2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(number2.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + number2.getText();
                    numCurrent.setText(newText);
                    number2.setVisible(false);
                }
                else {
                    int thenum = Integer.parseInt(number2.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + number2.getText();
                    numCurrent.setText(newText);
                    number2.setVisible(false);

                }

            }
        });
        JButton number3=new JButton(String.valueOf(numBoard.get(2)));
        number3.setBounds(140,260,50, 50);
        number3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(number3.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + number3.getText();
                    numCurrent.setText(newText);
                    number3.setVisible(false);
                }
                else {
                    int thenum = Integer.parseInt(number3.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + number3.getText();
                    numCurrent.setText(newText);
                    number3.setVisible(false);

                }

            }
        });
        JButton number4=new JButton(String.valueOf(numBoard.get(3)));
        number4.setBounds(195,260,50, 50);
        number4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(number4.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + number4.getText();
                    numCurrent.setText(newText);
                    number4.setVisible(false);
                }
                else {

                    int thenum = Integer.parseInt(number4.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + number4.getText();
                    numCurrent.setText(newText);

                    number4.setVisible(false);

                }

            }
        });
        JButton number5=new JButton(String.valueOf(numBoard.get(4)));
        number5.setBounds(250,260,50, 50);
        number5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(number5.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + number5.getText();
                    numCurrent.setText(newText);
                    number5.setVisible(false);
                }
                else {
                    int thenum = Integer.parseInt(number5.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + number5.getText();
                    numCurrent.setText(newText);
                    number5.setVisible(false);

                }

            }
        });
        String num6 = numBoard.get(5).toString();
        JButton number6=new JButton(num6);
        number6.setBounds(305,260,50, 50);
        number6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(number6.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + number6.getText();
                    numCurrent.setText(newText);
                    number6.setVisible(false);
                }
                else {
                    int thenum = Integer.parseInt(number6.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + number6.getText();
                    numCurrent.setText(newText);
                    number6.setVisible(false);

                }


            }
        });

        JButton answer1 = new JButton("");
        answer1.setBounds(5, 350, 70, 40);
        answer1.setVisible(true);
        answer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(answer1.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + answer1.getText();
                    numCurrent.setText(newText);
                    answer1.setVisible(false);
                }
                else {
                    int thenum = Integer.parseInt(answer1.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + answer1.getText();
                    numCurrent.setText(newText);
                    answer1.setVisible(false);

                }


            }
        });

        JButton answer2 = new JButton("");
        answer2.setBounds(80, 350, 70, 40);
        answer2.setVisible(true);
        answer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(answer2.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + answer2.getText();
                    numCurrent.setText(newText);
                    answer2.setVisible(false);
                }
                else {
                    int thenum = Integer.parseInt(answer2.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + answer2.getText();
                    numCurrent.setText(newText);
                    answer2.setVisible(false);

                }


            }
        });


        JButton answer3 = new JButton("");
        answer3.setBounds(155, 350, 70, 40);
        answer3.setVisible(true);
        answer3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(answer3.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + answer3.getText();
                    numCurrent.setText(newText);
                    answer3.setVisible(false);
                }
                else {
                    int thenum = Integer.parseInt(answer3.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + answer3.getText();
                    numCurrent.setText(newText);
                    answer3.setVisible(false);

                }


            }
        });


        JButton answer4 = new JButton("");
        answer4.setBounds(230, 350, 70, 40);
        answer4.setVisible(true);
        answer4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(answer4.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + answer4.getText();
                    numCurrent.setText(newText);
                    answer4.setVisible(false);
                }
                else {
                    int thenum = Integer.parseInt(answer4.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + answer4.getText();
                    numCurrent.setText(newText);
                    answer4.setVisible(false);

                }


            }
        });


        JButton answer5 = new JButton("");
        answer5.setBounds(305, 350, 70, 40);
        answer5.setVisible(true);
        answer5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //String currentNums = numCurrent.getText();
                error.setText("");
                if (operations[0] == "" && firstNum[0] != 0) {
                    error.setText("Invalid. Please choose an operation.");
                }
                else if (secondNum[0] != 0) {
                    error.setText("Too many numbers. Please choose CALCULATE or RESET.");
                }
                else if (firstNum[0] == 0) {
                    numCurrent.setText("");
                    int thenum = Integer.parseInt(answer5.getText());
                    firstNum[0] = thenum;
                    String newText = numCurrent.getText() + answer5.getText();
                    numCurrent.setText(newText);
                    answer5.setVisible(false);
                }
                else {
                    int thenum = Integer.parseInt(answer5.getText());
                    secondNum[0] = thenum;
                    String newText = numCurrent.getText() + answer5.getText();
                    numCurrent.setText(newText);
                    answer5.setVisible(false);

                }


            }
        });


        g.add(answer1);
        g.add(answer2);
        g.add(answer3);
        g.add(answer4);
        g.add(answer5);



        JButton reset=new JButton("Reset");
        reset.setBounds(300, 410, 70, 40);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                number1.setVisible(true);
                number2.setVisible(true);
                number3.setVisible(true);
                number4.setVisible(true);
                number5.setVisible(true);
                number6.setVisible(true);
                numCurrent.setText("");
                answer1.setText("");
                answer1.setVisible(true);
                answer2.setVisible(true);
                answer3.setVisible(true);
                answer4.setVisible(true);
                answer5.setVisible(true);
                answer2.setText("");
                answer3.setText("");
                answer4.setText("");
                answer5.setText("");
                secondNum[0] = 0;
                firstNum[0] = 0;
                operations[0] = "";
            }
        });

        g.add(reset);


        JButton calc=new JButton("CALCULATE");
        calc.setBounds(90, 410, 200, 40);
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                numCurrent.setText("");
                Integer resultOfOp = 0;
                switch (operations[0]) {
                    case "+":
                        resultOfOp = firstNum[0] + secondNum[0];

                        numCurrent.setText("Answer: " + resultOfOp);
                        if (answer1.getText() == "") {
                            String result = resultOfOp.toString();
                            answer1.setText(result);
                            answer1.setVisible(true);
                        }
                        else if (answer2.getText() == "") {
                            answer2.setText(resultOfOp.toString());
                            answer2.setVisible(true);
                        }
                        else if (answer3.getText() == "") {
                            answer3.setText(resultOfOp.toString());
                            answer3.setVisible(true);
                        }
                        else if (answer4.getText() == "") {
                            answer4.setText(resultOfOp.toString());
                            answer4.setVisible(true);
                        }
                        else if (answer5.getText() == "") {
                            answer5.setText(resultOfOp.toString());
                            answer5.setVisible(true);
                        }
                        break;

                    case "-":
                        resultOfOp = firstNum[0] - secondNum[0];

                        numCurrent.setText("Answer: " + resultOfOp);
                        if (answer1.getText() == "") {
                            answer1.setText(resultOfOp.toString());
                            answer1.setVisible(true);
                        }
                        else if (answer2.getText() == "") {
                            answer2.setText(resultOfOp.toString());
                            answer2.setVisible(true);
                        }
                        else if (answer3.getText() == "") {
                            answer3.setText(resultOfOp.toString());
                            answer3.setVisible(true);
                        }
                        else if (answer4.getText() == "") {
                            answer4.setText(resultOfOp.toString());
                            answer4.setVisible(true);
                        }
                        else if (answer5.getText() == "") {
                            answer5.setText(resultOfOp.toString());
                            answer5.setVisible(true);
                        }
                        break;
                    case "/":
                        resultOfOp = firstNum[0] / secondNum[0];

                        numCurrent.setText("Answer: " + resultOfOp);
                        if (answer1.getText() == "") {
                            answer1.setText(resultOfOp.toString());
                            answer1.setVisible(true);
                        }
                        else if (answer2.getText() == "") {
                            answer2.setText(resultOfOp.toString());
                            answer2.setVisible(true);
                        }
                        else if (answer3.getText() == "") {
                            answer3.setText(resultOfOp.toString());
                            answer3.setVisible(true);
                        }
                        else if (answer4.getText() == "") {
                            answer4.setText(resultOfOp.toString());
                            answer4.setVisible(true);
                        }
                        else if (answer5.getText() == "") {
                            answer5.setText(resultOfOp.toString());
                            answer5.setVisible(true);
                        }
                        break;
                    case "x":
                        resultOfOp = firstNum[0] * secondNum[0];

                        numCurrent.setText("Answer: " + resultOfOp);
                        if (answer1.getText() == "") {
                            answer1.setText(resultOfOp.toString());
                            answer1.setVisible(true);
                        }
                        else if (answer2.getText() == "") {
                            answer2.setText(resultOfOp.toString());
                            answer2.setVisible(true);
                        }
                        else if (answer3.getText() == "") {
                            answer3.setText(resultOfOp.toString());
                            answer3.setVisible(true);
                        }
                        else if (answer4.getText() == "") {
                            answer4.setText(resultOfOp.toString());
                            answer4.setVisible(true);
                        }
                        else if (answer5.getText() == "") {

                            answer5.setText(resultOfOp.toString());
                            answer5.setVisible(true);
                        }
                        break;
                }
                operations[0] = "";
                firstNum[0] = 0;
                secondNum[0] = 0;
            }
        });


        JButton finalAnswer=new JButton("FINAL ANSWER");
        finalAnswer.setBounds(90, 460, 200, 40);
        finalAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFrame sure = new JFrame();



                JLabel label = new JLabel("Submit Final Answer?");
                label.setBounds(150, 10, 200, 50);
                JButton yes = new JButton("YES");
                yes.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        int timeNow = timer.returnTime();
                        sure.setVisible(false);
                        g.setVisible(false);
                        String newString = numCurrent.getText().substring(numCurrent.getText().lastIndexOf(" ") + 1);
                        int yourAnswer = 0;
                        if(newString.equals("")){
                            yourAnswer = 0;
                        }
                        else {
                            //newString = numCurrent.getText().substring(numCurrent.getText().lastIndexOf(" ") + 1);
                            yourAnswer = Integer.parseInt(newString);
                        }
                        int roundScore = you.scoreNumRound(yourAnswer, goalNum);
                        int currentScore = you.getCurrentScore();
                        scoreRoundFrame(you, roundScore, currentScore, 0, newString, timeNow);


                    }
                });
                JButton no = new JButton("Try Again");
                no.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        sure.setVisible(false);

                    }
                });
                yes.setBounds(150, 70, 100, 50);
                no.setBounds(150, 130, 100, 50);
                sure.add(label);
                sure.add(yes);
                sure.add(no);
                sure.setSize(400,300);
                sure.setLayout(null);
                sure.setVisible(true);
                sure.setLocation(500, 200);
            }
        });



        JButton exit=new JButton("EXIT");
        exit.setBounds(90, 510, 200, 40);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        g.add(number1);
        g.add(number2);
        g.add(number3);
        g.add(number4);
        g.add(number5);
        g.add(number6);
        g.add(calc);
        g.add(finalAnswer);
        g.add(exit);



        g.setSize(400,600);
        g.setLayout(null);
        g.setVisible(true);
        g.setLocation(500, 200);


        timer.runTimer(30);

    }


    public static void runLetterRound(Player you, List<Character> letterBoard, LetterBag cons, LetterBag vowel, int delay, int period, int interval) {
       /* Scanner in = new Scanner(System.in);
        for (int j = 0; j < 9; j ++) {
            System.out.println("Would you like a Constant or a Vowel? (Press 'c' for CONSTANANT and 'v' for VOWEL)");
            char userChoice = in.next().charAt(0);
            if (userChoice == 'c') {
                letterBoard.add(cons.drawLetter("const"));
            } else if (userChoice == 'v') {
                letterBoard.add(vowel.drawLetter("vowel"));
            } else {
                System.out.println("That is not a choice. Please choose 'c' or 'v' for CONSTANANT or VOWEL.");
                j--;
            }

        }


        System.out.println("Your letters are: " + letterBoard.toString());
        System.out.println("You have 30 seconds to use your chosen letters to make the longest word. The time starts...NOW!");

        in.close();
*/




        JFrame f = new JFrame();

        JLabel label = new JLabel("Welcome to the Letter Round!");
        label.setBounds(100, 50, 350, 30);

        f.add(label);

        JLabel directions = new JLabel("Choose a consonant or vowel to get started.");
        directions.setBounds(50, 80, 350, 20);

        f.add(directions);

        Font font = new Font("Comic Sans", Font.BOLD, 20);

        JTextArea num1 = new JTextArea("");
        num1.setBounds(50, 110, 300, 30);
        num1.setBackground(Color.darkGray);
        num1.setForeground(Color.white);
        num1.setFont(font);

        num1.setForeground(Color.white);


        f.add(num1);


        JButton b=new JButton("Consonant");
        b.setBounds(25,160,150, 50);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                letterBoard.add(cons.drawLetter("const"));
                //num1.setText(numBoard.toString());
                String letters = "";
                for (int i = 0; i < letterBoard.size(); i++) {
                    letters = letters + " " + letterBoard.get(i);
                }

                num1.setText(letters);
                if (letterBoard.size() == 9) {
                    f.setVisible(false);
                    startRoundWord(letterBoard, letters, you);

                }
            }
        });

        f.add(b);

        JButton c=new JButton("Vowel");
        c.setBounds(200,160,150, 50);
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                letterBoard.add(vowel.drawLetter("vowel"));
                String letters = "";
                for (int i = 0; i < letterBoard.size(); i++) {
                    letters = letters + " " + letterBoard.get(i);
                }

                num1.setText(letters);
                if (letterBoard.size() == 9) {
                    f.setVisible(false);
                    startRoundWord(letterBoard, letters, you);

                }
            }
        });

        f.add(c);




        JButton exit=new JButton("EXIT");
        exit.setBounds(90, 220, 200, 50);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        f.add(exit);



        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocation(500, 200);


    }


    public static void startRoundWord(List<Character> letterboard1, String letters, Player you) {
        List<Character> resetLetters = letterboard1;
        List<Character> letterBoard = letterboard1;
        JFrame g = new JFrame();
        JLabel label = new JLabel("Welcome to the Letter Round!");
        label.setBounds(100, 50, 350, 30);

        g.add(label);
        int goalNum = ThreadLocalRandom.current().nextInt(101, 999);
        JLabel directions = new JLabel("You have 30 seconds to try to find the longest word from the letters.");
        directions.setBounds(25, 80, 350, 20);

        g.add(directions);

        //Time timer = new Time();
        //int timeLeft = timer.runTimer(30);


        JLabel timerLabel = new JLabel("30");
        //while (timer.runTimer(30) != 0) {
        //    timerLabel.setText(Integer.toString(timeLeft));
        // }

        timerLabel.setBounds(300, 10, 20, 20);

        g.add(timerLabel);

        Font font = new Font("Comic Sans", Font.BOLD, 20);

        JTextArea let1 = new JTextArea("");
        let1.setBounds(50, 110, 300, 30);
        let1.setBackground(Color.darkGray);
        let1.setForeground(Color.white);
        let1.setFont(font);


        let1.setText(letters);

        JLabel enterHere = new JLabel("Type: ");
        enterHere.setBounds(2, 150, 60, 30);
        enterHere.setFont(font);

        g.add(enterHere);

        JTextArea letCurrent = new JTextArea("");
        letCurrent.setBounds(80, 150, 170, 30);
        Color color = g.getBackground();
        letCurrent.setBackground(Color.WHITE);
        letCurrent.setForeground(Color.BLUE);
        letCurrent.setFont(font);

        JButton submit = new JButton("Add");
        submit.setBounds(325, 150, 60, 30);


        JTextArea error = new JTextArea("");
        error.setBounds(10, 415, 400, 25);
        error.setForeground(Color.red);
        error.setBackground(color);

        //List<JTextArea> answerSlot = new ArrayList<>();


        Font it = new Font("Comic Sans", Font.ITALIC, 20);
        JTextArea slot1 = new JTextArea("-");
        //answerSlot.add(slot1);
        slot1.setBounds(10, 205, 200, 30);
        slot1.setFont(it);
        slot1.setForeground(Color.GRAY);
        slot1.setBackground(Color.lightGray);
        slot1.setVisible(true);
        //slot1.setText("-");

        JTextArea slot2 = new JTextArea();
       // answerSlot.add(slot2);
        slot2.setBounds(10, 250, 200, 30);
        slot2.setFont(it);
        slot2.setForeground(Color.GRAY);
        slot2.setBackground(Color.lightGray);
        slot2.setVisible(true);
        slot2.setText("-");
        JTextArea slot3 = new JTextArea();
        //answerSlot.add(slot3);
        slot3.setBounds(10, 295, 200, 30);
        slot3.setFont(it);
        slot3.setForeground(Color.GRAY);
        slot3.setBackground(Color.lightGray);
        slot3.setVisible(true);
        slot3.setText("-");
        JTextArea slot4 = new JTextArea();
        //answerSlot.add(slot4);
        slot4.setBounds(10, 340, 200, 30);
        slot4.setFont(it);
        slot4.setForeground(Color.GRAY);
        slot4.setBackground(Color.lightGray);
        slot4.setVisible(true);
        slot4.setText("-");
        JTextArea slot5 = new JTextArea();
        //answerSlot.add(slot5);
        slot5.setBounds(10, 385, 200, 30);
        slot5.setFont(it);
        slot5.setForeground(Color.GRAY);
        slot5.setBackground(Color.lightGray);
        slot5.setVisible(true);
        slot5.setText("-");



        g.add(slot1);
        g.add(slot2);
        g.add(slot3);
        g.add(slot4);
        g.add(slot5);







        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //you.addWord();
                String userWord = letCurrent.getText();
                userWord = userWord.toLowerCase();
                Boolean realWord = null;
                try {
                    realWord = checkword(userWord);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                ArrayList<Character> checkBag = new ArrayList<>();
                for(int i = 0; i < userWord.length(); i++) {
                    checkBag.add(userWord.charAt(i));
                }

                if(letterBoard.containsAll(checkBag) == false) {
                    error.setText("You either used a letter not drawn, or used a letter twice! No points.");
                }
                else if(userWord.length() == 1) {
                    error.setText("One letter is too short! Find a longer word next round!");
                }
                else if(realWord && userWord.length() == 9) {
                    you.addWord(userWord);
                    error.setText("You found a word using all nine letters! You gain 18 points to your score!");
                    //stub Add 18 points to score
                    if (slot1.getText() == "-") {
                        slot1.setText(userWord + "    " + userWord.length());

                    }
                    else if (slot2.getText() == "") {
                        slot2.setText(userWord + "    " + userWord.length());
                    }
                    else if (slot3.getText() == "") {
                        slot3.setText(userWord + "    " + userWord.length());
                    }
                    else if (slot4.getText() == "") {
                        slot4.setText(userWord + "    " + userWord.length());
                    }
                    else if (slot5.getText() == "") {
                        slot5.setText(userWord + "    " + userWord.length());
                    }
                }
                else if(realWord) {
                    error.setText("You found a word of " + userWord.length() + " long! Adding " + userWord.length() + " points to your score!");
                    you.addWord(userWord);
                    //stub add userWord.length() points to playerscore
                        if (slot1.getText().contains("-")) {
                            slot1.setText(userWord + "    " + userWord.length());

                        }
                        else if (slot2.getText().contains("-")) {
                            slot2.setText(userWord + "    " + userWord.length());
                        }
                        else if (slot3.getText().contains("-")) {
                            slot3.setText(userWord + "    " + userWord.length());
                        }
                        else if (slot4.getText().contains("-")) {
                            slot4.setText(userWord + "    " + userWord.length());
                        }
                        else if (slot5.getText().contains("-")) {
                            slot5.setText(userWord + "    " + userWord.length());
                        }

                }
                else {
                    error.setText("That was not a realword, wa waah. No points.");
                }
                //stub to next round



            }
        });




        let1.setForeground(Color.white);

        g.add(submit);
        g.add(let1);
        g.add(letCurrent);


        JButton submitFinal=new JButton("SUBMIT FINAL ANSWER");
        submitFinal.setBounds(90, 460, 200, 40);
        submitFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int score = you.scoreWordRound();
                int timeNow = timer.returnTime();
                scoreRoundFrame(you, score, you.getCurrentScore(),1, you.chooseFinal(), timeNow );
            }
        });


        JButton exit=new JButton("EXIT");
        exit.setBounds(90, 510, 200, 40);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        g.add(error);
        g.add(submitFinal);
        g.add(exit);


        g.setSize(400,600);
        g.setLayout(null);
        g.setVisible(true);
        g.setLocation(500, 200);


        timer.runTimer(30);
    }





    public static void scoreRoundFrame(Player you, int roundScore, int currentScore, int numOrLetter, String answer, int timeNow) {
        timer.stopTimer();
        Font fontB = new Font("Comic Sans", Font.BOLD, 20);
        Font fontM = new Font("Comic Sans", Font.BOLD, 15);
        Font fontS = new Font("Comic Sans", Font.BOLD, 10);
        JFrame scoreRound = new JFrame();
        JLabel title = new JLabel("Round Score");
        title.setBounds(130, 50, 400, 30);
        title.setFont(fontB);



        JLabel answer1 = new JLabel("Your answer was: " + answer);
        answer1.setBounds(10, 100, 380, 30);
        answer1.setFont(fontM);

        if (timeNow == 0) {
            answer1.setText(answer1.getText() + " (No 30 second bonus)");
        }
        else if (timeNow > 0 ) {
            answer1.setText(answer1.getText() + " (30 second bonus)");
        }

        JLabel score1 = new JLabel("Your score for that round is: " + roundScore);
        score1.setBounds(10, 150, 400, 30);
        score1.setFont(fontM);


        JLabel scoreTotal = new JLabel("Your total current score is: " + currentScore);
        scoreTotal.setBounds(10, 200, 400, 30);
        scoreTotal.setFont(fontM);



        JButton next = new JButton("Letter Round ->");
        next.setBounds(10, 250, 370, 30);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                scoreRound.setVisible(false);
                runLetterRound(you, letterBoard, letterBag2, letterBag, delay, period, interval);
            }
        });
        next.setFont(fontM);




        JButton nextNum = new JButton("Number Round ->");
        nextNum.setBounds(10, 250, 370, 30);
        nextNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                scoreRound.setVisible(false);
                runNumberRound(you, numberBoard, numberBag, numberBag2, delay, period, interval);
            }
        });
        nextNum.setFont(fontM);

        JButton exit = new JButton("Exit");
        exit.setBounds(100, 300, 200, 30);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        exit.setFont(fontM);

        scoreRound.add(title);
        scoreRound.add(answer1);
        scoreRound.add(score1);
        scoreRound.add(scoreTotal);
        if(numOrLetter == 0) {
            scoreRound.add(next);
        }
        else if(numOrLetter == 1) {
            scoreRound.add(nextNum);
        }

        scoreRound.add(exit);

        scoreRound.setSize(400,600);
        scoreRound.setLayout(null);
        scoreRound.setVisible(true);
        scoreRound.setLocation(500, 200);
    }



    public static Boolean checkword(String word) throws FileNotFoundException {
        File wordFile = new File("C:\\Users\\dunca\\IdeaProjects\\countdown2\\src\\countdown\\Oxford_full");
        //Scanner wordScanner = null;
        Scanner wordScanner = new Scanner(wordFile);
        /*try {
            wordScanner = new Scanner(wordFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        while (wordScanner.hasNextLine()) {
            String firstWord = wordScanner.next();
            firstWord = firstWord.toLowerCase();
            if (firstWord.equals(word)) {
                return true;
            } else {
                wordScanner.nextLine();
            }
        }
        return false;
    }

}



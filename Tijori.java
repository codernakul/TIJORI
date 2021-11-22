import java.util.*;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;
public class Tijori extends JFrame
{
    private JMenuBar menuBar;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JTextArea textarea1;

    int check=0;  //to check first generate
    static String crntPass="";  //current password

    public Tijori()
    {
        logs();
        this.setTitle("Tijori - By Nakul Singh");
        this.setSize(400,150);
        //ImageIcon iconI=new ImageIcon(Tijori.class.getResource("/pgIcon.png"));
        Image icon = Toolkit.getDefaultToolkit().getImage(Tijori.class.getResource("/resources/pgIcon.png")); 
        this.setIconImage(icon);
        generateMenu();
        this.setJMenuBar(menuBar);
        this.setResizable(false);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(400,150));
        contentPane.setBackground(new Color(153,153,255));
        button1 = new JButton();
        button1.setBounds(50,65,140,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Generate Password");
        button1.setVisible(true);
        button2 = new JButton();
        button2.setBounds(210,65,140,35);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(false);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Copy to Clipboard");
        button2.setVisible(true);
        button2.setToolTipText("Nothing to Copy");
        label1 = new JLabel();
        label1.setBounds(50,110,300,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",1,14));
        label1.setText("                Made by NAKUL SINGH");
        label1.setVisible(true);
        textarea1 = new JTextArea();
        textarea1.setBounds(50,15,300,45);
        textarea1.setBackground(new Color(255,255,255));
        textarea1.setForeground(new Color(0,0,0));
        textarea1.setEnabled(false);
        //textarea1.setEditable(false);
        textarea1.setLineWrap(true);
        textarea1.setWrapStyleWord(true);
        textarea1.setToolTipText("Password will appear Here");
        textarea1.setFont(new Font("Courier New",1,15));
        textarea1.setText("Password will appear Here");
        textarea1.setBorder(BorderFactory.createBevelBorder(1,Color.white,Color.black));
        textarea1.setVisible(true);
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(label1);
        contentPane.add(textarea1);
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        button1.addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent evt) 
                {
                    generate(evt);
                }
            });
        button2.addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent evt) 
                {
                    clipIt(evt);
                }
            });

    }

    private void key()
    {
        try
        {
            File file = new File(Path.path()+"\\key.txt");
            if(!file.exists())
            {
                JOptionPane.showMessageDialog(null , "Namaste!\nWelcome to Tijori!\nIn the next prompt enter a \"master key\"\nThat is going to be only password\nyou will have to remember from now on :)");
                PrintWriter pwr=new PrintWriter(new BufferedWriter(new FileWriter(Path.path()+"\\key.txt")));
                String key = JOptionPane.showInputDialog(null , "Enter your master key: ","Type key Here");
                pwr.print(key);
                pwr.close();
            }
        }
        catch(Exception e)
        {
            //here goes nothing
        }
    }

    private void logs()
    {
        try
        {
            File file = new File(Path.path());
            boolean bool = file.mkdir();
            PrintWriter pwr=new PrintWriter(new BufferedWriter(new FileWriter(Path.path()+"\\logs.txt",true)));
            key();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error : 01","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generateMenu()
    {
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu Option = new JMenu("Options");
        JMenu About = new JMenu("About");

        JMenuItem gen = new JMenuItem("Generate New Password   ");
        gen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK));

        /*JMenuItem genQR = new JMenuItem("Generate QR Code   ");
        genQR.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,Event.CTRL_MASK));*/

        JMenuItem open = new JMenuItem("Open Saved Passwords   ");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,Event.CTRL_MASK));

        JMenuItem save = new JMenuItem("Save   ");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));

        JMenuItem exit = new JMenuItem("Exit   ");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,Event.CTRL_MASK));

        JMenuItem length = new JMenuItem("Change Length of Passwords    ");
        JMenuItem pdf = new JMenuItem("Export Passwords to PDF    ");

        JMenuItem about = new JMenuItem("About Tijori    ");
        JMenuItem version = new JMenuItem("Version History   ");
        JMenuItem author = new JMenuItem("About Author   ");

        gen.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    //                     try
                    //                     {
                    gen(evt);
                    //                     }
                    //                     catch(IOException e)
                    //                     {
                    //                         JOptionPane.showMessageDialog(null,"Error: opening the file\nPlease report at nakul3301.blogspot.com");
                    //                     }
                }
            });
        /*genQR.addActionListener(new ActionListener() 
        {
        public void actionPerformed(ActionEvent evt) 
        {
        try
        {
        genQR(evt);
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"Error: opening the file\nPlease report at nakul3301.blogspot.com");
        }
        }
        });*/
        open.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    //                     try
                    //                     {
                    open(evt);
                    //                     }
                    //                     catch(IOException e)
                    //                     {
                    //                         JOptionPane.showMessageDialog(null,"Error: opening the file\nPlease report at nakul3301.blogspot.com");
                    //                     }
                }
            });

        save.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    //                     try
                    //                     {
                    save(evt);
                    //                     }
                    //                     catch(IOException e)
                    //                     {
                    //                         JOptionPane.showMessageDialog(null,"Error: saving the file\nPlease report at nakul3301.blogspot.com");
                    //                     }
                }
            });

        exit.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt) 
                {
                    exit(evt);
                }
            });

        length.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    length(evt);
                }
            });

        pdf.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    pdf(evt);
                }
            });

        about.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    about(evt);
                }
            });

        version.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    version(evt);
                }
            });

        author.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    author(evt);
                }
            });

        file.add(gen);
        //file.addSeparator();
        //file.add(genQR);
        file.addSeparator();
        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        Option.add(length);
        Option.addSeparator();
        Option.add(pdf);
        About.add(about);
        About.add(version);
        About.add(author);

        menuBar.add(file);
        menuBar.add(Option);
        menuBar.add(About);
    }

    private void gen (ActionEvent evt) //function calling generate function using menu
    {
        generate();
    }

    /*private void genQR (ActionEvent evt)throws Exception
    {
    String temp=textarea1.getText();
    if(temp=="Password will appear Here")
    temp="";
    if(temp!=""&&temp!="Password will appear Here")
    {

    QRCodeGenerator.qrGen("QRG",temp);
    ImageIcon imgIcon = new ImageIcon(Path.path()+"\\QRG-qr.png");
    JOptionPane.showMessageDialog(null,"QR Code for\n"+temp,"Tijori",JOptionPane.PLAIN_MESSAGE,imgIcon);
    File file=new File(Path.path()+"\\QRG-qr.png");
    file.delete();
    }
    else
    JOptionPane.showMessageDialog(null, "There is nothing to Generate\nEnter something in Text Area", "Tijori", JOptionPane.ERROR_MESSAGE);
    }*/

    private void open (ActionEvent evt)
    {
        Open.open();
    }

    private void save (ActionEvent evt)
    {
        if(check>0)
        {
            Save.save();
        }
        else
            JOptionPane.showMessageDialog(null, "There is nothing to save", "Tijori", JOptionPane.ERROR_MESSAGE);
    }

    private void exit (ActionEvent evt)
    {
        System.exit(0);
    }

    private void length (ActionEvent evt)
    {
        Length.changeLength();
    }

    private void pdf (ActionEvent evt)
    {
        this.setCursor(Cursor.WAIT_CURSOR);
        PDF.create();
        this.setCursor(Cursor.DEFAULT_CURSOR);
        //JOptionPane.showMessageDialog(null, "There is nothing to save", "PasswordGenerator", JOptionPane.ERROR_MESSAGE);
    }

    private void about (ActionEvent evt)
    {
        ImageIcon icon=new ImageIcon(Tijori.class.getResource("/resources/pgIcon.png"));
        JOptionPane.showMessageDialog(null,"Tijori\u00A9 Nakul Singh\n\nIt is an Application written in pure java\nand Wrapped into an convenient exe\nThis application will help you generate\nand manage passwords.\nthis app saves passwords on your PC locally\nunlike other cloud services which one\nway or the other is harmful.\nThe passwords generated using this app\nare so stong that it will take any computer\nmore than a quadrillion years to crack.","About Tijori", JOptionPane.INFORMATION_MESSAGE,icon);
    }

    private void version (ActionEvent evt)
    {
        ImageIcon icon=new ImageIcon(Tijori.class.getResource("/resources/pgIcon.png"));
        JOptionPane.showMessageDialog(null,"\tversion 1.3.0\n\n1.0.0-App with only CMD interface\n1.0.1-Now copies password to Clipboard\n1.1.0-Introduced GUI with previous features\n1.1.2-Can Save and View Passwords\n1.2.0-Now available as a Standalone executable\n1.2.1-Minor Bug fixes\n1.2.2-Enhanced UI and fixed duplicate file glitch\n[Latest]1.3.0-Latest version\nMajor Update: Changelog\n-PasswordGenerator now called Tijori\n-Encrypted data files\n-Can change length of passwords generated\n-Export passwords to PDF option added\n-Generates QR code of passwords\n-Viewing passwords now requires a key","Version History", JOptionPane.INFORMATION_MESSAGE,icon);
    }

    private void author (ActionEvent evt)
    {
        ImageIcon icon=new ImageIcon(Tijori.class.getResource("/resources/pgIcon.png"));
        JOptionPane.showMessageDialog(null,"Hello,\nNakul here :)\nIf  you have this app, you must have got it directly from me\nPlease do not distribute my app if you respect my work\n\nIf you find any problem in my work please report me","About Author", JOptionPane.INFORMATION_MESSAGE,icon);
    }

    private void generate (MouseEvent evt)  //function calling generate function using button
    {
        generate();
    }

    private void generate()  //the function that generates password
    {
        ++check;
        crntPass=Password.cPW();
        textarea1.setEnabled(true);
        button2.setEnabled(true);
        textarea1.setText(crntPass);
        button2.setToolTipText("Copy - "+textarea1.getText());
    }

    private void clipIt(MouseEvent evt)
    {
        if(textarea1.getText()!="")
        {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            StringSelection strSel = new StringSelection(textarea1.getText());
            clipboard.setContents(strSel, null); 
        }
        else
            JOptionPane.showMessageDialog(null, "There is nothing to Copy", "PasswordGenerator", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args)
    {
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    new Tijori();
                    //Mess begins here
                }
            });
    }
}
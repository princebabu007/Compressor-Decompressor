package GUI;

import Comp_Decomp.Compressor;
import Comp_Decomp.Decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Prince Babu
 */
public class AppFrame extends JFrame implements ActionListener{

    JButton compressButton;
    JButton decompressButton;


    @SuppressWarnings("LeakingThisInConstructor")
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        compressButton = new JButton("To Compress");
        compressButton.setBounds(150 ,100,200,30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("To Decompress");
        decompressButton.setBounds(400,100,200,30);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(800, 500);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response =filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }

}
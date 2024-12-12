package it.unibo.es3;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {
    
    private final List<JButton> cells = new ArrayList<>();
    private final Logics logics;
    
    public GUI(int width) {
        this.logics = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel);
        
        ActionListener al = e -> {
            if (this.logics.toQuit()) {
                System.exit(0);
            }
            this.logics.advance().forEach(p -> this.cells.get(p.getX() + p.getY() * width).setText("*"));
        };
                
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
            	var pos = new Pair<>(j,i);
                final JButton jb = new JButton();
                this.cells.add(jb);
                jb.addActionListener(al);
                logics.getInitalPositions().forEach(p -> {
                    if (pos.equals(p)) {
                        jb.setText("*");
                    }
                });
                panel.add(jb);
            }
        }
        this.setVisible(true);
    }
    
}
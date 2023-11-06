package firstproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class SimplePaintApp extends JFrame {
    private enum Tool { PENCIL, ERASER, LINE, RECTANGLE, OVAL, CIRCLE, TRIANGLE, ELLIPSE }

    private Tool currentTool = Tool.PENCIL;
    private Color currentColor = Color.BLACK;
    private int x1, y1, x2, y2;
    private BufferedImage canvas;

    public SimplePaintApp() {
        canvas = new BufferedImage(1000, 800, BufferedImage.TYPE_INT_ARGB);
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(canvas, 0, 0, this);
            }
        };
        drawingPanel.setBackground(Color.WHITE);

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                Graphics2D g2d = canvas.createGraphics();
                g2d.setColor(currentColor);

                switch (currentTool) {
                    case PENCIL:
                        g2d.drawLine(x1, y1, x2, y2);
                        break;
                    case ERASER:
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
                        g2d.drawLine(x1, y1, x2, y2);
                        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
                        break;
                    case LINE:
                        g2d.drawLine(x1, y1, x2, y2);
                        break;
                    case RECTANGLE:
                        g2d.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                        break;
                    case OVAL:
                        g2d.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
                        break;
                    case CIRCLE:
                        int diameter = Math.min(Math.abs(x2 - x1), Math.abs(y2 - y1));
                        g2d.drawOval(x1, y1, diameter, diameter);
                        break;
                    case TRIANGLE:
                    	 int[] xPoints = {x1, x2,x1 - (x2 - x1)};
                    	    int[] yPoints = {y1, y2, y2};
                    	    g2d.drawPolygon(xPoints, yPoints, 3);
                    	 break;
                    case ELLIPSE:
                    	  g2d.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                                  Math.abs(x1 - x2), Math.abs(y1 - y2));
                }
                g2d.setColor(currentColor);
                g2d.dispose();
                drawingPanel.repaint();
            }
        });

        getContentPane().add(drawingPanel, BorderLayout.CENTER);
                drawingPanel.setLayout(null);
                        
                        JPanel panel_1 = new JPanel();
                        panel_1.setLayout(null);
                        panel_1.setBackground(new Color(0, 0, 128));
                        panel_1.setBounds(0, 0, 1697, 115);
                        drawingPanel.add(panel_1);
                        
                       
                        
                        JButton btnNewButton_1 = new JButton("Login");
                        btnNewButton_1.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		dialogin r3 = new dialogin();
                        		r3.setVisible(true);
                        		r3.setLocation(922, 10);
                        	}
                        });
                        btnNewButton_1.setForeground(Color.WHITE);
                        btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 22));
                        btnNewButton_1.setBorder(null);
                        btnNewButton_1.setBackground(new Color(0, 0, 128));
                        btnNewButton_1.setBounds(1354, 0, 137, 41);
                        panel_1.add(btnNewButton_1);
                        
                        JLabel lblNewLabel_1 = new JLabel("New label");
                        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\chalk\\Downloads\\icons8-painting-a-wall-96.png"));
                        lblNewLabel_1.setBounds(10, 10, 97, 99);
                        panel_1.add(lblNewLabel_1);
                        
                        JLabel lblNewLabel_2 = new JLabel("COLOURED CANVAS");
                        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
                        lblNewLabel_2.setForeground(new Color(250, 250, 210));
                        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
                        lblNewLabel_2.setBounds(117, 19, 283, 34);
                        panel_1.add(lblNewLabel_2);
                        
                        JButton btnNewButton_2 = new JButton("HOME\r\n");
                        btnNewButton_2.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		rooms r3 = new rooms();
                        		r3.setVisible(true);
                        		r3.setExtendedState(MAXIMIZED_BOTH);
                        	}
                        });
                        btnNewButton_2.setForeground(Color.WHITE);
                        btnNewButton_2.setFont(new Font("Sitka Text", Font.BOLD, 20));
                        btnNewButton_2.setBorder(null);
                        btnNewButton_2.setBackground(new Color(0, 0, 128));
                        btnNewButton_2.setBounds(381, 71, 161, 38);
                        panel_1.add(btnNewButton_2);
                        
                        JButton btnAboutUs = new JButton("ABOUT ");
                        btnAboutUs.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		about r3 = new about();
                        		r3.setVisible(true);
                        		r3.setExtendedState(MAXIMIZED_BOTH);
                        	}
                        });
                        btnAboutUs.setForeground(Color.WHITE);
                        btnAboutUs.setFont(new Font("Sitka Text", Font.BOLD, 20));
                        btnAboutUs.setBorder(null);
                        btnAboutUs.setBackground(new Color(0, 0, 128));
                        btnAboutUs.setBounds(520, 71, 178, 38);
                        panel_1.add(btnAboutUs);
                        
                        JButton btnRooms = new JButton("ROOMS\r\n");
                        btnRooms.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		room1 r3 = new room1();
                        		r3.setVisible(true);
                        		r3.setExtendedState(MAXIMIZED_BOTH);
                        	}
                        });
                        btnRooms.setForeground(Color.WHITE);
                        btnRooms.setFont(new Font("Sitka Text", Font.BOLD, 20));
                        btnRooms.setBorder(null);
                        btnRooms.setBackground(new Color(0, 0, 128));
                        btnRooms.setBounds(656, 71, 178, 38);
                        panel_1.add(btnRooms);
                        
                        JButton btnReview = new JButton("REVIEW");
                        btnReview.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		reviews r3 = new reviews();
                        		r3.setVisible(true);
                        		r3.setExtendedState(MAXIMIZED_BOTH);
                        	}
                        });
                        btnReview.setForeground(Color.WHITE);
                        btnReview.setFont(new Font("Sitka Text", Font.BOLD, 20));
                        btnReview.setBorder(null);
                        btnReview.setBackground(new Color(0, 0, 128));
                        btnReview.setBounds(1111, 71, 178, 38);
                        panel_1.add(btnReview);
                        
                        JButton btnCustomize = new JButton("CUSTOMIZE");
                        btnCustomize.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		SimplePaintApp sm = new SimplePaintApp();
                        		sm.setVisible(true);
                        		sm.setExtendedState(MAXIMIZED_BOTH);
                        	}
                        });
                        btnCustomize.setForeground(Color.WHITE);
                        btnCustomize.setFont(new Font("Sitka Text", Font.BOLD, 20));
                        btnCustomize.setBorder(null);
                        btnCustomize.setBackground(new Color(0, 0, 128));
                        btnCustomize.setBounds(810, 71, 178, 38);
                        panel_1.add(btnCustomize);
                        
                        JButton btnContact = new JButton("CONTACT");
                        btnContact.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		contact r3 = new contact();
                        		r3.setVisible(true);
                        		r3.setExtendedState(MAXIMIZED_BOTH);
                        	}
                        });
                        btnContact.setForeground(Color.WHITE);
                        btnContact.setFont(new Font("Sitka Text", Font.BOLD, 20));
                        btnContact.setBorder(null);
                        btnContact.setBackground(new Color(0, 0, 128));
                        btnContact.setBounds(965, 71, 178, 38);
                        panel_1.add(btnContact);
                        
                        JPanel panel = new JPanel();
                        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
                        panel.setBackground(Color.WHITE);
                        panel.setBounds(994, 200, 520, 227);
                        drawingPanel.add(panel);
                        panel.setLayout(null);
                        
                        JLabel lblNewLabel = new JLabel("SHAPES\r\n\r\n");
                        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
                        lblNewLabel.setBounds(10, 10, 131, 64);
                        panel.add(lblNewLabel);
                        
                        JButton lineButton = new JButton("Line");
                        lineButton.setBackground(Color.WHITE);
                        lineButton.setBorder(new RoundedBorder(20));
                        lineButton.setBounds(20, 81, 131, 64);
                        panel.add(lineButton);
                        lineButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                       
                        JButton rectangleButton = new JButton("Rectangle");
                        rectangleButton.setBackground(Color.WHITE);
                        rectangleButton.setBorder(new RoundedBorder(20));
                        rectangleButton.setBounds(20, 155, 131, 59);
                        panel.add(rectangleButton);
                        rectangleButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        
                        JButton ovalButton = new JButton("Oval");
                        ovalButton.setBackground(Color.WHITE);
                        ovalButton.setBorder(new RoundedBorder(20));
                        ovalButton.setBounds(201, 81, 118, 64);
                        panel.add(ovalButton);
                        ovalButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        
                        
                        JButton circleButton = new JButton("Circle");
                        circleButton.setBackground(Color.WHITE);
                        circleButton.setBorder(new RoundedBorder(20));
                        circleButton.setBounds(201, 155, 118, 59);
                        panel.add(circleButton);
                        circleButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        
                        JButton triangleButton = new JButton("Triangle");
                        triangleButton.setBorder(new RoundedBorder(20));
                        triangleButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        triangleButton.setBackground(Color.WHITE);
                        triangleButton.setBounds(372, 81, 113, 52);
                        panel.add(triangleButton);
                        
                        JButton ellipseButton = new JButton("Ellipse");
                        ellipseButton.setBorder(new RoundedBorder(20));
                        ellipseButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        ellipseButton.setBackground(Color.WHITE);
                        ellipseButton.setBounds(372, 162, 113, 52);
                        panel.add(ellipseButton);
                        ellipseButton.addActionListener(e -> currentTool = Tool.ELLIPSE);
                        triangleButton.addActionListener(e -> currentTool = Tool.TRIANGLE);
                        circleButton.addActionListener(e -> currentTool = Tool.CIRCLE);
                        ovalButton.addActionListener(e -> currentTool = Tool.OVAL);
                        rectangleButton.addActionListener(e -> currentTool = Tool.RECTANGLE);
                        lineButton.addActionListener(e -> currentTool = Tool.LINE);
                        
                        JPanel panel_2 = new JPanel();
                        panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
                        panel_2.setBackground(Color.WHITE);
                        panel_2.setBounds(994, 464, 520, 148);
                        drawingPanel.add(panel_2);
                        panel_2.setLayout(null);
                        
                        JLabel lblTools = new JLabel("TOOLS");
                        lblTools.setFont(new Font("Times New Roman", Font.BOLD, 30));
                        lblTools.setBounds(10, 0, 131, 64);
                        panel_2.add(lblTools);
                       
                        JButton pencilButton = new JButton("Pencil");
                        pencilButton.setBackground(Color.WHITE);
                        pencilButton.setBorder(new RoundedBorder(20));
                        pencilButton.setBounds(20, 69, 121, 69);
                        panel_2.add(pencilButton);
                        pencilButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                       
                        JButton eraserButton = new JButton("Eraser");
                        eraserButton.setBackground(Color.WHITE);
                        eraserButton.setBorder(new RoundedBorder(20));
                        eraserButton.setBounds(195, 69, 121, 69);
                        panel_2.add(eraserButton);
                        eraserButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        
                        JButton btnSelect = new JButton("Select");
                        btnSelect.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		 Color newColor = JColorChooser.showDialog(btnSelect, "Choose Color", currentColor);
                        	        if (newColor != null) {
                        	        	currentColor = newColor;
                        	        }
                        	}
                        });
                        btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        btnSelect.setBorder(new firstproject.RoundedBorder(20));
                        btnSelect.setBackground(Color.WHITE);
                        btnSelect.setBounds(376, 69, 121, 69);
                        panel_2.add(btnSelect);
                        eraserButton.addActionListener(e -> currentTool = Tool.ERASER);
                        pencilButton.addActionListener(e -> currentTool = Tool.PENCIL);
                        
                        JButton clearButton = new JButton("Clear");
                        clearButton.setBounds(1407, 640, 107, 37);
                        drawingPanel.add(clearButton);
                        clearButton.setBackground(Color.WHITE);
                        clearButton.setBorder(new RoundedBorder(20));
                        clearButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        
                        JLabel lblNewLabel_2_2 = new JLabel("New label");
                        lblNewLabel_2_2.setIcon(new ImageIcon("C:\\Users\\chalk\\Downloads\\icons8-star-30.png"));
                        lblNewLabel_2_2.setBounds(10, 160, 37, 30);
                        drawingPanel.add(lblNewLabel_2_2);
                        
                        JLabel lblNewLabel_4 = new JLabel("Create your design");
                        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                        lblNewLabel_4.setBounds(44, 146, 233, 47);
                        drawingPanel.add(lblNewLabel_4);
                        
                        JLabel lblNewLabel_3 = new JLabel("");
                        lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
                        lblNewLabel_3.setBounds(44, 201, 900, 544);
                        drawingPanel.add(lblNewLabel_3);
                        
                        JButton btnSave = new JButton("Save");
                        btnSave.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		try{
                                    Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                                    screenRect.setBounds(50, 240, 879, 504);
                                    BufferedImage capture = new Robot().createScreenCapture(screenRect);
                                    ImageIcon icon = new ImageIcon(capture);
                                    
                                    ImageIO.write(capture, "PNG", new File("C:\\Users\\chalk\\OneDrive\\Desktop\\project\\design.png"));
                                }
                                catch(Exception e5){
                                    JOptionPane.showMessageDialog(null,e5);
                                    
                                }
                        	}
                        });
                        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
                        btnSave.setBorder(new firstproject.RoundedBorder(20));
                        btnSave.setBackground(Color.WHITE);
                        btnSave.setBounds(1006, 640, 107, 37);
                        drawingPanel.add(btnSave);
                        
                       
                                clearButton.addActionListener(e -> {
                                    clearCanvas();
                                    drawingPanel.repaint();
                                });

        setSize(1584, 882);
        setVisible(true);
    }

    private void clearCanvas() {
        Graphics2D g2d = canvas.createGraphics();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
        g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        g2d.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimplePaintApp());
    }
}
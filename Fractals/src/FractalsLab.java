/**
 * Name:
 * Section: 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FractalsLab extends JApplet implements ActionListener, ChangeListener
{
	Timer t;
	int x = 0;
	int y = 0;
	int ox = 1;
	int oy= 3;
	JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL, 0, 90, 0);
	
	public static void main(String[] arg){
		FractalsLab l = new FractalsLab();
	}
	
	public FractalsLab(){
		t = new Timer(1000,this);
		t.start();
	}
	int r, gr, b;
	boolean one = false;
	
	
	public void paint(Graphics g)
	{
		/*super.paint(g);
		this.setSize(800, 600); //canvas width and height
		 Graphics2D g2 = (Graphics2D) g;

		circular(g, 100,100, 0);
		*/
		
		this.setSize(800, 600); //canvas width and height
		//rings(g, 400, 0, 0);
		
		//clover(g, 300, 0, 0);
		
		pac(g, 200, x, y);
		
		
	}
	
	int bf = (int) ((200-10)/(2*Math.PI*100));
	int deg;
	public void spiral(Graphics g, int rad, int deg){
		
	
	}
	
	
	public void rings(Graphics g, int radius, int x, int y){
		//each method call draws one part of the fractal
		g.drawOval(x,y,radius, radius);
		//it will then invoke itself to draw the rest of the pattern
		//when are we done drawing rings?!
		if(radius > 10){
			//call the next method to draw the next ring!!
			rings(g, radius - 10, x + 5 , y + 5);
			
		}
	
	}
	
	public void clover (Graphics g, int radius, int x, int y){
		g.drawOval(x, y, radius, radius);
		g.drawOval(x+radius, y, radius, radius);
		g.drawOval(x, y+radius, radius, radius);
		g.drawOval(x+radius, y+radius, radius, radius);

		if(radius > 10){
			clover(g, radius - 10, x + 10, y+10);
		}
	}
	
	
	public void circular(Graphics g, int x, int y, int d){
		g.drawOval((int)(Math.cos(d)+100), (int)(Math.sin(d)+100), 100, 100);
		if(d>0){
			circular( g, x, y, d-2);
		}
	}
	
	public void pac (Graphics g, int radius, int x, int y){
		/*int w = 800;
		int h = 600;
		int a = (w/2)-radius;
		int b = (h/2)-radius;
		g.fillRect(a, b, radius, radius);
		/*if (radius > 10){
			pac(g, radius/3, a/3, b/3);
		}
		
		g.fillRect(a+radius, b+radius, radius/3, radius/3);
		//g.drawRect(x/3, y/3, radius/3, radius/3);

		if(radius > 10){
			pac(g, radius/3, x, y);
		}
		*/
		int h = 300;
		int w = 400;
		
		g.fillRect(w-radius/2, h-radius/2, radius, radius);
		
		if (radius > 10){
			pac(g, radius/3, w/3, y);
			pac(g, radius/3, w/3, y-radius);
			pac(g, radius/3, w/3-radius, y-radius);

			
		}
		
		
	}
	
	public void no (Graphics g, int radius, int x, int y){
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
		x+=ox;
		y+=oy;
		if(x>600 || x<=0){
			x = 0;
			ox *=-1;
		}
		if(y>600||y<=0){
			y = 0;
			oy *= -1;
		}

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("here");
	}
	
}



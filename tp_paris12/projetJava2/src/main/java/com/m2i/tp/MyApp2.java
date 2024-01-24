package com.m2i.tp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MyApp2 {
	public static void main(String[] args) {
		String message="coucou"; //par défaut
		
		if(args.length>0) message=args[0];
		
		String enMaj=System.getProperty("enMaj");
		if(enMaj!=null && enMaj.equals("true"))
			message=message.toUpperCase();
		
		JOptionPane.showMessageDialog(null/*fenetre parente*/, message);
	}
	
	
}

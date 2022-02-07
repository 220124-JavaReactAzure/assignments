package com.revature.banking_app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.util.Scanner;

//import com.revature.monster_lab.models.Scientist;
import com.revature.banking_app.util.AppState;


public class appDriver {
	
	public static void main(String[] args) {
		AppState app = new AppState();
		app.startup();
	}
}


package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import entity.grafo.Grafo;

public class InputInstance {
	
	public static Grafo getInstance(String file) {
		
		Grafo grafo = new Grafo();
	
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		
		try {
			
			is = new FileInputStream(file);
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);
			String line;
			while( ( line = br.readLine() ) !=null) {
				int numeroVertices = Integer.parseInt(line);
				for(int i=0; i<numeroVertices; i++) {
					line = br.readLine();
					String nomeVertice = line.trim();
					grafo.addVertice(nomeVertice);
				}
				line = br.readLine();
				int numeroArestas = Integer.parseInt(line);
				for(int i=0; i<numeroArestas; i++) {
					line = br.readLine();
					String[] nomes = line.split(" ");
					String nomeAresta = nomes[0];
					String nomeV1 = nomes[1];
					String nomeV2 = nomes[2];
					grafo.addAresta(nomeAresta, nomeV1, nomeV2);
				}
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return grafo;
		
		
	}

}


//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//
//public class TesteInputText {
//	
//	public static void main(String[] args) {
//		
//		InputStream is;
//		InputStreamReader isr;
//		BufferedReader br;
//		
//		try {
//			
//			is = new FileInputStream("files/arquivo.in");
//			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
//			br = new BufferedReader(isr);
//			String line;
//			while( ( line = br.readLine() ) !=null) {
//				System.out.println(line);
//			}
//			
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//	}
//
//}

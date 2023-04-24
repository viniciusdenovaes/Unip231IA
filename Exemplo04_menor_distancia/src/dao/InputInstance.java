package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import entity.EspacoEstados;
import entity.Estado;
import entity.grafo.Aresta;
import entity.grafo.Coordenada;
import entity.grafo.Grafo;
import entity.grafo.Vertice;

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
			line = br.readLine();
			
			// Primeiro adiciona cada vertice
			int numeroVertices = Integer.parseInt(line);
			for(int i=0; i<numeroVertices; i++) {
				line = br.readLine();
				String[] dados = line.split(" ");
				String nome = dados[0];
				double x = Double.parseDouble(dados[1]);
				double y = Double.parseDouble(dados[2]);
				grafo.addVertice(new Vertice(nome, new Coordenada(x, y)));
			}
			
			// Depois adicionamos as arestas
			line = br.readLine();
			int numeroArestas = Integer.parseInt(line);
			for(int i=0; i<numeroArestas; i++) {
				line = br.readLine();
				String[] dados = line.split(" ");
				String nomeV1 = dados[0];
				Vertice v1 = grafo.getVertice(nomeV1);
				String nomeV2 = dados[1];
				Vertice v2 = grafo.getVertice(nomeV2);
				double peso = Double.parseDouble(dados[2]);
				grafo.addAresta(new Aresta(v1, v2, peso));
			}
			String nomeVInicial = br.readLine();
			EspacoEstados.estadoInicial = new Estado(grafo.getVertice(nomeVInicial));
			String nomeVObjetivo = br.readLine();
			EspacoEstados.estadoObjetivo = new Estado(grafo.getVertice(nomeVObjetivo));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return grafo;
		
	}

}


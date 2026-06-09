package it.uniroma3.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.attrezzi.ComparatorePerNome;
import it.uniroma3.attrezzi.ComparatorePerPeso;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private static final int TreeSet = 0;
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>(); 
	}
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi)
			peso += a.getPeso();
		return peso;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo==null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.add(attrezzo);
		return true;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzo = null;
		for (Attrezzo a : this.attrezzi)
			if (a.getNome().equals(nomeAttrezzo))
				attrezzo = a;
		return attrezzo;
	}
	
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzo = null;
		for (Attrezzo a : this.attrezzi)
			if (a.getNome().equals(nomeAttrezzo)) {
				attrezzo = a;
				this.attrezzi.remove(a);
			}			
		return attrezzo;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ComparatorePerPeso cmp = new ComparatorePerPeso();
		Collections.sort(this.attrezzi,cmp);
		return this.attrezzi;
	}
	
	public  SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> ordinata = new TreeSet<>(new ComparatorePerNome());
		ordinata.addAll(this.attrezzi);
		return ordinata;
	}
	
	public  Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		for(Attrezzo a : this.attrezzi) {
			Integer peso = a.getPeso();
			if(!mappa.containsKey(peso)) {
				mappa.put(peso, new HashSet<>());
			}
			mappa.get(peso).add(a);
		}
		return mappa;
	}
	
	public  SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> ordinata = new TreeSet<>(new ComparatorePerPeso());
		ordinata.addAll(this.attrezzi);
		return ordinata;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo a : this.attrezzi)
				s.append(a.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
}

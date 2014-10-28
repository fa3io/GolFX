package br.com.golfx;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	List<Produto> produtos = new ArrayList<>();
	
	
	public void add(Produto...produtos){
		
		for (Produto produto : produtos) {
			this.produtos.add(produto);
		}
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

}

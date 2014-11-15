package br.com.golfx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrinho {
	
	List<Produto> produtos = new ArrayList<>();
	
	
	public void add(Produto...produtos){
		
		for (Produto produto : produtos) {
			this.produtos.add(produto);
		}
	}
	public void remover(Produto produto){
		Iterator<Produto> itProduto = produtos.iterator();
		while (itProduto.hasNext()) {
			Produto p = (Produto) itProduto.next();
			
			if(p.getNome().equals(produto.getNome()) && p.getPreco() == produto.getPreco()){
				itProduto.remove();
			}
			
		}
	}
	public void removerAll( ){
		this.produtos.removeAll(getProdutos());
		
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

}

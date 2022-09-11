package com.gabriel.augusto.consertandootabu;

import java.util.Date;

public class NoticiaVo {

    private String conteudoNoticia;

    private String dataDaPostagem;

    private int autor;

    private int imagem;

    private String titulo;

    public String getConteudoNoticia() {
        return conteudoNoticia;
    }

    public void setConteudoNoticia(String conteudoNoticia) {
        this.conteudoNoticia = conteudoNoticia;
    }

    public String getDataDaPostagem() {
        return dataDaPostagem;
    }

    public void setDataDaPostagem(String dataDaPostagem) {
        this.dataDaPostagem = dataDaPostagem;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
